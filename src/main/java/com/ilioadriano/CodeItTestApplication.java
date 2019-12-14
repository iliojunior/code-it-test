package com.ilioadriano;

import com.ilioadriano.Domain.*;

public class CodeItTestApplication {
    public static void main(String[] args) {
        Piloto piloto = new Piloto("Piloto");
        ChefeServico chefeServico = new ChefeServico("Chefe de Serviço");

        Oficial oficial1 = new Oficial("Oficial 1");
        Oficial oficial2 = new Oficial("Oficial 2");

        Comissaria comissaria1 = new Comissaria("Comissaria 1");
        Comissaria comissaria2 = new Comissaria("Comissaria 2");

        Policial policial = new Policial("Policial");
        Presidiario presidiario = new Presidiario("Presidiário");

        Terminal terminal = new Terminal(piloto, chefeServico, oficial1, oficial2, comissaria1, comissaria2, policial, presidiario);
        Aviao aviao = new Aviao();

        System.out.println("Inicio");
        System.out.printf("%s -> %s \n", terminal.getClass().getName(), terminal.getTripulantesNoLocal());
        System.out.printf("%s -> %s \n", aviao.getClass().getName(), aviao.getTripulantesNoLocal());
        System.out.println("--------------------------");

        new Viagem.ViagemBuilder()
                .setPiloto(policial)
                .setPassageiro(presidiario)
                .setLocalPartida(terminal)
                .setLocalChegada(aviao)
                .build()
                .viajar();

        new Viagem.ViagemBuilder()
                .setPiloto(policial)
                .setLocalPartida(aviao)
                .setLocalChegada(terminal)
                .build()
                .viajar();

        new Viagem.ViagemBuilder()
                .setPiloto(policial)
                .setPassageiro(piloto)
                .setLocalPartida(terminal)
                .setLocalChegada(aviao)
                .build()
                .viajar();

        new Viagem.ViagemBuilder()
                .setPiloto(piloto)
                .setLocalPartida(aviao)
                .setLocalChegada(terminal)
                .build()
                .viajar();

        new Viagem.ViagemBuilder()
                .setPiloto(piloto)
                .setPassageiro(comissaria1)
                .setLocalPartida(terminal)
                .setLocalChegada(aviao)
                .build()
                .viajar();

        new Viagem.ViagemBuilder()
                .setPiloto(piloto)
                .setLocalPartida(aviao)
                .setLocalChegada(terminal)
                .build()
                .viajar();

        new Viagem.ViagemBuilder()
                .setPiloto(chefeServico)
                .setPassageiro(comissaria2)
                .setLocalPartida(terminal)
                .setLocalChegada(aviao)
                .build()
                .viajar();

        new Viagem.ViagemBuilder()
                .setPiloto(chefeServico)
                .setLocalPartida(aviao)
                .setLocalChegada(terminal)
                .build()
                .viajar();

        new Viagem.ViagemBuilder()
                .setPiloto(chefeServico)
                .setPassageiro(oficial1)
                .setLocalPartida(terminal)
                .setLocalChegada(aviao)
                .build()
                .viajar();

        new Viagem.ViagemBuilder()
                .setPiloto(chefeServico)
                .setLocalPartida(aviao)
                .setLocalChegada(terminal)
                .build()
                .viajar();

        new Viagem.ViagemBuilder()
                .setPiloto(chefeServico)
                .setPassageiro(oficial2)
                .setLocalPartida(terminal)
                .setLocalChegada(aviao)
                .build()
                .viajar();

        new Viagem.ViagemBuilder()
                .setPiloto(chefeServico)
                .setLocalPartida(aviao)
                .setLocalChegada(terminal)
                .build()
                .viajar();

        new Viagem.ViagemBuilder()
                .setPiloto(chefeServico)
                .setPassageiro(piloto)
                .setLocalPartida(terminal)
                .setLocalChegada(aviao)
                .build()
                .viajar();
    }
}
