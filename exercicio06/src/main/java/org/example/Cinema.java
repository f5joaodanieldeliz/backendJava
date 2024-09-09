package org.example;

import java.util.ArrayList;

public class Cinema {
    public ArrayList<String> filmesDisponiveis = new ArrayList<>();
    public ArrayList<String> ingressosVendidos = new ArrayList<>();

    public void adicionarFilme(String filme) {
        filmesDisponiveis.add(filme);
    }

    public void adicionarIngresso(String ingresso){
        ingressosVendidos.add(ingresso);
    }
}
