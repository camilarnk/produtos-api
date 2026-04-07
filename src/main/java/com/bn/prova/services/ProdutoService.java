package com.bn.prova.services;

import com.bn.prova.models.Produto;
import com.bn.prova.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto criarProduto(Produto produto) {
        return produtoRepository.save(produto);
    }

    public List<Produto> buscarTodosProdutos() {
        return produtoRepository.findAll();
    }

    public Optional<Produto> buscarProdutoPorId(Long id) {
        return produtoRepository.findById(id);
    }

    public Optional<Produto> atualizarProduto(Long id, Produto produto) {
        Optional<Produto> request = produtoRepository.findById(id);

        if(request.isPresent()) {
            Produto novoProduto = request.get();

            novoProduto.setNome(produto.getNome());
            novoProduto.setDescricao(produto.getDescricao());
            novoProduto.setPreco(produto.getPreco());
            novoProduto.setStatus(produto.getStatus());

            return Optional.of(produtoRepository.save(novoProduto));
        }
        return Optional.empty();
    }

    public void deletarProduto(Long id) {
        produtoRepository.deleteById(id);
    }
}
