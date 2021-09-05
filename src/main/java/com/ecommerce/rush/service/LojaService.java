package com.ecommerce.rush.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.ecommerce.rush.controller.ProdutoSemCat;
import com.ecommerce.rush.exception.CategoriaInexistenteException;
import com.ecommerce.rush.repository.CategoriaRepository;
import com.ecommerce.rush.repository.ProdutoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LojaService {

    @Autowired
    private CategoriaRepository categoriaRepository;
    
    @Autowired
    private ProdutoRepository produtoRepository;

    public Categoria criarCategoria(Categoria categoria) {

        return categoriaRepository.inserirCategoria(categoria);
        
    }

    public List<Categoria> listarTodasCategorias() {

        return categoriaRepository.buscarTodasCategorias();
    }

    public Categoria buscarCategoriaPorId(int id){
       
        Optional<Categoria> categoriaAchou = categoriaRepository.buscarCategoria(id);
        
        if(categoriaAchou.isEmpty()){
            throw new CategoriaInexistenteException(id);
        }
        return categoriaAchou.get();
        
    }

    public List<Categoria> buscarCategoriaPorListaDeIds(List<Integer> listaCategoriaIds){
        return categoriaRepository.obterListaCategoriasPorIds(listaCategoriaIds);
    }

    public Produto criarProduto(Produto produto) {
        categoriaRepository.obterListaCategoriasPorIds(produto.getCategoriaIds());
        produtoRepository.inserirProduto(produto);
        return produto;
    }

    public List<Produto> listarProdutosPorCategoria(Categoria categoria)
    {               
        return produtoRepository.buscarProdutosPorCategoria(categoria);
    }

    public List<Produto> listarTodosProdutos() {
        return produtoRepository.buscarTodosProdutos();
    }

}
