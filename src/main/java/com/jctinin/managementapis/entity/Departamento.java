package com.jctinin.managementapis.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;

@Entity
public class Departamento {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false, unique = true)
  private String titulo;

  @JsonManagedReference
  @OneToMany(mappedBy = "departamento", cascade = CascadeType.ALL)
  private List<Pessoa> pessoas;

  @JsonBackReference
  @OneToMany(mappedBy = "departamento", cascade = CascadeType.ALL)
  private List<Tarefa> tarefas;

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

  public List<Pessoa> getPessoas() {
    return pessoas;
  }

  public void setPessoas(List<Pessoa> pessoas) {
    this.pessoas = pessoas;
  }

  public List<Tarefa> getTarefas() {
    return tarefas;
  }

  public void setTarefas(List<Tarefa> tarefas) {
    this.tarefas = tarefas;
  }



}
