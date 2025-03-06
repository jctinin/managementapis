package com.jctinin.managementapis.controller;

import com.jctinin.managementapis.dto.CriaTarefaDTO;
import com.jctinin.managementapis.entity.Tarefa;
import com.jctinin.managementapis.service.TarefaService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {

  @Autowired
  private TarefaService tarefaService;

  @GetMapping
  public ResponseEntity<List<Tarefa>> listaTarefas() {
    List<Tarefa> tarefas = tarefaService.listaTarefas();
    return ResponseEntity.ok(tarefas);
  }

  @PostMapping
  public ResponseEntity<Tarefa> adicionaTarefa(@RequestBody CriaTarefaDTO tarefaDTO) {
    Tarefa tarefa = tarefaService.adicionaTarefa(tarefaDTO);
    return ResponseEntity.status(HttpStatus.CREATED).body(tarefa);
  }

  @PutMapping("/alocar/{id}")
  public ResponseEntity<Tarefa> alocarPessoa(@PathVariable Long id, @RequestParam Long pessoaId) {
    Tarefa tarefaAlocada = tarefaService.alocarPessoa(id, pessoaId);
    return ResponseEntity.ok(tarefaAlocada);
  }

  @PutMapping("/concluir/{id}")
  public ResponseEntity<Tarefa> concluirTarefa(@PathVariable Long id) {
    Tarefa tarefaConcluida = tarefaService.concluirTarefa(id);
    return ResponseEntity.ok(tarefaConcluida);
  }

}
