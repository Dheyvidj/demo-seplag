package com.example.demo_seplag.controller;

import com.example.demo_seplag.dto.PessoaFotoDTO;
import com.example.demo_seplag.entity.FotoPessoa;
import com.example.demo_seplag.entity.Pessoa;
import com.example.demo_seplag.repository.FotoPessoaRepository;
import com.example.demo_seplag.repository.PessoaRepository;
import com.example.demo_seplag.service.FotoPessoaService;
import com.example.demo_seplag.service.FotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/pessoa")
public class PessoaController {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private FotoPessoaRepository fotoPessoaRepository;

    @Autowired
    private FotoService fotoService;


    @PostMapping
    public Pessoa createPessoa(@RequestBody Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }


    @PutMapping("/{id}")
    public Pessoa updatePessoa(@PathVariable Long id, @RequestBody Pessoa pessoaDetails) {
        Pessoa pessoa = pessoaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pessoa não encontrada"));
        pessoa.setNome(pessoaDetails.getNome());
        pessoa.setDataNascimento(pessoaDetails.getDataNascimento());
        return pessoaRepository.save(pessoa);
    }

    @GetMapping
    public List<Pessoa> listPessoas() {
        return pessoaRepository.findAll();
    }

    @GetMapping("/{id}")
    public PessoaFotoDTO getPessoaComFotos(@PathVariable Long id) {
        Pessoa pessoa = pessoaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pessoa não encontrada"));

        List<FotoPessoa> fotos = fotoPessoaRepository.findAll()
                .stream()
                .filter(f -> f.getPesId().equals(id))
                .collect(Collectors.toList());

        return new PessoaFotoDTO(pessoa.getId(), pessoa.getNome(), pessoa.getDataNascimento(), fotos);
    }
}
