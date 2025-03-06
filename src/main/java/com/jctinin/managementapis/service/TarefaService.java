package com.jctinin.managementapis.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jctinin.managementapis.dto.CriaTarefaDTO;
import com.jctinin.managementapis.entity.Departamento;
import com.jctinin.managementapis.entity.Pessoa;
import com.jctinin.managementapis.entity.Tarefa;
import com.jctinin.managementapis.repository.DepartamentoRepository;
import com.jctinin.managementapis.repository.PessoaRepository;
import com.jctinin.managementapis.repository.TarefaRepository;

import jakarta.transaction.Transactional;

@Service
public class TarefaService {

  @Autowired
  private TarefaRepository tarefaRepository;

  @Autowired
  private PessoaRepository pessoaRepository;

  @Autowired
  private DepartamentoRepository departamentoRepository;

  public List<Tarefa> listaTarefas() {
    return tarefaRepository.findAll();
  }

  public Tarefa adicionaTarefa(CriaTarefaDTO tarefaDTO) {
    Departamento departamento = departamentoRepository.findByTitulo(tarefaDTO.getDepartamentoTitulo())
        .orElseGet(() -> {
          Departamento novoDepartamento = new Departamento();
          novoDepartamento.setTitulo(tarefaDTO.getDepartamentoTitulo());
          return departamentoRepository.save(novoDepartamento);
        });

        Pessoa pessoa = pessoaRepository.findById(tarefaDTO.getPessoaId())
            .orElseThrow(() -> new IllegalArgumentException("Pessoa não encontrada"));

            Tarefa tarefa = new Tarefa();
            tarefa.setTitulo(tarefaDTO.getTitulo());
            tarefa.setDescricao(tarefaDTO.getDescricao());
            tarefa.setPrazo(tarefaDTO.getPrazo());
            tarefa.setDepartamento(departamento);
            tarefa.setDuracao(tarefaDTO.getDuracao());
            tarefa.setConcluida(tarefaDTO.isConcluida());
            tarefa.setPessoa(pessoa);

            System.out.println("### TAREFA ###" + tarefa.getDepartamento().getTitulo());

            return tarefaRepository.save(tarefa);

  }

  @Transactional
  public Tarefa alocarPessoa(Long tarefaId, Long pessoaId) {
    Tarefa tarefa = tarefaRepository.findById(tarefaId)
        .orElseThrow(() -> new IllegalArgumentException("Tarefa não encontrada"));

    Pessoa pessoa = pessoaRepository.findById(pessoaId)
        .orElseThrow(() -> new IllegalArgumentException("Pessoa não encontrada"));

    if (!tarefa.getDepartamento().equals(pessoa.getDepartamento())) {
      throw new IllegalArgumentException("Pessoa e tarefa pertencem a departamentos diferentes");
    }

    tarefa.setPessoa(pessoa);
    return tarefaRepository.save(tarefa);
  }

  public Tarefa concluirTarefa(Long tarefaId) {
    Tarefa tarefa = tarefaRepository.findById(tarefaId)
        .orElseThrow(() -> new IllegalArgumentException("Tarefa não encontrada"));

    tarefa.setConcluida(true);
    return tarefaRepository.save(tarefa);
  }

}
