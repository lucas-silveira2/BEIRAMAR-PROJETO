package com.beiramar.projeto.repositories;

import com.beiramar.projeto.models.ItensModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ItensRepository extends JpaRepository<ItensModel, Integer> {
    Optional<ItensModel> findByIdItem(int idItem);

    Optional<ItensModel> findAllByIdItem(int idItem);
}