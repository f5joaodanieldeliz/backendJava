package com.example.exercicio07.Controllers;

import com.example.exercicio07.Recepcao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;
import java.util.Random;

@RestController
@RequestMapping("/")
public class FilmRecommendation {

    @Autowired
    private Recepcao recepcao;

    @GetMapping("/")
    public String recepcao(){
        return recepcao.receber();
    }

    @GetMapping("/recomendar")
    public String genero(@RequestParam String genero, @RequestParam String ambiente){

            Random aleatorio= new Random();

            // Array de filmes de Sci-fi Drama
            String[] sciFiDrama = {"Interstellar", "Arrival", "Ex Machina", "Her", "2001: Uma Odisseia no Espaço"};

            // Array de filmes de Sci-fi Comédia
            String[] sciFiComedia = {"Galaxy Quest", "O Quinto Elemento", "Back to the Future", "Men in Black", "Spaceballs"};

            // Array de filmes Medieval Comédia
            String[] medievalComedia = {"Monty Python e o Cálice Sagrado", "A Princesa Prometida", "O Nome da Rosa", "Shrek", "Alexandre e o Dia Maravilhoso"};

            // Array de filmes Medieval Drama
            String[] medievalDrama = {"Gladiador", "O Último dos Moicanos", "O Nome da Rosa", "Braveheart", "A 13ª Guerreira"};

            //array de Sci-fi Drama
            int posicaoAleatoriaScifiDrama = aleatorio.nextInt(sciFiDrama.length);
            String scifiDramaEscolhido = sciFiDrama[posicaoAleatoriaScifiDrama];

            //array de Sci-fi Comédia
            int posicaoAleatoriaScifiComedia = aleatorio.nextInt(sciFiComedia.length);
            String sciFiComediaEscolhido =  sciFiComedia[posicaoAleatoriaScifiComedia];

            //Array de Medieval Comédia
            int posicaoAleatoriaMedComedia = aleatorio.nextInt(medievalComedia.length);
            String medComediaEscolhido =  medievalComedia[posicaoAleatoriaMedComedia];

            //Array de Medieval Drama
            int posicaoAleatoriaMedDrama = aleatorio.nextInt(medievalDrama.length);
            String medDramaEscolhido= medievalDrama[posicaoAleatoriaMedDrama];

            if(Objects.equals(genero, "comedia") && Objects.equals(ambiente, "sci-fi")){
                return "O filme que atende o gênero escolhido é: " + sciFiComediaEscolhido + "!";
            } else if (Objects.equals(genero, "drama") && Objects.equals(ambiente, "sci-fi")){
                return "O filme que atende o gênero escolhido é: " + scifiDramaEscolhido + "!";
            } else if (Objects.equals(genero, "comedia") && Objects.equals(ambiente, "medieval")){
                return "O filme que atende o gênero escolhido é: " + medComediaEscolhido + "!";
            } else if (Objects.equals(genero, "drama") && Objects.equals(ambiente, "medieval")){
                return "O filme que atende o gênero escolhido é: " + medDramaEscolhido + "!";
            } else {
                return "Não foi possível encontrar um filme que atenda aos critérios escolhidos.";
            }

    }
}
