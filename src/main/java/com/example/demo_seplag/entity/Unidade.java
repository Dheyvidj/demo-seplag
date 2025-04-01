package com.example.demo_seplag.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "unidade")
public class Unidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long unidId;

    private String unidSigla;
    private String unidNome;

    @ManyToOne(optional = false)
    @JoinColumn(name = "end_id", referencedColumnName = "endId")
    private Endereco endereco;

    // Getters e Setters

    public Long getUnidId() {
        return unidId;
    }

    public void setUnidId(Long unidId) {
        this.unidId = unidId;
    }

    public String getUnidSigla() {
        return unidSigla;
    }

    public void setUnidSigla(String unidSigla) {
        this.unidSigla = unidSigla;
    }

    public String getUnidNome() {
        return unidNome;
    }

    public void setUnidNome(String unidNome) {
        this.unidNome = unidNome;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
