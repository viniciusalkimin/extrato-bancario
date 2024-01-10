package com.alkimin.service;

import com.alkimin.model.TransacaoBancaria;

import java.util.ArrayList;
import java.util.List;

public class TransacaoService {

    public List<TransacaoBancaria> gerarTransacoes(List<String> linhas) {
        List<TransacaoBancaria> transacoes = new ArrayList<>();
        linhas.stream().forEach(e -> {
            String[] campos = e.split(",");
            var t = new TransacaoBancaria(campos[0], campos[1], campos[2]);
            transacoes.add(t);
        });
        return transacoes;
    }
}
