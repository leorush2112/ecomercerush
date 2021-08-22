package com.ecommerce.rush;

import java.util.List;
import java.util.Optional;

import com.ecommerce.rush.repository.CategoriaRepository;
import com.ecommerce.rush.service.Categoria;
import com.ecommerce.rush.service.LojaService;
import com.ecommerce.rush.service.Produto;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RushController {

    LojaService lojaService = new LojaService();

    @PostMapping("/categoria")
    public Categoria inserirCategoria(@RequestBody Categoria categoria) {
        lojaService.criarCaregoria(categoria);
        return categoria;
    }

    @GetMapping("/categoria")
    public List<Categoria> mostrarTodasCategorias() {
        return lojaService.listarTodasCategorias();
    }

    @PostMapping("/produto")
    public Produto inserirProduto(@RequestBody Produto produto) {
        lojaService.criarProduto(produto);
        return produto;
    }

}
