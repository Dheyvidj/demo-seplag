package com.example.demo_seplag.controller;

import com.example.demo_seplag.entity.ServidorTemporario;
import com.example.demo_seplag.service.ServidorTemporarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/servidor-temporario")
public class ServidorTemporarioController {

    @Autowired
    private ServidorTemporarioService service;
    
    @GetMapping
    public List<ServidorTemporario> listAll() {
        return service.listAll();
    }
    
    @GetMapping("/{id}")
    public ServidorTemporario getById(@PathVariable Long id) {
        return service.getById(id);
    }
    
    @PostMapping
    public ServidorTemporario create(@RequestBody ServidorTemporario st) {
        return service.create(st);
    }
    
    @PutMapping("/{id}")
    public ServidorTemporario update(@PathVariable Long id, @RequestBody ServidorTemporario st) {
        return service.update(id, st);
    }
    
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
