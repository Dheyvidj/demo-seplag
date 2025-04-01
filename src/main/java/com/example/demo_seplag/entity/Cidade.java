package com.example.demo_seplag.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "cidade")
public class Cidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cidId;

    private String cidNome;
    private String cidUf;

    // Getters e Setters

    public Long getCidId() {
        return cidId;
    }

    public void setCidId(Long cidId) {
        this.cidId = cidId;
    }

    public String getCidNome() {
        return cidNome;
    }

    public void setCidNome(String cidNome) {
        this.cidNome = cidNome;
    }

    public String getCidUf() {
        return cidUf;
    }

    public void setCidUf(String cidUf) {
        this.cidUf = cidUf;
    }
}
