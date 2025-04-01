package com.example.demo_seplag.repository;

import com.example.demo_seplag.entity.Pessoa;
import com.example.demo_seplag.entity.ServidorTemporario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServidorTemporarioRepository extends JpaRepository<ServidorTemporario, Long> {
}
