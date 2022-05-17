package br.senai.sp.cotia.todolist.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.List;

import br.senai.sp.cotia.todolist.R;
import br.senai.sp.cotia.todolist.model.Tarefa;

public class TarefaAdapter extends RecyclerView.Adapter<TarefaAdapter.TarefaViewHolder> {
    //lista de tarefas
    private List<Tarefa> tarefas;

    //variável para o context
    private Context context;

    //variavel do tipo OnTarefaClickListener
    private OnTarefaClickListener listenerClickTarefa;

    //criar um construtor para receber os valores, que recebe uma lista de tarefas
    public TarefaAdapter(List<Tarefa> lista, Context contexto, OnTarefaClickListener listener){
        this.tarefas = lista;
        this.context = contexto;
        this.listenerClickTarefa = listener;

    }


    @NonNull
    @Override
    public TarefaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //infla o layout do adapter
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_tarefa, parent, false);
        return new TarefaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TarefaViewHolder holder, int position) {
        //obtem uma tarefa pela position
        Tarefa t = tarefas.get(position);

        //exibe o título da tarefa na text view
        holder.tvTitulo.setText(t.getTitulo());

        //se estiver concluida
        if(t.isConluida()){
            holder.tvStatus.setText("Tarefa: Concluida");
            holder.tvStatus.setBackgroundColor(context.getResources().getColor(R.color.cor_status));
        }else{
            holder.tvStatus.setText("Tarefa: Aberta");
            holder.tvStatus.setBackgroundColor(context.getResources().getColor(R.color.status_aberta));
        }
        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
        holder.tvData.setText(formatador.format(t.getDataPrevista()));

        holder.itemView.setOnClickListener(v ->{
            //dispara o listener
            listenerClickTarefa.onClick(v,t);

        });

    }

    @Override
    //retorna quantidade de elementos a serem exibidos
    public int getItemCount() {
        if(tarefas != null){
            return tarefas.size();
        }
        return 0;
    }

    //classe viewHolder para mapear os componentes do xml
    class TarefaViewHolder extends RecyclerView.ViewHolder{

        //variáveis para acessar os componentes do xml
        TextView tvTitulo, tvData, tvStatus;

        public TarefaViewHolder(View view){
            //chama o construtor da super classe
            super(view);

            //passar para as variáveis os componentes do xml
            tvTitulo = view.findViewById(R.id.text_titulo);
            tvData = view.findViewById(R.id.text_data);
            tvStatus = view.findViewById(R.id.text_status);
        }

    }
    //interface para o clique na tarefa
    public interface OnTarefaClickListener{
        void onClick(View view, Tarefa tarefa);
    }
}
