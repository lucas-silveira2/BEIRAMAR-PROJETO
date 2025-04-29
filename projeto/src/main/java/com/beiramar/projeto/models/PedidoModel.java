package com.beiramar.projeto.models;

import jakarta.persistence.*;
@Entity
@Table(name = "pedidos")
public class PedidoModel {

    @Id@Column(name="idPedido")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPedido;

    private Integer idMesa;

    private Integer formaPagamento;

    private Double vlPedido;

    private Boolean feedBack;

    public Integer getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Integer idPedido) {
        this.idPedido = idPedido;
    }

    public Integer getIdMesa() {
        return idMesa;
    }

    public void setIdMesa(Integer idMesa) {
        this.idMesa = idMesa;
    }

    public Integer getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(Integer formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public Double getVlPedido() {
        return vlPedido;
    }

    public void setVlPedido(Double vlPedido) {
        this.vlPedido = vlPedido;
    }

    public Boolean getFeedBack() {
        return feedBack;
    }

    public void setFeedBack(Boolean feedBack) {
        this.feedBack = feedBack;
    }
}