package org.example;
import java.util.ArrayList;

public class Cliente {
    private String nome;
    private Integer idade;

    ArrayList<String> clientes = new ArrayList<>();

    public Cliente(String nome, Integer idade) {
        this.nome = nome;
        this.idade = idade;

        clientes.add(nome);
    }

    public String getNome() {
        return nome;
    }
    public Integer getIdade() {
        return idade;
    }
}
