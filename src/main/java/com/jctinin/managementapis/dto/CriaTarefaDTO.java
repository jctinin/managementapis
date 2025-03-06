package com.jctinin.managementapis.dto;

import java.time.LocalDate;

public class CriaTarefaDTO {

    private String titulo;
    private String descricao;
    private LocalDate prazo;
    private String departamentoTitulo;
    private Long pessoaId;
    private float duracao;
    private boolean concluida;


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
    public LocalDate getPrazo() {
      return prazo;
    }
    public void setPrazo(LocalDate prazo) {
      this.prazo = prazo;
    }
    public String getDepartamentoTitulo() {
      return departamentoTitulo;
    }
    public void setDepartamentoTitulo(String departamentoTitulo) {
      this.departamentoTitulo = departamentoTitulo;
    }
    public Long getPessoaId() {
      return pessoaId;
    }
    public void setPessoaId(Long pessoaId) {
      this.pessoaId = pessoaId;
    }
    public float getDuracao() {
      return duracao;
    }
    public void setDuracao(float duracao) {
      this.duracao = duracao;
    }
    public boolean isConcluida() {
      return concluida;
    }
    public void setConcluida(boolean concluida) {
      this.concluida = concluida;
    }



  }
