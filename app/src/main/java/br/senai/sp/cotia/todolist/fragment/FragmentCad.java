package br.senai.sp.cotia.todolist.fragment;

import android.app.DatePickerDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.Toast;

import java.util.Calendar;

import br.senai.sp.cotia.todolist.database.AppDatabase;
import br.senai.sp.cotia.todolist.databinding.FragmentCadBinding;
import br.senai.sp.cotia.todolist.model.Tarefa;

public class FragmentCad extends Fragment {

    private FragmentCadBinding binding;

    //variavel para acessar a database
    AppDatabase database;

    //variavel para o datepicker
    DatePickerDialog datePicker;

    //variável para ano mes e dia
    int day, year, month;

    //variável para a data atual
    Calendar dataAtual;

    //variável para a data formatada
    String dataEscolhida = "";




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //instanciar a appdata que conectara a aplicação com o BD
        database = AppDatabase.getDatabase(getActivity());

        // Inflate the layout for this fragment
        binding = FragmentCadBinding.inflate(inflater, container, false);

        //descobrindo data atual
        dataAtual = Calendar.getInstance();

        //descobre o dia mes e ano atuais
        year = dataAtual.get(Calendar.YEAR);
        month = dataAtual.get(Calendar.MONTH);
        day = dataAtual.get(Calendar.DAY_OF_MONTH);

        //instanciando o datePicker
        datePicker = new DatePickerDialog(getContext(),(view, ano,mes,dia) -> {
            //cai aqui toda vez que clica no OK do datePicker

            //passa para as variáveis globais
            year = ano;
            month = mes;
            day = dia;

            //formata a String da data escolhida
            dataEscolhida = String.format("%02d/%02d/%04d", day, month+1,year);

/*
            //jogar a String no botão
            binding.buttonData.setText(dataEscolhida);
*/

        },year,month,day);

        //listener do botao data
        binding.buttonData.setOnClickListener(v ->{
            //abre o datePicker
            datePicker.show();

        });
        //listener do botão salvar
        binding.buttonSave.setOnClickListener(v-> {
            //validar os campos
            if (binding.editTitulo.getText().toString().isEmpty()) {
                Toast.makeText(getContext(), "Digite um título", Toast.LENGTH_LONG).show();

            } else if (dataEscolhida.isEmpty()) {
                Toast.makeText(getContext(), "Informe uma data de previsão", Toast.LENGTH_LONG).show();
            }else {

                //criar um objeto tarefa
                Tarefa tarefa = new Tarefa();

                //populando um objeto Tarefa
                tarefa.setTitulo(binding.editTitulo.getText().toString());
                tarefa.setDescricao(binding.editDescricao.getText().toString());

                //criando o Calendar para obter e popula com a data selecionada
                Calendar dataRealizacao = Calendar.getInstance();
                dataRealizacao.set(year, month, day);

                //passa para a tarefa para pegar os milisegundos da data
                tarefa.setDataPrevista(dataRealizacao.getTimeInMillis());

                //pegando a data atual e setando na data de criação
                Calendar dataAtual = Calendar.getInstance();
                tarefa.setDataCricao(dataAtual.getTimeInMillis());

                //salvar a Tarefa
                new InsertTarefa().execute(tarefa);

            }

        });


        return binding.getRoot();
    }

    //classe para a tesc de inserir tarefa
    private class InsertTarefa extends AsyncTask<Tarefa, Void, String>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Log.w("Passou", "On pre execute");
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
            Log.w("Passou", "OnProgressUptade" );
        }

        @Override
        protected String doInBackground(Tarefa... tarefas) {
            //publica o progresso
            publishProgress();

            //extrair tarefa do vetor de tarefa
            Tarefa t = tarefas[0];

            try {

                    database.getTarefaDao().insert(t);
                    return "ok";
                } catch (Exception e) {
                    e.printStackTrace();
                    return e.getMessage();
                }
            }



        @Override
        protected void onPostExecute(String msg) {
            if(msg.equals("ok")){
                Log.w("IUPIII", "Deu certo");
            }else{
                Log.w("Deu ruim", msg);
                Toast.makeText(getContext(), "Deu ruim"+msg, Toast.LENGTH_LONG).show();
            }
        }
    }


}