package com.example.ApiClientes.dtos;

import com.example.ApiClientes.domains.Cliente;

public record DadosDetalhamentoCliente(Long id, String nome, String sobrenome, int idade, String nomedamae ) {

    public DadosDetalhamentoCliente(Cliente cliente) {
        this(cliente.getId(), cliente.getNome(), cliente.getSobrenome(), cliente.getIdade(), cliente.getNomedamae());
    }
}
