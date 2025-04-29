package com.beiramar.projeto.repositories;

import com.beiramar.projeto.models.MesaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MesaRepository extends JpaRepository<MesaModel, Integer> {
    Optional<MesaModel> findByIdMesa(int idMesa);

    Optional<MesaModel> findAllByIdMesa(int idMesa);
}