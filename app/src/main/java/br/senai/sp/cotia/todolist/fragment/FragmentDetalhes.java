package br.senai.sp.cotia.todolist.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.senai.sp.cotia.todolist.databinding.FragmentCadBinding;
import br.senai.sp.cotia.todolist.databinding.FragmentDetalhesBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentDetalhes#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentDetalhes extends Fragment {

    private FragmentDetalhesBinding binding;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentDetalhesBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }
}