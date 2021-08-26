package com.ecommerce.rush.controller;

import java.util.List;
import java.util.ArrayList;

import com.ecommerce.rush.repository.CategoriaInexistenteException;
import com.ecommerce.rush.service.Categoria;
import com.ecommerce.rush.service.LojaService;
import com.ecommerce.rush.service.Produto;

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
    public ProdutoComCategorias inserirProduto(@RequestBody Produto produto) {
        Produto produtoInserido = lojaService.criarProduto(produto);
        List<Categoria> categorias = lojaService.buscarCategoriaPorListaDeIds(produtoInserido.getCategoriaIds());
        return ProdutoComCategorias.construir(produtoInserido, categorias);
    }

    @GetMapping("/produto")
    public List<ProdutoComCategorias> mostrarTodosProdutos() {
        List<Produto> produtos = lojaService.listarTodosProdutos();
        List<ProdutoComCategorias> produtosComCategorias = new ArrayList<>();
        for(Produto produto : produtos){
            List<Categoria> categorias = lojaService.buscarCategoriaPorListaDeIds(produto.getCategoriaIds());
            ProdutoComCategorias produtoComCategoria = ProdutoComCategorias.construir(produto, categorias); 
            produtosComCategorias.add(produtoComCategoria);
        }
        return produtosComCategorias;
    }

    @ExceptionHandler(CategoriaInexistenteException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public RespostaApi tratarCategoriaInexistente(CategoriaInexistenteException exception){
        return new RespostaApi(exception.getMessage());
    }


}
