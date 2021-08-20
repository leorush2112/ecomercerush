package com.ecommerce.rush.service;

import com.ecommerce.rush.repository.CategoriaRepository;

import org.springframework.stereotype.Service;

@Service
public class LojaService {

    CategoriaRepository categoriaRepository = new CategoriaRepository();

    public void criarCaregoria(Categoria categoria) {

        categoriaRepository.inserirCategoria(categoria);
    }

}
