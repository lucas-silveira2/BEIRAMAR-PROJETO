package com.beiramar.projeto.controllers;

import com.beiramar.projeto.dto.ItensDTO;
import com.beiramar.projeto.models.ItensModel;
import com.beiramar.projeto.repositories.ItensRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/itens")
public class ItensController {

    @Autowired
    private ItensRepository itensRepository;
/*
    @PostMapping
    public String adicionarItem(@RequestBody ItensDTO dto) {
        ItensModel item = new ItensModel();
        item.setIdPedido(dto.idPedido());
        item.setQtItem(dto.qtItem());
        itensRepository.save(item);
        return "Item adicionado com sucesso!";
    }
*/
    @PostMapping
    public ResponseEntity<ItensModel> saveProduct(@RequestBody @Valid ItensDTO itensDto) {
        var itensModel = new ItensModel();
        BeanUtils.copyProperties(itensDto, itensModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(itensRepository.save(itensModel));
    }

    @DeleteMapping("/{id}")
    public String removerItem(@PathVariable Integer id) {
        Optional<ItensModel> item = itensRepository.findById(id);
        if (item.isPresent()) {
            itensRepository.deleteById(id);
            return "Item removido com sucesso!";
        } else {
            return "Item não encontrado.";
        }
    }
}