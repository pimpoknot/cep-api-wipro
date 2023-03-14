package com.maverickrepo.cepapitest.client.model;


public class ConsultaEnderecoRequest {
    private String cep;

    public ConsultaEnderecoRequest() {
    }


    public ConsultaEnderecoRequest(String cep) {
        this.cep = cep;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
}
