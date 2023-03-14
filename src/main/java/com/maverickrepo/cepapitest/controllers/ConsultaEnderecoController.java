package com.maverickrepo.cepapitest.controllers;

import com.maverickrepo.cepapitest.client.model.ConsultaEnderecoRequest;
import com.maverickrepo.cepapitest.client.model.Endereco;
import com.maverickrepo.cepapitest.exceptions.CepNotFoundException;
import com.maverickrepo.cepapitest.services.ConsultaEnderecoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
@Api(value = "API de Exemplo")
public class ConsultaEnderecoController {

    @Autowired
    ConsultaEnderecoService consultaEnderecoService;

    @ApiOperation(value = "passar um cep e retornar o endereço com o calculo do frete de cada região")
    @PostMapping("/v1/consulta-endereco")
    public ResponseEntity<Endereco> consultaEndereco(@RequestBody  ConsultaEnderecoRequest request ) {
        Endereco response = consultaEnderecoService.consultarEndereco(request);
        return ResponseEntity.ok(response);
    }

    @ExceptionHandler(CepNotFoundException.class)
    public ResponseEntity<String> cepNotFoundHandler(CepNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("CEP não encontrado");
    }
}
