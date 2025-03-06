package com.jctinin.managementapis.entity;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;


@Entity
public class Pessoa {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String nome;

  @JsonBackReference
  @ManyToOne
  @JoinColumn(name = "departamento_id", nullable = false)
  private Departamento departamento;

  @JsonManagedReference
  @OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private List<Tarefa> tarefas;

  public Long getId() {
    return id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public Departamento getDepartamento() {
    return departamento;
  }

  public void setDepartamento(Departamento departamento) {
    this.departamento = departamento;
  }

  public List<Tarefa> getTarefas() {
    return tarefas;
  }

  public void setTarefas(List<Tarefa> tarefas) {
    this.tarefas = tarefas;
  }


}
