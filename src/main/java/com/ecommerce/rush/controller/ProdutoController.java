package com.ecommerce.rush.controller;

import java.util.List;

import com.ecommerce.rush.exception.CategoriaInexistenteException;
import com.ecommerce.rush.exception.ValidacaoProdutoException;
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
    public Produto inserirProduto(@RequestBody Produto produto) {
        
       return lojaService.criarProduto(produto);
        
    }

    @GetMapping("/produto")
    public List<Produto> mostrarTodosProdutos() {

        return lojaService.listarTodosProdutos();
        
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
