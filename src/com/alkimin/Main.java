package com.alkimin;

import com.alkimin.repository.CSVExtractor;
import com.alkimin.usecase.ExtratoBancarioAnalyzer;

import java.io.IOException;

public class Main {
    public static final String PATH = "src/resource/";
    public static final String NOMEARQUIVO = "extrato.csv";

    public static void main(String[] args) throws IOException {
        ExtratoBancarioAnalyzer extratoBancarioAnalyzer = new ExtratoBancarioAnalyzer();

        extratoBancarioAnalyzer.analyse(PATH, NOMEARQUIVO, new CSVExtractor());
    }
}

