package br.senai.sp.cotia.todolist.fragment;

import android.app.DatePickerDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;

import java.util.Calendar;

import br.senai.sp.cotia.todolist.databinding.FragmentCadBinding;

public class FragmentCad extends Fragment {

    private FragmentCadBinding binding;

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
        },year,month,day);

        //listener do botao data
        binding.buttonData.setOnClickListener(v ->{
            //abre o datePicker
            datePicker.show();

        });

        return binding.getRoot();
    }
}