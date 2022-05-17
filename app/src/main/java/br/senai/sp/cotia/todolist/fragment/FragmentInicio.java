package br.senai.sp.cotia.todolist.fragment;

import android.os.AsyncTask;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.nio.channels.AsynchronousChannelGroup;
import java.util.List;

import br.senai.sp.cotia.todolist.R;
import br.senai.sp.cotia.todolist.adapter.TarefaAdapter;
import br.senai.sp.cotia.todolist.database.AppDatabase;
import br.senai.sp.cotia.todolist.databinding.FragmentCadBinding;
import br.senai.sp.cotia.todolist.databinding.FragmentInicioBinding;
import br.senai.sp.cotia.todolist.model.Tarefa;


public class FragmentInicio extends Fragment {

    private FragmentInicioBinding binding;

    //variável para a database
    private AppDatabase database;

    //variável para o adapter
    private TarefaAdapter adapter;

    //variável para a lista
    private List<Tarefa> tarefas;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentInicioBinding.inflate(inflater, container, false);
        //clique no botão de adicionar tarefa

        //No clique do botão fazer navegação para o fragment da tarefa
        binding.butonAddTarefa.setOnClickListener(v -> {
            NavHostFragment.findNavController(FragmentInicio.this).navigate(R.id.action_fragmentInicio_to_fragmentCad);

        });

        //instancia a database
        database = AppDatabase.getDatabase(getActivity());

        //define o layout manager do recyclerview
        binding.recyclerTarefas.setLayoutManager(new LinearLayoutManager(getContext()));

        //executa a async task
        new ReadTarefa().execute();

        return binding.getRoot();
    }

    class ReadTarefa extends AsyncTask<Void, Void, List<Tarefa>>{

        @Override
        protected List<Tarefa> doInBackground(Void... voids) {
            //guarda na variável tarefas<List> as tarefad do banco de dados
            tarefas = database.getTarefaDao().getAll();

            //retorna a lista de tarefas, porque produz uma lista de tarefas
            return tarefas;
        }

        @Override
        protected void onPostExecute(List<Tarefa> tarefas) {
            //isntancia o adapter
            adapter = new TarefaAdapter(tarefas, getActivity(), listenerTarefa);

            //aplica o adapter no recyclerview
            binding.recyclerTarefas.setAdapter(adapter);
        }
    }
    //implementação da interface OnTarefaClickListener
    private TarefaAdapter.OnTarefaClickListener listenerTarefa = (view, tarefa) -> {

        //pendurar a tarefa no pacote, variável para transportar (pacote)
      Bundle bundle = new Bundle();

      //pendura a tarefa no pacote
      bundle.putSerializable("tarefa", tarefa);

      //navega para o próximo fragment enviando o bundle
        NavHostFragment.findNavController(FragmentInicio.this).navigate(R.id.action_fragmentInicio_to_fragmentDetalhes, bundle);
    };

}