package com.ecommerce.rush.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import com.ecommerce.rush.repository.CategoriaRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.integration.IntegrationAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class LojaServiceTest {
    
    @MockBean
    CategoriaRepository categoriaRepository;
    
    @Autowired
    LojaService lojaService;

    private Categoria criarCategoria() {

        Categoria categoria = new Categoria();
        categoria.setNome("Celulares");
        return categoria;
    }

    @Test
    public void deveCriarCategoria(){
        
        Categoria categoria = criarCategoria();

        lojaService.criarCategoria(categoria); 
        verify(categoriaRepository).inserirCategoria(categoria);      

    }

    @Test
    public void deveListarTodasCategorias(){
        
        List<Categoria> categorias = new ArrayList<>();
        categorias.add(criarCategoria());

        when(categoriaRepository.buscarTodasCategorias()).thenReturn(categorias);

        List<Categoria> categoriasRetornadas = lojaService.listarTodasCategorias();
        
        assertEquals(1, categoriasRetornadas.size());
        verify(categoriaRepository).buscarTodasCategorias();

    }

    @Test
    public void deveBuscarCategoriasPorListaDeIds(){
        List<Integer> listaDeIds = new ArrayList<>();

        listaDeIds.add(1);

        List<Categoria> categorias = new ArrayList<>();
        categorias.add(criarCategoria());

        when(categoriaRepository.obterListaCategoriasPorIds(listaDeIds)).thenReturn(categorias);

        List<Categoria> categoriasPorIds = lojaService.buscarCategoriaPorListaDeIds(listaDeIds);
        assertEquals(1, categoriasPorIds.size());
        verify(categoriaRepository).obterListaCategoriasPorIds(listaDeIds);
    }
    
}
