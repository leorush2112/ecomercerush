package com.ecommerce.rush.controller;

import java.util.List;

import com.ecommerce.rush.service.Categoria;
import com.ecommerce.rush.service.LojaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoriaController {

    @Autowired    
    LojaService lojaService;

    @PostMapping("/categoria")
    public Categoria inserirCategoria(@RequestBody Categoria categoria) {
        lojaService.criarCaregoria(categoria);
        return categoria;
    }

    @GetMapping("/categoria")
    public List<Categoria> mostrarTodasCategorias() {
        return lojaService.listarTodasCategorias();
    }    
}
