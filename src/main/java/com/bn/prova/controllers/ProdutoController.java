package com.bn.prova.controllers;

import com.bn.prova.models.Produto;
import com.bn.prova.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    public ResponseEntity<Produto> criarProduto(@RequestBody Produto produto) {
        Produto request = produtoService.criarProduto(produto);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(request.getId()).toUri();

        return ResponseEntity.created(uri).body(request);
    }

    @GetMapping
    public ResponseEntity<List<Produto>> buscarTodosProdutos() {
        List<Produto> request = produtoService.buscarTodosProdutos();
        return ResponseEntity.ok().body(request);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> buscarProdutoPorId(@PathVariable Long id) {
        Optional<Produto> request = produtoService.buscarProdutoPorId(id);

        if(request.isPresent()) {
            return ResponseEntity.ok(request.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produto> atualizarProduto(@PathVariable Long id,@RequestBody Produto produto) {
        Optional<Produto> request = produtoService.atualizarProduto(id, produto);

        if(request.isPresent()) {
            return ResponseEntity.ok(request.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarProduto(@PathVariable Long id) {
        Optional<Produto> request = produtoService.buscarProdutoPorId(id);

        if(request.isPresent()) {
            produtoService.deletarProduto(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
