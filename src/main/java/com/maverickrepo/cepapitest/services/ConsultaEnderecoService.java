package com.maverickrepo.cepapitest.services;


import com.maverickrepo.cepapitest.client.model.ConsultaEnderecoRequest;
import com.maverickrepo.cepapitest.client.model.Endereco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConsultaEnderecoService {

    @Autowired
    ViaCepApi viaCepApi;

    public Endereco consultarEndereco(ConsultaEnderecoRequest request) {
        Endereco endereco = viaCepApi.buscarEnderecoPorCep(request.getCep());
        return endereco;
    }
}
