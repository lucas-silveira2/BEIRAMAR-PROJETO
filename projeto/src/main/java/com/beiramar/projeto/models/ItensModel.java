package com.beiramar.projeto.models;

import jakarta.persistence.*;

@Entity
@Table(name = "itens")
public class ItensModel {

    @Id@Column(name="idItem")
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer idItem;

    private Integer idPedido;

    private Integer qtItem;

    public Integer getIdItem() {
        return idItem;
    }

    public void setIdItem(Integer idItem) {
        this.idItem = idItem;
    }

    public Integer getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Integer idPedido) {
        this.idPedido = idPedido;
    }

    public Integer getQtItem() {
        return qtItem;
    }

    public void setQtItem(Integer qtItem) {
        this.qtItem = qtItem;
    }
}