package com.ilioadriano.Validators;

import com.ilioadriano.Domain.Comissaria;
import com.ilioadriano.Domain.Piloto;
import com.ilioadriano.Abstract.Tripulante;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ComissariaSozinhaComPilotoValidator implements Validator {
    @Override
    public void validate(List<Tripulante> tripulatensNoLocal) {
        List<String> tipoProcurados = Arrays.asList(Comissaria.class.getName(), Piloto.class.getName());
        List<String> distinctTipoTripulantes = tripulatensNoLocal
                .stream()
                .map(tripulante -> tripulante.getClass().getName())
                .distinct()
                .collect(Collectors.toList());

        if (distinctTipoTripulantes.size() == 2 && distinctTipoTripulantes.containsAll(tipoProcurados)) {
            throw new RuntimeException("Ao menos 1 comissária ficou sozinha com o piloto");
        }
    }
}
