package com.maverickrepo.cepapitest.controllers;

import com.maverickrepo.cepapitest.client.model.ConsultaEnderecoRequest;
import com.maverickrepo.cepapitest.client.model.Endereco;
import com.maverickrepo.cepapitest.services.ConsultaEnderecoService;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ConsultaEnderecoControllerTest {

    @Mock
    private ConsultaEnderecoService consultaEnderecoService;

    @InjectMocks
    private ConsultaEnderecoController consultaEnderecoController;

    @Test
    public void consultaEnderecoTest() {
        ConsultaEnderecoRequest request = new ConsultaEnderecoRequest();
        Endereco endereco = new Endereco();
        endereco.setCep("12345678");
        endereco.setRua("Rua Teste");
        endereco.setComplemento("Complemento Teste");
        endereco.setBairro("Bairro Teste");
        endereco.setCidade("Cidade Teste");
        endereco.setEstado("Estado Teste");
        endereco.setFrete(10.0);

        when(consultaEnderecoService.consultarEndereco(request)).thenReturn(endereco);

        ResponseEntity<Endereco> responseEntity = consultaEnderecoController.consultaEndereco(request);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(endereco, responseEntity.getBody());
    }
}

