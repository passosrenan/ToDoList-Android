package br.senai.sp.cotia.todolist.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Tarefa {
    @PrimaryKey(autoGenerate = true)
    private Long id;
    private String titulo;
    private String descricao;
    private Long DataCricao;
    private Long DataPrevista;
    private Long DataFinalizada;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Long getDataCricao() {
        return DataCricao;
    }

    public void setDataCricao(Long dataCricao) {
        DataCricao = dataCricao;
    }

    public Long getDataPrevista() {
        return DataPrevista;
    }

    public void setDataPrevista(Long dataPrevista) {
        DataPrevista = dataPrevista;
    }

    public Long getDataFinalizada() {
        return DataFinalizada;
    }

    public void setDataFinalizada(Long dataFinalizada) {
        DataFinalizada = dataFinalizada;
    }
}
