package com.beiramar.projeto.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;

public record ProdutoDTO(@NotBlank String nome,
        @NotBlank String nmProduto,
        @NotNull BigDecimal vlProduto
) {}