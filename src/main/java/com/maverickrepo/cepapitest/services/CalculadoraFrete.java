package com.maverickrepo.cepapitest.services;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CalculadoraFrete {
    private final Map<String, Double> tabelaFretes = new HashMap<>();

    public CalculadoraFrete() {
        tabelaFretes.put("SP", 7.85);
        tabelaFretes.put("RJ", 7.85);
        tabelaFretes.put("ES", 7.85);
        tabelaFretes.put("MG", 7.85);
        tabelaFretes.put("DF", 12.50);
        tabelaFretes.put("GO", 12.50);
        tabelaFretes.put("MT", 12.50);
        tabelaFretes.put("MS", 12.50);
        tabelaFretes.put("AL", 15.98);
        tabelaFretes.put("BA", 15.98);
        tabelaFretes.put("CE", 15.98);
        tabelaFretes.put("MA", 15.98);
        tabelaFretes.put("PB", 15.98);
        tabelaFretes.put("PE", 15.98);
        tabelaFretes.put("PI", 15.98);
        tabelaFretes.put("RN", 15.98);
        tabelaFretes.put("SE", 15.98);
        tabelaFretes.put("PR", 17.30);
        tabelaFretes.put("RS", 17.30);
        tabelaFretes.put("SC", 17.30);
        tabelaFretes.put("AC", 20.83);
        tabelaFretes.put("AP", 20.83);
        tabelaFretes.put("AM", 20.83);
        tabelaFretes.put("PA", 20.83);
        tabelaFretes.put("RO", 20.83);
        tabelaFretes.put("RR", 20.83);
        tabelaFretes.put("TO", 20.83);
    }

    public double calcularFrete(String estado) {
        Double frete = tabelaFretes.get(estado.toUpperCase());
        if (frete == null) {
            throw new IllegalStateException("Não foi possível calcular o frete para o estado informado");
        }
        return frete;
    }
}
