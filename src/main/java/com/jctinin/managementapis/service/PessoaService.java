package com.jctinin.managementapis.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jctinin.managementapis.entity.Pessoa;
import com.jctinin.managementapis.repository.PessoaRepository;

@Service
public class PessoaService {

  @Autowired
  private PessoaRepository pessoaRepository;

  public List<Pessoa> listPessoas() {
    return pessoaRepository.findAll();
  }

  public void createPessoa(Pessoa pessoa) {

    try {
      pessoaRepository.save(pessoa);
    } catch (Exception e) {
      System.out.println("Error: " + e.getMessage());
    }

  }

  public Pessoa alteraPessoa(Long id, Pessoa pessoa) {

    Optional<Pessoa> pessoaResult = pessoaRepository.findById(id);
    if (pessoaResult.isPresent()) {
      Pessoa pessoaAtualizada = pessoaResult.get();
      pessoaAtualizada.setNome(pessoa.getNome());
      pessoaAtualizada.setDepartamento(pessoa.getDepartamento());
      pessoaAtualizada.setTarefas(pessoa.getTarefas());
      return pessoaRepository.save(pessoaAtualizada);
    } else {

      return null;
    }

  }

}
