package com.alkimin.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public class TransacaoBancaria {
    private LocalDate data;
    private String nome;
    private BigDecimal valor;

    public TransacaoBancaria(String data, String nome, String valor) {
        this.data = LocalDate.parse(data);
        this.nome = nome;
        this.valor = new BigDecimal(valor);
    }

    public LocalDate getData() {
        return data;
    }

    public String getNome() {
        return nome;
    }

    public BigDecimal getValor() {
        return valor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransacaoBancaria that = (TransacaoBancaria) o;
        return Objects.equals(data, that.data) && Objects.equals(nome, that.nome) && Objects.equals(valor, that.valor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data, nome, valor);
    }

    @Override
    public String toString() {
        return "TransacaoBancaria{" +
                "data=" + data +
                ", nome='" + nome + '\'' +
                ", valor=" + valor +
                '}';
    }
}