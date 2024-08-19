package org.example;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner  leitor =  new Scanner(System.in);


        System.out.println("pergunta 1 que ambientacao voce prefere");
        System.out.println("1 - sci-fi");
        System.out.println("2 - medieval");
        Integer ambientacao = leitor.nextInt();


        System.out.println("pergunta 2 que genero voce prefere");
        System.out.println("1 - comedia");
        System.out.println("2 - drama");
        Integer genero = leitor.nextInt();

        if (ambientacao == 1 && genero == 1) System.out.println("homens de preto");
        if (ambientacao == 1 && genero == 2) System.out.println("Arrivel");
        if (ambientacao == 2 && genero == 1) System.out.println("Shrek");
        if (ambientacao == 2 && genero == 2) System.out.println("gladiador");

    }
}

