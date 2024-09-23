package com.example.exercicio08.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClient;

import java.util.HashMap;
import java.util.List;

@RestController
public class FipeController {
    RestClient cliente = RestClient.create("https://parallelum.com.br");

    @GetMapping("/fipe/codigo/marca/{nomeMarca}")
    @ResponseBody
    public String getCodigoMarca(@PathVariable String nomeMarca) {
        List<HashMap<String, Object>> resposta = cliente
                .get()
                .uri("/fipe/api/v1/carros/marcas")
                .retrieve()
                .body(List.class);

        if (resposta != null) {
            for (HashMap<String, Object> marca : resposta) {
                if (marca.get("nome").toString().equalsIgnoreCase(nomeMarca)) {
                    return marca.get("codigo").toString();
                }
            }
        }
        return null;
    }

    @GetMapping("/fipe/codigo/modelo/{codigoMarca}/{nomeModelo}")
    @ResponseBody
    public String getCodigoModelo(@PathVariable String codigoMarca, @PathVariable String nomeModelo) {
        HashMap<String, Object> resposta = cliente
                .get()
                .uri("/fipe/api/v1/carros/marcas/" + codigoMarca + "/modelos")
                .retrieve()
                .body(HashMap.class);

        if (resposta != null && resposta.containsKey("modelos")) {
            List<HashMap<String, Object>> modelos = (List<HashMap<String, Object>>) resposta.get("modelos");
            for (HashMap<String, Object> modelo : modelos) {
                if (modelo.get("nome").toString().equalsIgnoreCase(nomeModelo)) {
                    return modelo.get("codigo").toString();
                }
            }
        }
        return null;
    }

    @GetMapping("/fipe/codigo/ano/{codigoMarca}/{codigoModelo}/{nomeAno}")
    @ResponseBody
    public String getCodigoAno(@PathVariable String codigoMarca, @PathVariable String codigoModelo, @PathVariable String nomeAno) {
        List<HashMap<String, Object>> resposta = cliente
                .get()
                .uri("/fipe/api/v1/carros/marcas/" + codigoMarca + "/modelos/" + codigoModelo + "/anos")
                .retrieve()
                .body(List.class);

        if (resposta != null) {
            for (HashMap<String, Object> ano : resposta) {
                if (ano.get("nome").toString().equalsIgnoreCase(nomeAno)) {
                    return ano.get("codigo").toString();
                }
            }
        }
        return null;
    }

    @PostMapping("/fipe")
    @ResponseBody
    public HashMap<String, String> valor(@RequestBody CarroRequest carroRequest) {
        String codigoMarca = getCodigoMarca(carroRequest.getMarca());
        String codigoModelo = getCodigoModelo(codigoMarca, carroRequest.getModelo());
        String codigoAno = getCodigoAno(codigoMarca, codigoModelo, carroRequest.getAno());

        HashMap<String, String> respostaRequisicao = new HashMap<>();

        HashMap<String, Object> resposta = cliente
                .get()
                .uri("/fipe/api/v1/carros/marcas/" + codigoMarca + "/modelos/" + codigoModelo + "/anos/" + codigoAno)
                .retrieve()
                .body(HashMap.class);

        if (resposta != null) {
            respostaRequisicao.put("valor", resposta.get("Valor").toString());
            respostaRequisicao.put("mes", resposta.get("MesReferencia").toString());
        }
        return respostaRequisicao;
    }
}