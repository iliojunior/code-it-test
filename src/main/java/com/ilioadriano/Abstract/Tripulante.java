package com.ilioadriano.Abstract;

import java.util.StringJoiner;

public abstract class Tripulante {
    private String nome;

    public Tripulante(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tripulante that = (Tripulante) o;

        return getNome().equals(that.getNome());
    }

    @Override
    public int hashCode() {
        return getNome().hashCode();
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", this.getClass().getName() + "[", "]")
                .add("nome='" + nome + "'")
                .toString();
    }
}
