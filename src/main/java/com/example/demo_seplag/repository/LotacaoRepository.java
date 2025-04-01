package com.example.demo_seplag.repository;

import com.example.demo_seplag.entity.Lotacao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LotacaoRepository extends JpaRepository<Lotacao, Long> {

    List<Lotacao> findByUnidadeId(Long unidadeId);

    Lotacao findByServidorEfetivoId(Long servidorEfetivoId);
}
