package com.alkimin.repository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

public class CSVExtractor implements Extratator {

    @Override
    public List<String> extrairDados(String path, String name) throws IOException {
        Path finalPath = Paths.get(path + name.toLowerCase());
        List<String> linhas = Files.readAllLines(finalPath);
        if (linhas.get(0).isBlank()) {
            throw new RuntimeException("Arquivo informado não pode ser vazio!");
        }
        return linhas;
    }
}
