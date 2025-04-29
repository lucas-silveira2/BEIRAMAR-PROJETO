package com.beiramar.projeto.models;

import jakarta.persistence.*;

@Entity
@Table(name = "mesas")
public class MesaModel {

    @Id@Column(name="idMesa")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMesa;

    public Integer getIdMesa() {
        return idMesa;
    }

    public void setIdMesa(Integer idMesa) {
        this.idMesa = idMesa;
    }

    public Double getVlTotalPedido() {
        return vlTotalPedido;
    }

    public void setVlTotalPedido(Double vlTotalPedido) {
        this.vlTotalPedido = vlTotalPedido;
    }

    private Double vlTotalPedido;



}