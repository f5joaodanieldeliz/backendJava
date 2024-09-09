package org.example;

public class Filme {
    String nome;
    Double preco;
    Integer idadeMinima;

    public Filme(String nome, Double preco, Integer idadeMinima) {
        this.nome = nome;
        this.preco = preco;
        this.idadeMinima = idadeMinima;
    }

    public Integer getIdadeMinima() {
        return idadeMinima;
    }
}
