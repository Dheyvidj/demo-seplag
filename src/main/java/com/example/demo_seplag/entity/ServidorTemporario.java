package com.example.demo_seplag.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "servidor_temporario")
public class ServidorTemporario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long stId;

    @OneToOne(optional = false)
    @JoinColumn(name = "pessoa_id", referencedColumnName = "id")
    private Pessoa pessoa;

    private LocalDate stDataInicio;
    private LocalDate stDataFim;

    // Getters e Setters

    public Long getStId() {
        return stId;
    }

    public void setStId(Long stId) {
        this.stId = stId;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public LocalDate getStDataInicio() {
        return stDataInicio;
    }

    public void setStDataInicio(LocalDate stDataInicio) {
        this.stDataInicio = stDataInicio;
    }

    public LocalDate getStDataFim() {
        return stDataFim;
    }

    public void setStDataFim(LocalDate stDataFim) {
        this.stDataFim = stDataFim;
    }
}
