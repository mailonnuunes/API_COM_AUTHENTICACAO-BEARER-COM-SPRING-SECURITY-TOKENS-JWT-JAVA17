package com.example.ApiClientes.dtos;


import com.example.ApiClientes.enums.TipoDeCPF;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.NumberFormat;

public record DadosCadastroCliente(
        @NotBlank(message = "o sobrenome é obrigatorio")
       String nome,
       @NotBlank(message = "o sobrenome é obrigatorio")
       String sobrenome,
       @NotNull(message = "a idade é obrigatoria")
       @Min(0)
       @Max(130)
       int idade,
       @NumberFormat
       String nomedamae,

        @NotNull(message = "o tipo de cpf é obrigatório")
        TipoDeCPF tipodecpf
) {
}
