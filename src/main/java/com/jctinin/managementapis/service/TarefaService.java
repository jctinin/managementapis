package com.jctinin.managementapis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jctinin.managementapis.entity.Tarefa;
import com.jctinin.managementapis.repository.TarefaRepository;

@Service
public class TarefaService {

  @Autowired
  private TarefaRepository tarefaRepository;


  public List<Tarefa> listaTarefas() {
    return tarefaRepository.findAll();
  }

  public Tarefa adicionaTarefa(Tarefa tarefa) {
    return tarefaRepository.save(tarefa);
  }

}
