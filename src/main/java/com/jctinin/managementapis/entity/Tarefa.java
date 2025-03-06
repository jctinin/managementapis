package com.jctinin.managementapis.entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;

@Entity
public class Tarefa {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String titulo;

  @Column(nullable = false)
  private String descricao;

  @Column(nullable = false)
  private LocalDate prazo;

  @ManyToOne
  @JoinColumn(name = "departamento_id", nullable = false)
  @JsonBackReference
  private Departamento departamento;

  @Column(nullable = false)
  private float duracao;

  @ManyToOne
  @JoinColumn(name = "pessoa_id", nullable = false)
  @JsonBackReference
  private Pessoa pessoa;

  @Column(nullable = false)
  private boolean concluida;

  public Long getId() {
    return id;
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

  public LocalDate getPrazo() {
    return prazo;
  }

  public void setPrazo(LocalDate prazo) {
    this.prazo = prazo;
  }

  public Departamento getDepartamento() {
    return departamento;
  }

  public void setDepartamento(Departamento departamento) {
    this.departamento = departamento;
  }

  public float getDuracao() {
    return duracao;
  }

  public void setDuracao(float duracao) {
    this.duracao = duracao;
  }

  public Pessoa getPessoa() {
    return pessoa;
  }

  public void setPessoa(Pessoa pessoa) {
    this.pessoa = pessoa;
  }

  public boolean isConcluida() {
    return concluida;
  }

  public void setConcluida(boolean concluida) {
    this.concluida = concluida;
  }


}
