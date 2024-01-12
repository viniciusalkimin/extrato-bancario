package com.alkimin.repository;

import com.alkimin.model.TransacaoBancaria;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class JSONExtractor implements Extratator{
    @Override
    public List<String> extrairDados(String path, String nome) throws IOException {
        final Path finalPath = Paths.get(path + nome);


        return null;
    }
}
