package com.beiramar.projeto.dto;

public record PedidoDTO(
        Integer idMesa,
        Integer formaPagamento,
        Double vlPedido,
        Boolean feedBack
) {}