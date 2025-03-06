package com.jctinin.managementapis.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jctinin.managementapis.entity.Departamento;


@Repository
public interface DepartamentoRepository extends JpaRepository<Departamento, Long> {

    Optional<Departamento> findByTitulo(String titulo);

}
