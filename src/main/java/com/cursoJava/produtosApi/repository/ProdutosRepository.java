package com.cursoJava.produtosApi.repository;

import com.cursoJava.produtosApi.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProdutosRepository extends JpaRepository<Produto,String> {

    List<Produto> findByDescricao(String nome);

}
