package com.example.demo_seplag.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "lotacao")
public class Lotacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long lotId;

    @ManyToOne(optional = false)
    @JoinColumn(name = "unid_id", referencedColumnName = "unidId")
    private Unidade unidade;

    @ManyToOne(optional = false)
    @JoinColumn(name = "sef_id", referencedColumnName = "id")
    private ServidorEfetivo servidorEfetivo;

    private String lotPortaria;

    // Getters e Setters

    public Long getLotId() {
        return lotId;
    }

    public void setLotId(Long lotId) {
        this.lotId = lotId;
    }

    public Unidade getUnidade() {
        return unidade;
    }

    public void setUnidade(Unidade unidade) {
        this.unidade = unidade;
    }

    public ServidorEfetivo getServidorEfetivo() {
        return servidorEfetivo;
    }

    public void setServidorEfetivo(ServidorEfetivo servidorEfetivo) {
        this.servidorEfetivo = servidorEfetivo;
    }

    public String getLotPortaria() {
        return lotPortaria;
    }

    public void setLotPortaria(String lotPortaria) {
        this.lotPortaria = lotPortaria;
    }
}
