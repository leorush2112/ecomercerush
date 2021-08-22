package com.ecommerce.rush.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        List<Categoria> categoriasPost = new ArrayList<>();
        for (int i = 0; i < produto.getCategoriaIds().size(); i++) {
            int id = produto.getCategoriaIds().get(i);
            Optional<Categoria> categoriaAchou = categoriaRepository.buscarCategoria(id);
            categoriasPost.add(categoriaAchou.get());
            produto.setCategoriasPrd(categoriasPost);
        }
        produtoRepository.inserirProduto(produto);

        return produto;
    }

}
