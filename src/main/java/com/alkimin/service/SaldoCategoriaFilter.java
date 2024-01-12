package com.alkimin.service;

import com.alkimin.model.FilterModel;
import com.alkimin.model.TransacaoBancaria;

import java.math.BigDecimal;
import java.util.List;

public class SaldoCategoriaFilter implements SaldoFilter{
    @Override
    public BigDecimal filtrar(List<TransacaoBancaria> transacoes, FilterModel filter) {
        BigDecimal saldoCategoria = BigDecimal.ZERO;
        List<BigDecimal> saldoCategoriaFiltrado = transacoes.stream().filter(t -> t.getNome().equals(filter.getCategoria()))
                .map(TransacaoBancaria::getValor).toList();

        for (BigDecimal saldo: saldoCategoriaFiltrado) {
            saldoCategoria = saldoCategoria.add(saldo);
        }
        return saldoCategoria;
    }
}
