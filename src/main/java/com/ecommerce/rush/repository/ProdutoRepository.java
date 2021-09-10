package com.ecommerce.rush.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto,Integer> {

    //List<Produto> findAllByCategorias(List<Categoria> categorias);

    
}
