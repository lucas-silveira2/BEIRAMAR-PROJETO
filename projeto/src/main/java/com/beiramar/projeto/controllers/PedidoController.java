package com.beiramar.projeto.controllers;

import com.beiramar.projeto.models.PedidoModel;
import com.beiramar.projeto.repositories.PedidoRepository;
import com.beiramar.projeto.dto.PedidoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoRepository pedidoRepository;

    @PostMapping
    public String cadastrarPedido(@RequestBody PedidoDTO dto) {
        PedidoModel pedido = new PedidoModel();
        pedido.setIdMesa(dto.idMesa());
        pedido.setFormaPagamento(dto.formaPagamento());
        pedido.setVlPedido(dto.vlPedido());
        pedido.setFeedBack(dto.feedBack());
        pedidoRepository.save(pedido);
        return "Pedido cadastrado com sucesso!";
    }

    @GetMapping
    public List<PedidoModel> listarPedido() {
        return pedidoRepository.findAll();
    }

    @PutMapping("/{idPedido}")
    public String alterarPedido(@PathVariable Integer idPedido, @RequestBody PedidoDTO dto) {
        PedidoModel pedido = pedidoRepository.findById(idPedido).orElse(null);
        if (pedido != null) {
            pedido.setIdMesa(dto.idMesa());
            pedido.setFormaPagamento(dto.formaPagamento());
            pedido.setVlPedido(dto.vlPedido());
            pedido.setFeedBack(dto.feedBack());
            pedidoRepository.save(pedido);
            return "Pedido alterado com sucesso!";
        }
        return "Pedido não encontrado.";
    }

    @DeleteMapping("/{idPedido}")
    public String excluirPedido(@PathVariable Integer idPedido ) {
        pedidoRepository.deleteById(idPedido);
        return "Pedido excluído com sucesso!";
    }

    @GetMapping("/{idPedido}/calcular")
    public Double calcularPedido(@PathVariable Integer id) {
        PedidoModel pedido = pedidoRepository.findById(id).orElse(null);
        return pedido != null ? pedido.getVlPedido() : 0.0;
    }

    @PostMapping("/{idPedido}/pagar")
    public String realizarPagamento(@PathVariable Integer id, @RequestParam String formaPagamento) {
        PedidoModel pedido = pedidoRepository.findById(id).orElse(null);
        if (pedido != null) {
            return "Pagamento realizado com forma: " + formaPagamento;
        }
        return "Pedido não encontrado.";
    }

    @GetMapping("/{idPedido}/comprovante")
    public String gerarComprovante(@PathVariable Integer id) {
        return "Comprovante do pedido " + id + " gerado com sucesso!";
    }

    @PostMapping("/{idPedido}/feedback")
    public String registrarFeedback(@PathVariable Integer id, @RequestParam Boolean feedback) {
        PedidoModel pedido = pedidoRepository.findById(id).orElse(null);
        if (pedido != null) {
            pedido.setFeedBack(feedback);
            pedidoRepository.save(pedido);
            return "Feedback registrado com sucesso!";
        }
        return "Pedido não encontrado.";
    }
}