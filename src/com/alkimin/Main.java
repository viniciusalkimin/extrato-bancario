package com.alkimin;

import com.alkimin.model.TransacaoBancaria;
import com.alkimin.repository.CSVExtractor;
import com.alkimin.repository.Extratator;
import com.alkimin.service.SaldoService;
import com.alkimin.service.TransacaoService;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.Month;
import java.util.List;

public class Main {
    public static final String PATH = "src/resource/";
    public static final String NOMEARQUIVO = "extrato.csv";

    public static void main(String[] args) throws IOException {
        TransacaoService transacaoService = new TransacaoService();
        Extratator extratator = new CSVExtractor();

        final List<String> linhas = extratator.extrairDados(PATH, NOMEARQUIVO);
        final List<TransacaoBancaria> transacoes = transacaoService.gerarTransacoes(linhas);

        final BigDecimal saldoTotal = SaldoService.processarSaldoTotal(transacoes);
        final BigDecimal saldoMensal = SaldoService.processarSaldoMensal(transacoes, Month.JANUARY);

        System.out.printf(" O saldo total da conta: R$%.2f\n", saldoTotal);
        System.out.printf("O saldo da mês de Janeiro: R$%.2f", saldoMensal);
    }
}

