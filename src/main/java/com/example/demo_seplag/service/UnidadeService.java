package com.example.demo_seplag.service;

import com.example.demo_seplag.entity.Unidade;
import com.example.demo_seplag.exception.NotFoundException;
import com.example.demo_seplag.repository.UnidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnidadeService {

    @Autowired
    private UnidadeRepository repository;
    
    public List<Unidade> listAll() {
        return repository.findAll();
    }
    
    public Unidade getById(Long id) {
        return repository.findById(id)
            .orElseThrow(() -> new NotFoundException("Unidade não encontrada"));
    }
    
    public Unidade create(Unidade unidade) {
        return repository.save(unidade);
    }
    
    public Unidade update(Long id, Unidade unidadeUpdate) {
        Unidade unidade = getById(id);
        unidade.setUnidNome(unidadeUpdate.getUnidNome());
        unidade.setUnidSigla(unidadeUpdate.getUnidSigla());
        unidade.setEndereco(unidadeUpdate.getEndereco());
        return repository.save(unidade);
    }
    
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
