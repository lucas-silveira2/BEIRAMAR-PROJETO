package com.beiramar.projeto.controllers;

import com.beiramar.projeto.models.MesaModel;
import com.beiramar.projeto.repositories.MesaRepository;
import com.beiramar.projeto.repositories.PedidoRepository;
import com.beiramar.projeto.models.PedidoModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mesas")
public class MesaController {

    @Autowired
    private MesaRepository mesaRepository;

    @Autowired
    private PedidoRepository pedidoRepository;

    @PostMapping
    public String cadastrarMesa(@RequestBody MesaModel mesa) {
        mesaRepository.save(mesa);
        return "Mesa cadastrada com sucesso!";
    }

    @GetMapping
    public List<MesaModel> listarMesas() {
        return mesaRepository.findAll();
    }

    @GetMapping("/{idMesa}/calcularTotalPedidos")
    public Double calcularTotalPedidos(@PathVariable Integer idMesa) {
        List<PedidoModel> pedidMesaos = pedidoRepository.findAll();
        double total = pedidMesaos.stream()
                .filter(p -> p.getIdMesa().equals(idMesa))
                .mapToDouble(PedidoModel::getVlPedido)
                .sum();
        return total;
    }
}