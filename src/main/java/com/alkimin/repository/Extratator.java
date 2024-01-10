package com.alkimin.repository;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface Extratator {

    List<String> extrairDados(String path, String nome) throws IOException;
}
