package com.ecommerce.rush.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import com.ecommerce.rush.service.Categoria;
import com.ecommerce.rush.service.LojaService;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

@SpringBootTest
@AutoConfigureMockMvc
public class CategoriaControllerTest {

    //Convert objetc Java em Json e vice versa
    ObjectMapper mapper = new ObjectMapper();

    @MockBean
    LojaService lojaService;

    // criando objeto que testa requisições http
    @Autowired
    private MockMvc mockMvc;
    
    @Test
    public void deveMostrarTodasCategorias() throws Exception{
    
        List<Categoria> categorias = new ArrayList<>();
        Categoria categoria = new Categoria();
        categoria.setId(1);
        categoria.setNome("Celulares");        
        categorias.add(categoria);

        when(lojaService.listarTodasCategorias()).thenReturn(categorias);


        MvcResult resultado = mockMvc.perform(get("/categoria"))
            .andExpect(status().isOk())
            .andReturn();

        String json = resultado.getResponse().getContentAsString();
        String jsonEsperado = mapper.writeValueAsString(categorias);
       
        assertEquals(jsonEsperado, json);

    }

    @Test
    public void deveCriarCategoria() throws Exception{

        Categoria categoria = new Categoria();
        categoria.setNome("Celulares");

        String requestBody = mapper.writeValueAsString(categoria);
        
        categoria.setId(1);
        
        when(lojaService.criarCategoria(any())).thenReturn(categoria);
        

        MvcResult resultado = mockMvc.perform(
                post("/categoria")
                    .content(requestBody)
                    .contentType(MediaType.APPLICATION_JSON)
            )
            .andExpect(status().isCreated())
            .andReturn();

        String responseBody = resultado.getResponse().getContentAsString();
        
        String respostaEsperada = mapper.writeValueAsString(categoria);
        assertEquals(respostaEsperada, responseBody);

    }

}
