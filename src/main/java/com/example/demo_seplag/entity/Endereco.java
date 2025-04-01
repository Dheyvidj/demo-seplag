package com.example.demo_seplag.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "endereco")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long endId;

    private String endLogradouro;
    private String endNumero;
    private String endBairro;

    @ManyToOne(optional = false)
    @JoinColumn(name = "cid_id", referencedColumnName = "cidId")
    private Cidade cidade;

    // Getters e Setters

    public Long getEndId() {
        return endId;
    }

    public void setEndId(Long endId) {
        this.endId = endId;
    }

    public String getEndLogradouro() {
        return endLogradouro;
    }

    public void setEndLogradouro(String endLogradouro) {
        this.endLogradouro = endLogradouro;
    }

    public String getEndNumero() {
        return endNumero;
    }

    public void setEndNumero(String endNumero) {
        this.endNumero = endNumero;
    }

    public String getEndBairro() {
        return endBairro;
    }

    public void setEndBairro(String endBairro) {
        this.endBairro = endBairro;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }
}
