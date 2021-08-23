package com.ecommerce.rush.service;

import java.util.List;

import com.ecommerce.rush.repository.CategoriaRepository;
import com.ecommerce.rush.repository.ProdutoRepository;

import org.springframework.stereotype.Service;

@Service
public class LojaService {

    CategoriaRepository categoriaRepository = new CategoriaRepository();
    ProdutoRepository produtoRepository = new ProdutoRepository();

    public void criarCaregoria(Categoria categoria) {

        categoriaRepository.inserirCategoria(categoria);
    }

    public List<Categoria> listarTodasCategorias() {
        return categoriaRepository.buscarTodasCategorias();
    }

    public Produto criarProduto(Produto produto) {
        List<Categoria> listaCategoria = categoriaRepository.obterListaCategoriasPorIds(produto.getCategoriaIds());
        produto.setCategoriasPrd(listaCategoria);
        produtoRepository.inserirProduto(produto);
        return produto;
    }

    public List<Produto> listarTodosProdutos() {
        return produtoRepository.buscarTodosProdutos();
    }

}
