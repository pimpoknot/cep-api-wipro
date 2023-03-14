package com.maverickrepo.cepapitest.exceptions;

public class CepNotFoundException extends RuntimeException {
    private final String cep;

    public CepNotFoundException(String cep) {
        super("CEP " + cep + " não encontrado");
        this.cep = cep;
    }

    public String getCep() {
        return cep;
    }
}
