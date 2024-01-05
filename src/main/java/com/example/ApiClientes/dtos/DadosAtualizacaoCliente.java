package com.example.ApiClientes.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoCliente(

        @NotNull
        Long id,
        @NotBlank(message = "o nome é obrigatorio")
        String nome,
        @NotBlank(message = "o sobrenome é obrigatorio")
        String sobrenome,
        @NotNull(message = "a idade é obrigatoria")
        String idade
) {

}
