package com.beiramar.projeto.repositories;

import com.beiramar.projeto.models.PedidoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PedidoRepository extends JpaRepository<PedidoModel, Integer> {
    Optional<PedidoModel> findByIdPedido(int idPedido);

    Optional<PedidoModel> findAllByIdPedido(int idPedido);
}