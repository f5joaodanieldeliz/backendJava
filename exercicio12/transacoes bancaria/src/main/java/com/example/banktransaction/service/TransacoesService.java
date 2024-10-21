package com.example.banktransaction.service;

import com.example.banktransaction.Conta;
import com.example.banktransaction.dto.TransacaoRequestDTO;
import com.example.banktransaction.dto.TransacaoResponseDTO;
import com.example.banktransaction.mapper.ContaMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransacoesService {
    private List<Conta> contas;

    public TransacoesService() {
        contas = new ArrayList<>();
        contas.add(new Conta("500-1", "Fulano"));
        contas.add(new Conta("320-2", "Ciclano"));
    }

    public List<Conta> getContas() {
        return contas;
    }

    public TransacaoResponseDTO realizarTransacao(TransacaoRequestDTO request) {
        Conta origem = contas.stream()
                .filter(conta -> conta.getCodigo().equals(request.getOrigem()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Conta de origem não encontrada"));

        Conta destino = contas.stream()
                .filter(conta -> conta.getCodigo().equals(request.getDestino()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Conta de destino não encontrada"));

        double valor = request.getValor();
        return new TransacaoResponseDTO(origem, destino, valor);
    }
}