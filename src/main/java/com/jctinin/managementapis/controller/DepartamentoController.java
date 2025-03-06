package com.jctinin.managementapis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.jctinin.managementapis.entity.Departamento;
import com.jctinin.managementapis.repository.DepartamentoRepository;

@RestController
@RequestMapping("/departamentos")
public class DepartamentoController {

  @Autowired
  private DepartamentoRepository departamentoRepository;

  @GetMapping
  public ResponseEntity<Iterable<Departamento>> listaDepartamentos() {
    Iterable<Departamento> departamentos = departamentoRepository.findAll();
    return ResponseEntity.ok(departamentos);
  }

  @PostMapping
  public ResponseEntity<Departamento> criaDepartamento(@RequestBody Departamento departamento) {
    Departamento savedDepartamento = departamentoRepository.save(departamento);
    return ResponseEntity.status(HttpStatus.CREATED).body(savedDepartamento);
  }
}