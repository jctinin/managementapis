package com.jctinin.managementapis.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jctinin.managementapis.dto.CriaPessoaDTO;
import com.jctinin.managementapis.entity.Departamento;
import com.jctinin.managementapis.entity.Pessoa;
import com.jctinin.managementapis.repository.DepartamentoRepository;
import com.jctinin.managementapis.repository.PessoaRepository;

@Service
public class PessoaService {

  @Autowired
  private PessoaRepository pessoaRepository;

  @Autowired
  private DepartamentoRepository departamentoRepository;

  public List<Pessoa> listPessoas() {
    return pessoaRepository.findAll();
  }

  public void criaPessoa(CriaPessoaDTO pessoaDTO) {

    Departamento departamento = departamentoRepository.findByTitulo(pessoaDTO.getDepartamento())
        .orElseGet(() -> {
          Departamento novoDepartamento = new Departamento();
          novoDepartamento.setTitulo(pessoaDTO.getDepartamento());
          return departamentoRepository.save(novoDepartamento);

        });

        Pessoa pessoa = new Pessoa();
        pessoa.setNome(pessoaDTO.getNome());
        pessoa.setDepartamento(departamento);

        pessoaRepository.save(pessoa);

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

  public void removePessoa(Long id) {
    pessoaRepository.deleteById(id);
  }

}
