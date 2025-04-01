package com.example.demo_seplag.repository;


import com.example.demo_seplag.entity.ServidorEfetivo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ServidorEfetivoRepository extends JpaRepository<ServidorEfetivo, Long> {

    @Query("SELECT s FROM ServidorEfetivo s WHERE LOWER(s.pessoa.nome) LIKE LOWER(CONCAT('%', :nome, '%'))")
    List<ServidorEfetivo> findByNomeParcial(@Param("nome") String nome);

    Page<ServidorEfetivo> findAll(Pageable pageable);
}
