package com.ecommerce.rush.service;

import java.util.List;

public class Produto {

    private int id;
    private String nome;
    private List<Integer> categoriaIds;
    private List<Categoria> categorias;
    private String marca;
    private double preco;
    private int estoque;
    private boolean estaAtivo;

    public Produto() {
        estaAtivo = true;
    }

    public List<Categoria> getCategoriasPrd() {
        return categorias;
    }

    public void setCategoriasPrd(List<Categoria> categoriasProd) {
        this.categorias = categoriasProd;
    }

    public int getEstoque() {
        return estoque;
    }

    public boolean isEstaAtivo() {
        return estaAtivo;
    }

    public void setEstaAtivo(boolean estaAtivo) {
        this.estaAtivo = estaAtivo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Integer> getCategoriaIds() {
        return categoriaIds;
    }

    public void setCategoriaIds(List<Integer> categoriaIds) {
        this.categoriaIds = categoriaIds;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

}
