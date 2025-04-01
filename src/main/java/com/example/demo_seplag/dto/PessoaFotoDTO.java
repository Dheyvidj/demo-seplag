package com.example.demo_seplag.dto;

import com.example.demo_seplag.entity.FotoPessoa;

import java.time.LocalDate;
import java.util.List;

public class PessoaFotoDTO {
    private Long id;
    private String nome;
    private LocalDate dataNascimento;
    private List<FotoPessoa> fotos;

    public PessoaFotoDTO(Long id, String nome, LocalDate dataNascimento, List<FotoPessoa> fotos) {
        this.id = id;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.fotos = fotos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }


    public List<FotoPessoa> getFotos() {
        return fotos;
    }

    public void setFotos(List<FotoPessoa> fotos) {
        this.fotos = fotos;
    }
}
