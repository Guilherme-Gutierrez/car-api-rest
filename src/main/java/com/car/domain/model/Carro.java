package com.car.domain.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Carro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String modelo;

    private int ano;

    private String marca;

    private String categoria;

    private String tracao;

    private String cambio;

    @ManyToOne(cascade = CascadeType.ALL)
    private Motor motor;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Dimensoes dimensoes;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Imagem> imagens;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getTracao() {
        return tracao;
    }

    public void setTracao(String tracao) {
        this.tracao = tracao;
    }

    public String getCambio() {
        return cambio;
    }

    public void setCambio(String cambio) {
        this.cambio = cambio;
    }

    public Motor getMotor() {
        return motor;
    }

    public void setMotor(Motor motor) {
        this.motor = motor;
    }

    public Dimensoes getDimensoes() {
        return dimensoes;
    }

    public void setDimensoes(Dimensoes dimensoes) {
        this.dimensoes = dimensoes;
    }

    public List<Imagem> getImagens() {
        return imagens;
    }

    public void setImagens(List<Imagem> imagens) {
        this.imagens = imagens;
    }
}
