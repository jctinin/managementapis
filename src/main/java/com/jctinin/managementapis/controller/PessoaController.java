package com.jctinin.managementapis.controller;

import org.springframework.web.bind.annotation.RestController;

import com.jctinin.managementapis.entity.Pessoa;
import com.jctinin.managementapis.service.PessoaService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/pessoas")
public class PessoaController {


  @Autowired
  private PessoaService pessoaService;

  @GetMapping
  public ResponseEntity<List<Pessoa>> listPessoas() {
      List<Pessoa> pessoas = pessoaService.listPessoas();
      return ResponseEntity.ok(pessoas);
  }


  @PostMapping
  private ResponseEntity<Pessoa> createPessoa(@RequestBody Pessoa pessoa) {
    pessoaService.createPessoa(pessoa);
    return ResponseEntity.ok().build();
  }

  @PutMapping("/{id}")
  private ResponseEntity<Pessoa> updatePessoa(@PathVariable Long id, @RequestBody Pessoa pessoa) {

    Pessoa pessoaAtualizada = pessoaService.alteraPessoa(id, pessoa);
    if (pessoaAtualizada == null) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }else{
      return ResponseEntity.ok(pessoaAtualizada);
    }
  }

  @DeleteMapping("/{id}")
  private ResponseEntity<Pessoa> removePessoa(@PathVariable Long id) {
    pessoaService.removePessoa(id);
    return ResponseEntity.ok().build();
  }

}
