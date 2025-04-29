package com.beiramar.projeto.controllers;

import com.beiramar.projeto.models.ProdutoModel;
import com.beiramar.projeto.repositories.ProdutoRepository;
import com.beiramar.projeto.dto.ProdutoDTO;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    ProdutoRepository produtoRepository;

    @PostMapping
    public ResponseEntity<ProdutoModel> saveProduct(@RequestBody @Valid ProdutoDTO produtoDto) {
        var produtoModel = new ProdutoModel();
        BeanUtils.copyProperties(produtoDto, produtoModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoRepository.save(produtoModel));
    }

    @GetMapping
    public ResponseEntity<List<ProdutoModel>> getAllProducts() {
        return ResponseEntity.status(HttpStatus.OK).body(produtoRepository.findAll());
    }

    @GetMapping("/{idProduto}")
    public ResponseEntity<Object> getOneProduct(@PathVariable(value = "idProduto") int idProduto) {
        Optional<ProdutoModel> productO = produtoRepository.findByIdProduto(idProduto);
        if (productO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado");
        }
        return ResponseEntity.status(HttpStatus.OK).body(productO.get());
    }

    @PutMapping("/{idProduto}")
    public ResponseEntity<Object> updateProduct(@PathVariable(value = "idProduto") int idProduto,
                                                @RequestBody @Valid ProdutoDTO productRecordDto) {
        Optional<ProdutoModel> productO = produtoRepository.findByIdProduto(idProduto);
        if (productO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado");
        }
        var productModel = productO.get();
        BeanUtils.copyProperties(productRecordDto, productModel);
        return ResponseEntity.status(HttpStatus.OK).body(produtoRepository.save(productModel));
    }

    @DeleteMapping("/{idProduto}")
    public ResponseEntity<Object> deleteProduct(@PathVariable(value = "idProduto") int idProduto) {
        Optional<ProdutoModel> productO = produtoRepository.findByIdProduto(idProduto);
        if (productO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado");
        }
        produtoRepository.delete(productO.get());
        return ResponseEntity.status(HttpStatus.OK).body("Produto excluído com sucesso!");
    }
}