package com.example.demo_seplag.dto;

public class ServidorEfetivoDTO {
    private String nome;
    private int idade;
    private String unidade;
    private String fotoUrl;

    public ServidorEfetivoDTO(String nome, int idade, String unidade, String fotoUrl) {
        this.nome = nome;
        this.idade = idade;
        this.unidade = unidade;
        this.fotoUrl = fotoUrl;
    }

    // Getters e Setters

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }
    public String getUnidade() {
        return unidade;
    }
    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }
    public String getFotoUrl() {
        return fotoUrl;
    }
    public void setFotoUrl(String fotoUrl) {
        this.fotoUrl = fotoUrl;
    }
}
