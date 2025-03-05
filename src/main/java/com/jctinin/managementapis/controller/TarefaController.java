package com.jctinin.managementapis.controller;

import org.springframework.web.bind.annotation.RestController;

import com.jctinin.managementapis.entity.Tarefa;
import com.jctinin.managementapis.service.PessoaService;
import com.jctinin.managementapis.service.TarefaService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {

  @Autowired
  private PessoaService pessoaService;

  @Autowired
  private TarefaService tarefaService;

  @GetMapping
  public ResponseEntity<List<Tarefa>> listaTarefas() {
    List<Tarefa> tarefas = tarefaService.listaTarefas();
    return ResponseEntity.ok(tarefas);
  }

  @PostMapping
  public ResponseEntity<Tarefa> adicionaTarefa(@RequestBody Tarefa tarefa) {
    tarefaService.adicionaTarefa(tarefa);
    return ResponseEntity.ok().build();
  }

}
