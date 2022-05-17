package br.senai.sp.cotia.todolist.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.senai.sp.cotia.todolist.databinding.FragmentCadBinding;
import br.senai.sp.cotia.todolist.databinding.FragmentSubBinding;
import br.senai.sp.cotia.todolist.model.Tarefa;

public class FragmentSub extends Fragment {

    private Tarefa tarefa;

    private FragmentSubBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentSubBinding.inflate(inflater, container, false);
        if (getArguments() != null) {
            //recupera a tarefa
            tarefa = (Tarefa) getArguments().getSerializable("subtarefa");

            //popula os campos com as informações da tarefa
            binding.textViewTitulo2.setText(tarefa.getTitulo());
        }
        return binding.getRoot();

    }
}