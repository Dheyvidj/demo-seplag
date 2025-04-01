package com.example.demo_seplag.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "foto_pessoa")
public class FotoPessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fp_id")
    private Integer fpId; // PK

    @Column(name = "fp_data")
    private LocalDate fpData;

    @Column(name = "fp_bucket", length = 50)
    private String fpBucket;

    @Column(name = "fp_hash", length = 50)
    private String fpHash;


    @Column(name = "pes_id")
    private Long pesId; // ID da pessoa associada

    // Construtores
    public FotoPessoa() {
    }

    public FotoPessoa(Long pesId, LocalDate fpData, String fpBucket, String fpHash) {
        this.pesId = pesId;
        this.fpData = fpData;
        this.fpBucket = fpBucket;
        this.fpHash = fpHash;
    }

    // Getters e Setters
    public Integer getFpId() {
        return fpId;
    }
    public void setFpId(Integer fpId) {
        this.fpId = fpId;
    }

    public LocalDate getFpData() {
        return fpData;
    }
    public void setFpData(LocalDate fpData) {
        this.fpData = fpData;
    }

    public String getFpBucket() {
        return fpBucket;
    }
    public void setFpBucket(String fpBucket) {
        this.fpBucket = fpBucket;
    }

    public String getFpHash() {
        return fpHash;
    }
    public void setFpHash(String fpHash) {
        this.fpHash = fpHash;
    }

    public Long getPesId() {
        return pesId;
    }
    public void setPesId(Long pesId) {
        this.pesId = pesId;
    }
}
