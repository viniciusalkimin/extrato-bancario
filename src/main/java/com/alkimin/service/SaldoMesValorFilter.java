package com.alkimin.service;

import com.alkimin.model.FilterModel;
import com.alkimin.model.TransacaoBancaria;

import java.math.BigDecimal;
import java.util.List;

public class SaldoMesValorFilter implements SaldoFilter{
    @Override
    public BigDecimal filtrar(List<TransacaoBancaria> transacoes, FilterModel filter) {
        BigDecimal valorTotal = BigDecimal.ZERO;
        List<BigDecimal> listaFiltrada = transacoes.stream()
                .filter(t -> t.getValor().compareTo(filter.getValor()) >= 0 && t.getData().getMonth() == filter.getMes())
                .map(t -> t.getValor())
                .toList();

        for (BigDecimal valorTransacao: listaFiltrada) {
            valorTotal = valorTotal.add(valorTransacao);
        }
        return  valorTotal;
    }
}
