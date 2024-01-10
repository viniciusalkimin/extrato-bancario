package com.alkimin.usecase;

import com.alkimin.model.TransacaoBancaria;
import com.alkimin.repository.Extratator;
import com.alkimin.service.SaldoService;
import com.alkimin.service.TransacaoService;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.Month;
import java.util.List;

public class ExtratoBancarioAnalyzer {

    TransacaoService transacaoService = new TransacaoService();

    public void analyse(String path, String nomeArquivo, Extratator extratator) throws IOException {
        final List<String> linhas = extratator.extrairDados(path, nomeArquivo);
        final List<TransacaoBancaria> transacoes = transacaoService.gerarTransacoes(linhas);

        final BigDecimal saldoTotal = SaldoService.processarSaldoTotal(transacoes);
        final BigDecimal saldoMensal = SaldoService.processarSaldoMensal(transacoes, Month.JANUARY);
        final BigDecimal saldoCategoia = SaldoService.processarSaldoPorCategoria(transacoes, "Investimento");

        System.out.printf(" O saldo total da conta: R$%.2f\n", saldoTotal);
        System.out.printf("O saldo da mês de Janeiro: R$%.2f\n", saldoMensal);
        System.out.printf("O saldo da categoria : R$%.2f\n", saldoCategoia);

    }
}
