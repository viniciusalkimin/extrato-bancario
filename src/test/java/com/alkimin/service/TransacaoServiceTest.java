package com.alkimin.service;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TransacaoServiceTest {

    @Test
    void deveGerarTransacaoComSucesso() {
        List<String> linhas = List.of("2022-12-05,Salario,5000");

        TransacaoService transacaoService = new TransacaoService();
        var transacoes = transacaoService.gerarTransacoes(linhas);
        var transacao = transacoes.get(0);

        assertEquals("Salario", transacao.getNome());
        assertEquals("5000", transacao.getValor().toString());
    }
}