package com.example.demo_seplag.service;

import com.example.demo_seplag.entity.Lotacao;
import com.example.demo_seplag.exception.NotFoundException;
import com.example.demo_seplag.repository.LotacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LotacaoService {

    @Autowired
    private LotacaoRepository repository;
    
    public List<Lotacao> listAll() {
        return repository.findAll();
    }
    
    public Lotacao getById(Long id) {
        return repository.findById(id)
            .orElseThrow(() -> new NotFoundException("Lotação não encontrada"));
    }
    
    public Lotacao create(Lotacao lotacao) {
        return repository.save(lotacao);
    }
    
    public Lotacao update(Long id, Lotacao lotacaoUpdate) {
        Lotacao lotacao = getById(id);
        lotacao.setLotPortaria(lotacaoUpdate.getLotPortaria());
        lotacao.setServidorEfetivo(lotacaoUpdate.getServidorEfetivo());
        lotacao.setUnidade(lotacaoUpdate.getUnidade());
        return repository.save(lotacao);
    }
    
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
