package com.ecommerce.rush.controller;

import java.util.ArrayList;
import java.util.List;

import com.ecommerce.rush.exception.CategoriaInexistenteException;
import com.ecommerce.rush.exception.ValidacaoException;
import com.ecommerce.rush.repository.Categoria;
import com.ecommerce.rush.repository.Produto;
import com.ecommerce.rush.service.LojaService;

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
    public CategoriaSemProduto inserirCategoria(@RequestBody Categoria categoria) {        
        return CategoriaSemProduto.construir(lojaService.criarCategoria(categoria));
    }

    @GetMapping("/categoria")
    public List<CategoriaSemProduto> mostrarTodasCategorias() {
        List<CategoriaSemProduto> listaCategoriasSemProdutos = new ArrayList<>();
        for(Categoria categoria : lojaService.listarTodasCategorias()){
            listaCategoriasSemProdutos.add(CategoriaSemProduto.construir(categoria));
        }
        return listaCategoriasSemProdutos;        
    }

    @GetMapping("/categoria/{id}")
    public CategoriaComProdutos mostrarCategoriaComProdutos(@PathVariable int id){
        
        Categoria categoria = lojaService.buscarCategoriaPorId(id);
        List<ProdutoSemCat> produtosSemCategorias = new ArrayList<>();
        for(Produto produto : categoria.getProdutos()){
            produtosSemCategorias.add(ProdutoSemCat.construir(produto));
        }                      
        return CategoriaComProdutos.construir(categoria, produtosSemCategorias);   
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
