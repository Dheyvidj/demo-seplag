package com.example.demo_seplag.repository;

import com.example.demo_seplag.entity.ServidorTemporario;
import com.example.demo_seplag.entity.Unidade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UnidadeRepository extends JpaRepository<Unidade, Long> {
}
