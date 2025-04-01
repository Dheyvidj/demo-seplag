package com.example.demo_seplag.controller;

import com.example.demo_seplag.entity.Unidade;
import com.example.demo_seplag.service.UnidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/unidade")
public class UnidadeController {

    @Autowired
    private UnidadeService service;
    
    @GetMapping
    public List<Unidade> listAll() {
        return service.listAll();
    }
    
    @GetMapping("/{id}")
    public Unidade getById(@PathVariable Long id) {
        return service.getById(id);
    }
    
    @PostMapping
    public Unidade create(@RequestBody Unidade unidade) {
        return service.create(unidade);
    }
    
    @PutMapping("/{id}")
    public Unidade update(@PathVariable Long id, @RequestBody Unidade unidade) {
        return service.update(id, unidade);
    }
    
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
