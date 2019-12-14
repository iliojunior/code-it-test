package com.ilioadriano.Domain;

import com.ilioadriano.Abstract.Tripulante;
import com.ilioadriano.Validators.ComissariaSozinhaComPilotoValidator;
import com.ilioadriano.Validators.OficialSozinhoComChefeServicoValidator;
import com.ilioadriano.Validators.PresidiarioSemPolicialValidator;
import com.ilioadriano.Validators.Validator;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public abstract class Local {
    private List<Tripulante> tripulantesNoLocal;

    private List<Validator> validators = new LinkedList<>();

    public Local(Tripulante... tripulantesNoLocal) {
        this.tripulantesNoLocal = new LinkedList<>(Arrays.asList(tripulantesNoLocal));
        this.registerValidators();
    }

    public Local() {
        this.tripulantesNoLocal = new LinkedList<>();
        this.registerValidators();
    }

    private void registerValidators() {
        validators.add(new PresidiarioSemPolicialValidator());
        validators.add(new OficialSozinhoComChefeServicoValidator());
        validators.add(new ComissariaSozinhaComPilotoValidator());
    }

    public void saidaTripulante(Tripulante tripulante) {
        tripulantesNoLocal.remove(tripulante);
    }

    public void entradaTripulante(Tripulante tripulante) {
        tripulantesNoLocal.add(tripulante);
    }

    public List<Tripulante> getTripulantesNoLocal() {
        return tripulantesNoLocal;
    }

    public void executeValidators() {
        validators.forEach(validator -> validator.validate(this.getTripulantesNoLocal()));
    }
}
