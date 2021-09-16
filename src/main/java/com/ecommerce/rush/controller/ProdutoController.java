package com.ecommerce.rush.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.ecommerce.rush.exception.CategoriaInexistenteException;
import com.ecommerce.rush.exception.ValidacaoProdutoException;
import com.ecommerce.rush.repository.Categoria;
import com.ecommerce.rush.repository.Produto;
import com.ecommerce.rush.service.LojaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProdutoController {

    @Autowired 
    LojaService lojaService;
    
    @PostMapping("/produto")
    @ResponseStatus(HttpStatus.CREATED)
    public ProdutoComCategorias inserirProduto(@RequestBody Produto produto) {

        List<Integer> categoriasPorIds = produto.getCategorias()
                .stream()
                .map(Categoria::getId)
                .collect(Collectors.toList());

        List<CategoriaSemProduto> categoriaSemProdutos = lojaService.buscarCategoriaPorListaDeIds(categoriasPorIds)
                .stream()
                .map(CategoriaSemProduto::construir)
                .collect(Collectors.toList());

        return ProdutoComCategorias.construir(lojaService.criarProduto(produto),categoriaSemProdutos);
    }

    @GetMapping("/produto")
    public List<ProdutoSemCat> mostrarTodosProdutos() {

        return lojaService.listarTodosProdutos()
                .stream()
                .map(ProdutoSemCat::construir)
                .collect(Collectors.toList());
    }

    @ExceptionHandler(CategoriaInexistenteException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public RespostaApi tratarCategoriaInexistente(CategoriaInexistenteException exception){
        return new RespostaApi(exception.getMessage());
    }
    
    @ExceptionHandler(ValidacaoProdutoException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public RespostaApi tratarCamposProduto(ValidacaoProdutoException exception){
        return new RespostaApi(exception.getLocalizedMessage());
    }


}
