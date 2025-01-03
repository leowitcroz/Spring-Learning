package com.cursoJava.produtosApi.controller;

import com.cursoJava.produtosApi.model.Produto;
import com.cursoJava.produtosApi.repository.ProdutosRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("produtos")
public class ProdutoController {

    private ProdutosRepository produtosRepository;

    public ProdutoController(ProdutosRepository produtosRepository) {
        this.produtosRepository = produtosRepository;
    }

    @PostMapping
    public Produto Salvar(@RequestBody Produto produto){
        System.out.println(produto);
        var id = UUID.randomUUID().toString();
        produto.setId(id);

        produtosRepository.save(produto);
        return produto;
    }

    @GetMapping("/{id}")
    public Produto obterPorId(@PathVariable("id") String id){
        return produtosRepository.findById(id).orElse(null);
    }

    @GetMapping()
    public List<Produto> obterProdutos(@RequestParam("descricao") String descricao){
        return produtosRepository.findByDescricao(descricao);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id){
        produtosRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public void atualizar(@PathVariable("id") String id, @RequestBody Produto produto){
        produto.setId(id);
        produtosRepository.save(produto);

    }
}
