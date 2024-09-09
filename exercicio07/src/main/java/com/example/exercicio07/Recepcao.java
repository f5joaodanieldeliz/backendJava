package com.example.exercicio07;

import org.springframework.stereotype.Component;

@Component
public class Recepcao {
    String text= "Bem-vindo ao sistema de recomendação de filmes!";
    String text2= "navegue para /recomendar?genero=genero&ambiente=ambiente e";
    String text3= "substituia genero por drama ou comedia e embiente por sci-fi ou medieval para receber uma recomendação!";

    public String receber(){
        return text + "\n" + text2 + "\n" + text3;
    }
}
