package com.alkimin.service;

import com.alkimin.model.TransacaoBancaria;

import java.math.BigDecimal;
import java.time.Month;
import java.util.List;

public class SaldoService {
    public static BigDecimal processarSaldoTotal(List<TransacaoBancaria> transacoes) {
        BigDecimal total = BigDecimal.ZERO;
        List<BigDecimal> valores = transacoes.stream()
                .map(TransacaoBancaria::getValor)
                .toList();

        for (BigDecimal v : valores) {
            total = total.add(v);
        }
        return total;
    }

    public static BigDecimal processarSaldoMensal(List<TransacaoBancaria> transacoes, Month mes) {
        BigDecimal total = BigDecimal.ZERO;
        List<BigDecimal> valores = transacoes.stream()
                .filter(t -> t.getData().getMonth().equals(mes))
                .map(TransacaoBancaria::getValor)
                .toList();

        for (BigDecimal v : valores) {
            total = total.add(v);
        }
        return total;
    }

    public static BigDecimal processarSaldoPorCategoria(List<TransacaoBancaria> transacoes, String categoria) {
        BigDecimal saldoCategoria = BigDecimal.ZERO;
        List<BigDecimal> saldoCategoriaFiltrado = transacoes.stream().filter(t -> t.getNome().equals(categoria))
                .map(TransacaoBancaria::getValor).toList();

        for (BigDecimal saldo: saldoCategoriaFiltrado) {
            saldoCategoria = saldoCategoria.add(saldo);
        }
        return saldoCategoria;
    }
}
