package com.beiramar.projeto.models;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "TBPRODUTO")
public class ProdutoModel {

        @Id@Column(name="idProduto")
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer idProduto;

        private String nmProduto;
        private BigDecimal vlProduto;

        public Integer getId() {
            return idProduto;
        }

        public void setId(Integer idItem) {
            this.idProduto = idProduto;
        }

        public String getnmProduto() {
            return nmProduto;
        }

        public void setnmProduto(String nmProduto) {
            this.nmProduto = nmProduto;
        }

        public BigDecimal getVlProduto() {
            return vlProduto;
        }

        public void setVlProduto(BigDecimal vlProduto) {
            this.vlProduto = vlProduto;
        }
    }
