package com.ilioadriano.Validators;

import com.ilioadriano.Domain.ChefeServico;
import com.ilioadriano.Domain.Oficial;
import com.ilioadriano.Abstract.Tripulante;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class OficialSozinhoComChefeServicoValidator implements Validator {
    @Override
    public void validate(List<Tripulante> tripulatensNoLocal) {
        List<String> tiposProcurados = Arrays.asList(Oficial.class.getName(), ChefeServico.class.getName());
        List<String> distinctTipoTripulantes = tripulatensNoLocal
                .stream()
                .map(tripulante -> tripulante.getClass().getName())
                .distinct()
                .collect(Collectors.toList());

        if (distinctTipoTripulantes.size() == 2 && distinctTipoTripulantes.containsAll(tiposProcurados)) {
            throw new RuntimeException("Ao menos um oficial ficou sozinho com o chefe de serviço");
        }
    }
}
