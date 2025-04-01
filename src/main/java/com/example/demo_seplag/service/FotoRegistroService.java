package com.example.demo_seplag.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FotoRegistroService {

    @Autowired
    private FotoRegistroRepository repository;

    public FotoRegistro saveFotoRegistro(FotoRegistro registro) {
        return repository.save(registro);
    }
}
