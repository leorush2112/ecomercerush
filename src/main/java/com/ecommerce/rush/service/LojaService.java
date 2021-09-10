package com.ecommerce.rush.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.ecommerce.rush.exception.CategoriaInexistenteException;
import com.ecommerce.rush.repository.Categoria;
import com.ecommerce.rush.repository.CategoriaRepository;
import com.ecommerce.rush.repository.Produto;
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

        return categoriaRepository.save(categoria);
        
    }

    public List<Categoria> listarTodasCategorias() {

        return categoriaRepository.findAll();
    }

    public Categoria buscarCategoriaPorId(int id){
       
        Optional<Categoria> categoriaAchou = categoriaRepository.findById(id);
        
        if(categoriaAchou.isEmpty()){
            throw new CategoriaInexistenteException(id);
        }
        return categoriaAchou.get();        
    }

    public List<Categoria> buscarCategoriaPorListaDeIds(List<Integer> listaCategoriaIds){
        return categoriaRepository.findAllById(listaCategoriaIds);
    }

    public Produto criarProduto(Produto produto) {
        return produtoRepository.save(produto);
        
    }

    public List<Produto> listarTodosProdutos() {
        return produtoRepository.findAll();
    }

}
