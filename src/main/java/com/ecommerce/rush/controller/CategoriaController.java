package com.ecommerce.rush.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.ecommerce.rush.exception.CategoriaInexistenteException;
import com.ecommerce.rush.exception.ValidacaoException;
import com.ecommerce.rush.service.Categoria;
import com.ecommerce.rush.service.LojaService;
import com.ecommerce.rush.service.Produto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.HttpStatus;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoriaController {

    @Autowired    
    LojaService lojaService;

    @PostMapping("/categoria")
    @ResponseStatus(HttpStatus.CREATED)
    public Categoria inserirCategoria(@RequestBody Categoria categoria) {
        return lojaService.criarCategoria(categoria);
    }

    @GetMapping("/categoria")
    public List<Categoria> mostrarTodasCategorias() {
        return lojaService.listarTodasCategorias();
    }

    @GetMapping("/categoria/{id}")
    public CategoriaComProdutos mostrarCategoriaComProdutos(@PathVariable int id){
        
        Categoria categoria = lojaService.buscarCategoriaPorId(id);
                     
        List<Produto> produtos = lojaService.listarProdutosPorCategoria(categoria);
        List<ProdutoSemCat> produtoSemCats = new ArrayList<>();
        for(Produto produto : produtos){
            ProdutoSemCat produtoSemCat = ProdutoSemCat.construir(produto);
            produtoSemCats.add(produtoSemCat);
        }     
        CategoriaComProdutos categoriaComProdutos = CategoriaComProdutos.construir(categoria, produtoSemCats);       
        return categoriaComProdutos;
    }
    
    @ExceptionHandler(ValidacaoException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public RespostaApi tratarNomeCategoriaInexistente(ValidacaoException exception){
        return new RespostaApi(exception.getMessage());
    }

    @ExceptionHandler(CategoriaInexistenteException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public RespostaApi tratarCategoriaInexistente(CategoriaInexistenteException exception){
        return new RespostaApi(exception.getMessage());
    }


}
