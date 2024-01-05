package com.example.ApiClientes.controllers;

import com.example.ApiClientes.domains.Cliente;
import com.example.ApiClientes.dtos.DadosAtualizacaoCliente;
import com.example.ApiClientes.dtos.DadosCadastroCliente;
import com.example.ApiClientes.dtos.DadosDetalhamentoCliente;
import com.example.ApiClientes.dtos.DadosListagemCliente;
import com.example.ApiClientes.interfaces.IClienteRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("clientes")
public class ClienteController {

    @Autowired
    private IClienteRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity Cadastrar(@RequestBody @Valid DadosCadastroCliente dados, UriComponentsBuilder uriBuilder){
        var cliente = new Cliente(dados);
        repository.save(cliente);

        var uri = uriBuilder.path("/clientes/{id}").buildAndExpand(cliente.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoCliente(cliente));
    }
    @GetMapping
    public ResponseEntity<Page<DadosListagemCliente>> MostrarTodosClientes(@PageableDefault(size = 2, sort = {"nome","idade"})Pageable paginacao){
        var page = repository.findAllByAtivoTrue(paginacao).map(DadosListagemCliente::new);
        return  ResponseEntity.ok(page);

    }
    @GetMapping("/{id}")
    public ResponseEntity MostrarPorId(@PathVariable Long id){
        var cliente = repository.getReferenceById(id);

        return ResponseEntity.ok(new DadosDetalhamentoCliente(cliente));
    }
    @PutMapping
    @Transactional
    public ResponseEntity Atualizar(@RequestBody @Valid DadosAtualizacaoCliente dados){
        var cliente = repository.getReferenceById(dados.id());
        cliente.atualizarinformacoes(dados);
        return ResponseEntity.ok(new DadosDetalhamentoCliente(cliente));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity Deletar(@PathVariable Long id){
        var cliente = repository.getReferenceById(id);
        cliente.excluir();

        return ResponseEntity.noContent().build();
    }
}
