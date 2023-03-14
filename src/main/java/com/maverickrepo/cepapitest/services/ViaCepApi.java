package com.maverickrepo.cepapitest.services;


import com.maverickrepo.cepapitest.client.model.Endereco;
import com.maverickrepo.cepapitest.client.model.ViaCepResponse;
import com.maverickrepo.cepapitest.exceptions.CepNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ViaCepApi {
    private static final String VIA_CEP_URL = "https://viacep.com.br/ws/%s/json/";

    private final RestTemplate restTemplate;
    @Autowired
    CalculadoraFrete calculadoraFrete;

    public ViaCepApi(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Endereco buscarEnderecoPorCep(String cep) {
        String url = String.format(VIA_CEP_URL, cep);
        ViaCepResponse response = restTemplate.getForObject(url, ViaCepResponse.class);
        double frete = calculadoraFrete.calcularFrete(response.getUf());
        if (response != null && !response.isErro()) {
            return new Endereco(
                    response.getCep(),
                    response.getLogradouro(),
                    response.getComplemento(),
                    response.getBairro(),
                    response.getLocalidade(),
                    response.getUf(),
                    frete
            );
        } else {
            throw new CepNotFoundException(cep);
        }
    }
}

