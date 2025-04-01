package com.example.demo_seplag.controller;

import com.example.demo_seplag.entity.ServidorEfetivo;
import com.example.demo_seplag.service.ServidorEfetivoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/servidor-efetivo")
public class ServidorEfetivoController {

    @Autowired
    private ServidorEfetivoService service;

    @GetMapping
    public Page<ServidorEfetivo> listAll(@RequestParam(defaultValue = "0") int page,
                                         @RequestParam(defaultValue = "10") int size) {
        return service.listAll(page, size);
    }

    @GetMapping("/{id}")
    public ServidorEfetivo getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public ServidorEfetivo create(@RequestBody ServidorEfetivo servidor) {
        return service.create(servidor);
    }

    @PutMapping("/{id}")
    public ServidorEfetivo update(@PathVariable Long id, @RequestBody ServidorEfetivo servidorAtualizado) {
        return service.update(id, servidorAtualizado);
    }
}
