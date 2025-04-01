package com.example.demo_seplag.controller;

import com.example.demo_seplag.entity.Unidade;
import com.example.demo_seplag.exception.NotFoundException;
import com.example.demo_seplag.repository.LotacaoRepository;
import com.example.demo_seplag.repository.ServidorEfetivoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/endereco-funcional")
public class EnderecoController {

    @Autowired
    private ServidorEfetivoRepository servidorEfetivoRepository;

    @Autowired
    private LotacaoRepository lotacaoRepository;

    @GetMapping
    public Unidade getEnderecoFuncional(@RequestParam("nome") String nomeParcial) {
        // Exemplo: busca um servidor cujo nome contenha o valor e retorne o endereço da unidade em que ele está lotado.
        return servidorEfetivoRepository.findAll().stream()
                .filter(se -> se.getPessoa().getNome().toLowerCase().contains(nomeParcial.toLowerCase()))
                .findFirst()
                .map(se -> lotacaoRepository.findByServidorEfetivoId(se.getId()))
                .map(lot -> lot.getUnidade())
                .orElseThrow(() -> new NotFoundException("Endereço funcional não encontrado para o nome informado"));
    }
}
