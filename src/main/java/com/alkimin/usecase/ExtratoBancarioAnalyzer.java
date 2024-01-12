package com.alkimin.usecase;

import com.alkimin.model.FilterModel;
import com.alkimin.model.TransacaoBancaria;
import com.alkimin.repository.Extratator;
import com.alkimin.service.SaldoFilter;
import com.alkimin.service.SaldoService;
import com.alkimin.service.TransacaoService;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.Month;
import java.util.List;

public class ExtratoBancarioAnalyzer {

    TransacaoService transacaoService = new TransacaoService();

    public void analyse(String path, String nomeArquivo, Extratator extratator, SaldoFilter saldoFilter, FilterModel filtro) throws IOException {
        final List<String> linhas = extratator.extrairDados(path, nomeArquivo);
        final List<TransacaoBancaria> transacoes = transacaoService.gerarTransacoes(linhas);

        final BigDecimal saldoTotal = saldoFilter.filtrar(transacoes, filtro);

        System.out.printf(" O saldo total da conta: R$%.2f\n", saldoTotal);


    }
}
