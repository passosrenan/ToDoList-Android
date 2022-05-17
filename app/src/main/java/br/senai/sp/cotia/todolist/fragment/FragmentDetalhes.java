package br.senai.sp.cotia.todolist.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.text.SimpleDateFormat;

import br.senai.sp.cotia.todolist.R;
import br.senai.sp.cotia.todolist.adapter.TarefaAdapter;
import br.senai.sp.cotia.todolist.databinding.FragmentCadBinding;
import br.senai.sp.cotia.todolist.databinding.FragmentDetalhesBinding;
import br.senai.sp.cotia.todolist.model.Tarefa;


public class FragmentDetalhes extends Fragment {

    //variável para a tarefa a ser detalhada
    private Tarefa tarefa;

    private FragmentDetalhesBinding binding;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentDetalhesBinding.inflate(inflater, container, false);

        //verifica se existe algo sendo passadp no bundle
        if(getArguments()!= null){
            //recupera a tarefa
            tarefa = (Tarefa) getArguments().getSerializable("tarefa");

            //popula os campos com as informações da tarefa
            binding.textViewTitulo.setText(tarefa.getTitulo());
            binding.textDescricao.setText(tarefa.getDescricao());
            SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
            binding.textViewData.setText(formatador.format(tarefa.getDataPrevista()));

            //se a tarefa estiver concluída
            if(tarefa.isConluida()){
                binding.textViewTitulo.setBackgroundColor(getResources().getColor(R.color.cor_status));
            }else{
                binding.textViewTitulo.setBackgroundColor(getResources().getColor(R.color.status_aberta));
            }
        }
        //No clique do botão fazer navegação para o fragment da subTarefa
        binding.butonAddSubTarefa.setOnClickListener(v -> {

            //pendurar a tarefa no pacote, variável para transportar (pacote)
            Bundle bundle = new Bundle();

            //pendura a tarefa no pacote
            bundle.putSerializable("subtarefa", tarefa);
            NavHostFragment.findNavController(FragmentDetalhes.this).navigate(R.id.action_fragmentDetalhes_to_fragmentSub, bundle);

        });
        return binding.getRoot();
    }
}