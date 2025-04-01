package com.example.demo_seplag.repository;

import com.example.demo_seplag.entity.Lotacao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LotacaoRepository extends JpaRepository<Lotacao, Long> {

    List<Lotacao> findByUnidadeUnidId(Long unidId);

    Optional<Lotacao> findByServidorEfetivoId(Long sefId);
}
