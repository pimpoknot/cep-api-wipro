package com.maverickrepo.cepapitest.client.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {
    private String cep;
    private String rua;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;
    private double frete;

}
