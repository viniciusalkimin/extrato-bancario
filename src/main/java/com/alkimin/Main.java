package com.alkimin;

import com.alkimin.model.FilterModel;
import com.alkimin.repository.CSVExtractor;
import com.alkimin.service.SaldoCategoriaFilter;
import com.alkimin.service.SaldoMensalFilter;
import com.alkimin.service.SaldoMesValorFilter;
import com.alkimin.service.SaldoTotalFilter;
import com.alkimin.usecase.ExtratoBancarioAnalyzer;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.Month;

public class Main {
    public static final String PATH = "src/main/resource/";
    public static final String NOMEARQUIVO = "extrato.csv";

    public static void main(String[] args) throws IOException {
        ExtratoBancarioAnalyzer extratoBancarioAnalyzer = new ExtratoBancarioAnalyzer();

        var modelFilter = FilterModel.builder()
                .mes(Month.JANUARY)
                .categoria("Salario")
                .valor(new BigDecimal("0"))
                .build();

        extratoBancarioAnalyzer
                .analyse(PATH, NOMEARQUIVO, new CSVExtractor(), new SaldoMesValorFilter(), modelFilter);
    }
}

