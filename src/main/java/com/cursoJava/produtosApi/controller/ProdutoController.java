package com.cursoJava.produtosApi.controller;

import com.cursoJava.produtosApi.model.Produto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("produtos")
public class ProdutoController {

    @PostMapping
    public Produto Salvar(@RequestBody Produto produto){
        System.out.println(produto);
        return produto;
    }
}
