package com.ecommerce.rush;

import com.ecommerce.rush.repository.CategoriaRepository;
import com.ecommerce.rush.service.Categoria;
import com.ecommerce.rush.service.LojaService;

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
}
