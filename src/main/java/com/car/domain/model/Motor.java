package com.car.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Motor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String posicao;

    private String cilindros;

    private String deslocamento;

    private String potenciaMaxima;

    private String torqueMaximo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPosicao() {
        return posicao;
    }

    public void setPosicao(String posicao) {
        this.posicao = posicao;
    }

    public String getCilindros() {
        return cilindros;
    }

    public void setCilindros(String cilindros) {
        this.cilindros = cilindros;
    }

    public String getDeslocamento() {
        return deslocamento;
    }

    public void setDeslocamento(String deslocamento) {
        this.deslocamento = deslocamento;
    }

    public String getPotenciaMaxima() {
        return potenciaMaxima;
    }

    public void setPotenciaMaxima(String potenciaMaxima) {
        this.potenciaMaxima = potenciaMaxima;
    }

    public String getTorqueMaximo() {
        return torqueMaximo;
    }

    public void setTorqueMaximo(String torqueMaximo) {
        this.torqueMaximo = torqueMaximo;
    }
}
