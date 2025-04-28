package com.car.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Dimensoes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private int comprimentoMm;

    private int larguraMm;

    private int alturaMm;

    private int pesoKg;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getComprimentoMm() {
        return comprimentoMm;
    }

    public void setComprimentoMm(int comprimentoMm) {
        this.comprimentoMm = comprimentoMm;
    }

    public int getLarguraMm() {
        return larguraMm;
    }

    public void setLarguraMm(int larguraMm) {
        this.larguraMm = larguraMm;
    }

    public int getAlturaMm() {
        return alturaMm;
    }

    public void setAlturaMm(int alturaMm) {
        this.alturaMm = alturaMm;
    }

    public int getPesoKg() {
        return pesoKg;
    }

    public void setPesoKg(int pesoKg) {
        this.pesoKg = pesoKg;
    }
}
