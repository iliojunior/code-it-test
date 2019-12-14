package com.ilioadriano.Domain;

import com.ilioadriano.Abstract.HabilitadoParaDirigir;
import com.ilioadriano.Abstract.Tripulante;

import java.util.StringJoiner;

public class Viagem {

    private HabilitadoParaDirigir piloto;

    private Tripulante passageiro;

    private Local localPartida;

    private Local localChegada;

    public Viagem(HabilitadoParaDirigir piloto, Tripulante passageiro, Local localPartida, Local localChegada) {
        validaParametros(piloto, localPartida, localChegada);
        this.piloto = piloto;
        this.passageiro = passageiro;
        this.localPartida = localPartida;
        this.localChegada = localChegada;
    }

    private void validaParametros(HabilitadoParaDirigir piloto, Local localPartida, Local localChegada) {
        if (piloto == null) {
            throw new RuntimeException("É necessário informar um Piloto para a viagem");
        }
        if (localPartida == null) {
            throw new RuntimeException("É necessário informar o local de partida para a viagem");
        }
        if (localChegada == null) {
            throw new RuntimeException("É necessário informar o local de chegada para a viagem");
        }
    }

    public void viajar() {
        localPartida.saidaTripulante(this.piloto);
        localChegada.entradaTripulante(this.piloto);

        if (this.passageiro != null) {
            localPartida.saidaTripulante(this.passageiro);
            localChegada.entradaTripulante(this.passageiro);
        }

        localPartida.executeValidators();

        System.out.printf("%s -> %s \n", localPartida.getClass().getName(), localPartida.getTripulantesNoLocal());
        System.out.printf("%s -> %s \n", localChegada.getClass().getName(), localChegada.getTripulantesNoLocal());
        System.out.println("--------------------------");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Viagem viagem = (Viagem) o;

        if (!piloto.equals(viagem.piloto)) return false;
        if (!passageiro.equals(viagem.passageiro)) return false;
        if (!localPartida.equals(viagem.localPartida)) return false;
        return localChegada.equals(viagem.localChegada);
    }

    @Override
    public int hashCode() {
        int result = piloto.hashCode();
        result = 31 * result + passageiro.hashCode();
        result = 31 * result + localPartida.hashCode();
        result = 31 * result + localChegada.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Viagem.class.getSimpleName() + "[", "]")
                .add("piloto=" + piloto)
                .add("passageiro=" + passageiro)
                .add("localPartida=" + localPartida)
                .add("localChegada=" + localChegada)
                .toString();
    }

    public static class ViagemBuilder {

        private HabilitadoParaDirigir piloto;

        private Tripulante passageiro;

        private Local localPartida;

        private Local localChegada;

        public ViagemBuilder setPiloto(HabilitadoParaDirigir piloto) {
            this.piloto = piloto;
            return this;
        }

        public ViagemBuilder setPassageiro(Tripulante passageiro) {
            this.passageiro = passageiro;
            return this;
        }

        public ViagemBuilder setLocalPartida(Local localPartida) {
            this.localPartida = localPartida;
            return this;
        }

        public ViagemBuilder setLocalChegada(Local localChegada) {
            this.localChegada = localChegada;
            return this;
        }

        public Viagem build() {
            return new Viagem(this.piloto, this.passageiro, this.localPartida, this.localChegada);
        }
    }
}
