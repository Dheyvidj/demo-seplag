package com.example.demo_seplag.service;

import com.example.demo_seplag.entity.ServidorEfetivo;
import com.example.demo_seplag.exception.NotFoundException;
import com.example.demo_seplag.repository.ServidorEfetivoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class ServidorEfetivoService {

    @Autowired
    private ServidorEfetivoRepository repository;

    public Page<ServidorEfetivo> listAll(int page, int size) {
        return repository.findAll(PageRequest.of(page, size));
    }

    public ServidorEfetivo getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Servidor não encontrado"));
    }

    public ServidorEfetivo create(ServidorEfetivo servidor) {
        return repository.save(servidor);
    }

    public ServidorEfetivo update(Long id, ServidorEfetivo servidorAtualizado) {
        ServidorEfetivo servidor = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Servidor não encontrado"));
        servidor.setMatricula(servidorAtualizado.getMatricula());

        return repository.save(servidor);
    }
}
