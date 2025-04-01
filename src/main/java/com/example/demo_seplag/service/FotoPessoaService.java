package com.example.demo_seplag.service;

import com.example.demo_seplag.entity.FotoPessoa;
import com.example.demo_seplag.repository.FotoPessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FotoPessoaService {

    @Autowired
    private FotoPessoaRepository repository;

    public FotoPessoa saveFotoPessoa(FotoPessoa foto) {
        return repository.save(foto);
    }
    
    // Exemplo de busca por pessoa
    // public List<FotoPessoa> findByPesId(Long pesId) { ... }
}
