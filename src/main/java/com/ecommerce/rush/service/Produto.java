package com.ecommerce.rush.service;

import java.util.List;

public class Produto {

    private int id;
    private String nome;
    private List<Integer> categoriaIDs;
    private String marca;
    private double preco;
    private int estoque;
    private boolean estaAtivo;

    public Produto() {
        estaAtivo = true;
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

    public List<Integer> getCategoriaIDs() {
        return categoriaIDs;
    }

    public void setCategoriaIDs(List<Integer> categoriaIDs) {
        this.categoriaIDs = categoriaIDs;
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
