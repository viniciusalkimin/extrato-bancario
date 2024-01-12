package com.alkimin.service;

import com.alkimin.model.FilterModel;
import com.alkimin.model.TransacaoBancaria;

import java.math.BigDecimal;
import java.util.List;

@FunctionalInterface
public interface SaldoFilter {

    BigDecimal filtrar(List<TransacaoBancaria> transacoes, FilterModel filter);
}
