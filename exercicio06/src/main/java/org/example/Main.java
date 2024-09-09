package org.example;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        //Variaveis
//        String[][] assentos = {
//            {"A1", "A2", "A3", "A4", "A5"},
//            {"B1", "B2", "B3", "B4", "B5"},
//            {"C1", "C2", "C3", "C4", "C5"},
//            {"D1", "D2", "D3", "D4", "D5"},
//            {"E1", "E2", "E3", "E4", "E5"},
//            {"F1", "F2", "F3", "F4", "F5"},
//        };
        ArrayList<String> assentos = new ArrayList<>();

        //INSTANCIAS

        //Scanner
        Scanner scanner = new Scanner(System.in);

        //Cinema
        Cinema cinema = new Cinema();

        //Filme
        Filme filme1 = new Filme("Vingadores", 20.0, 16);
        Filme filme2 = new Filme("Homem Aranha", 20.0, 16);
        Filme filme3 = new Filme("Batman", 20.0, 16);
        Filme filme4 = new Filme("Superman", 20.0, 16);
        Filme filme5 = new Filme("Mulher Maravilha", 20.0, 16);

        //Ingresso
        Ingresso ingresso = new Ingresso();

        //Adicionando filmes ao cinema
        cinema.adicionarFilme(filme1.nome.toUpperCase());
        cinema.adicionarFilme(filme2.nome.toUpperCase());
        cinema.adicionarFilme(filme3.nome.toUpperCase());
        cinema.adicionarFilme(filme4.nome.toUpperCase());
        cinema.adicionarFilme(filme5.nome.toUpperCase());

        System.out.println("Bem vindo ao cinema!");
        while(true){

            System.out.println("Insira o nome do cliente: ");
            ingresso.cliente = scanner.nextLine();

            System.out.println("Escolha um dos filmes disponíveis: " + cinema.filmesDisponiveis);
            ingresso.filme = scanner.nextLine();

            if (!cinema.filmesDisponiveis.contains(ingresso.filme.toUpperCase())) {
                throw new Exception("Filme não disponível! Escolha outro por favor...");
            }

            System.out.println("Qual a sua idade? ");
            Integer idade = scanner.nextInt();
            scanner.nextLine();

           Cliente cliente = new Cliente(ingresso.cliente, idade);

            switch (ingresso.filme.toUpperCase()) {
                case "VINGADORES":
                    if (cliente.getIdade() < filme1.getIdadeMinima()) {
                        throw new Exception("Você não tem idade suficiente para assistir a este filme!");
                    }
                    break;
                case "HOMEM ARANHA":
                    if (cliente.getIdade() < filme2.getIdadeMinima()) {
                        throw new Exception("Você não tem idade suficiente para assistir a este filme!");
                    }
                    break;
                case "BATMAN":
                    if (cliente.getIdade() < filme3.getIdadeMinima()) {
                        throw new Exception("Você não tem idade suficiente para assistir a este filme!");
                    }
                    break;
                case "SUPERMAN":
                    if (cliente.getIdade() < filme4.getIdadeMinima()) {
                        throw new Exception("Você não tem idade suficiente para assistir a este filme!");
                    }
                    break;
                case "MULHER MARAVILHA":
                    if (cliente.getIdade() < filme5.getIdadeMinima()) {
                        throw new Exception("Você não tem idade suficiente para assistir a este filme!");
                    }
                    break;
                default:
                    break;
            }

            System.out.println("Escolha um assento (A1 a F5): ");
            ingresso.assento = scanner.nextLine().toUpperCase();

            if (!assentos.contains(ingresso.assento)) {
                assentos.add(ingresso.assento);
                cinema.adicionarIngresso(ingresso.assento);
                System.out.println("Ingresso vendido com sucesso! " + ingresso.filme + " - " + ingresso.assento + " - " + ingresso.cliente);
            }else {
                throw new Exception("Assento já ocupado! Escolha outro por favor...");
            }
        }
    }
}