package com.example.ApiClientes.dtos;

import com.example.ApiClientes.domains.Cliente;

public record DadosListagemCliente(Long id, String nome, String sobrenome, String idade) {

    public DadosListagemCliente(Cliente cliente){
        this(cliente.getId(), cliente.getNome(), cliente.getSobrenome(), String.valueOf(cliente.getIdade()));
    }


}
