package com.ilioadriano.Validators;

import com.ilioadriano.Domain.Policial;
import com.ilioadriano.Domain.Presidiario;
import com.ilioadriano.Abstract.Tripulante;

import java.util.List;
import java.util.stream.Collectors;

public class PresidiarioSemPolicialValidator implements Validator {
    @Override
    public void validate(List<Tripulante> tripulatensNoLocal) {
        List<String> distinctTipoTripulantes = tripulatensNoLocal
                .stream()
                .map(tripulante -> tripulante.getClass().getName())
                .distinct()
                .collect(Collectors.toList());

        boolean hasPresidiario = distinctTipoTripulantes.contains(Presidiario.class.getName());
        boolean hasPolicial = distinctTipoTripulantes.contains(Policial.class.getName());

        boolean hasAnother = distinctTipoTripulantes
                .stream()
                .anyMatch(tipoTripulante -> !tipoTripulante.equals(Presidiario.class.getName()) && !tipoTripulante.equals(Policial.class.getName()));

        if (hasPresidiario && !hasPolicial && hasAnother) {
            throw new RuntimeException("Presidiário ficou sozinho com outros tripulantes sem o policial");
        }
    }
}
