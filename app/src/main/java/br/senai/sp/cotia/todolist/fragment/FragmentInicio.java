package br.senai.sp.cotia.todolist.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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


        binding.butonAddTarefa.setOnClickListener(v -> {
            NavHostFragment.findNavController(FragmentInicio.this).navigate(R.id.action_fragmentInicio_to_fragmentCad);

        });
        return binding.getRoot();
    }
}