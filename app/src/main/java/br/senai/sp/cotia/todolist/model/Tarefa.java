package br.senai.sp.cotia.todolist.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class Tarefa implements Serializable {
    @PrimaryKey(autoGenerate = true)
    private long id;
    private String titulo;
    private String descricao;
    private long DataCricao;
    private long DataPrevista;
    private long DataFinalizada;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public long getDataCricao() {
        return DataCricao;
    }

    public void setDataCricao(long dataCricao) {
        DataCricao = dataCricao;
    }

    public long getDataPrevista() {
        return DataPrevista;
    }

    public void setDataPrevista(long dataPrevista) {
        DataPrevista = dataPrevista;
    }

    public long getDataFinalizada() {
        return DataFinalizada;
    }

    public void setDataFinalizada(long dataFinalizada) {
        DataFinalizada = dataFinalizada;
    }

    public boolean isConluida(){
        return DataFinalizada !=0;
    }

}
