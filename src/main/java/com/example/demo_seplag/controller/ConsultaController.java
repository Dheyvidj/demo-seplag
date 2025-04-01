package com.example.demo_seplag.controller;

import com.example.demo_seplag.dto.ServidorEfetivoDTO;
import com.example.demo_seplag.service.ConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/consultas")
public class ConsultaController {

    @Autowired
    private ConsultaService consultaService;

    @GetMapping("/servidores-por-unidade/{unidadeId}")
    public List<ServidorEfetivoDTO> getServidoresPorUnidade(@PathVariable Long unidadeId) {
        return consultaService.getServidoresPorUnidade(unidadeId);
    }
}
