package com.beiramar.projeto.repositories;

import com.beiramar.projeto.models.ProdutoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoModel, Integer> {
    Optional<ProdutoModel> findByIdProduto(int idProduto);

    Optional<ProdutoModel> findAllByIdProduto(int idProduto);
}