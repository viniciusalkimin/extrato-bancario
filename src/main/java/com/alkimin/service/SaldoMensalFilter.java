package com.alkimin.service;

import com.alkimin.model.FilterModel;
import com.alkimin.model.TransacaoBancaria;

import java.math.BigDecimal;
import java.util.List;

public class SaldoMensalFilter implements SaldoFilter{
    @Override
    public BigDecimal filtrar(List<TransacaoBancaria> transacoes, FilterModel filter) {
        BigDecimal total = BigDecimal.ZERO;
        List<BigDecimal> valores = transacoes.stream()
                .filter(t -> t.getData().getMonth().equals(filter.getMes()))
                .map(TransacaoBancaria::getValor)
                .toList();

        for (BigDecimal v : valores) {
            total = total.add(v);
        }
        return total;
    }
}
