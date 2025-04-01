package com.example.demo_seplag.controller;

import com.example.demo_seplag.entity.Lotacao;
import com.example.demo_seplag.service.LotacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lotacao")
public class LotacaoController {

    @Autowired
    private LotacaoService service;
    
    @GetMapping
    public List<Lotacao> listAll() {
        return service.listAll();
    }
    
    @GetMapping("/{id}")
    public Lotacao getById(@PathVariable Long id) {
        return service.getById(id);
    }
    
    @PostMapping
    public Lotacao create(@RequestBody Lotacao lotacao) {
        return service.create(lotacao);
    }
    
    @PutMapping("/{id}")
    public Lotacao update(@PathVariable Long id, @RequestBody Lotacao lotacao) {
        return service.update(id, lotacao);
    }
    
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
