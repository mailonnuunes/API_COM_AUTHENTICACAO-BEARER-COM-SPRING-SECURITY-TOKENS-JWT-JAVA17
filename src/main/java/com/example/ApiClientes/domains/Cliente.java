package com.example.ApiClientes.domains;


import com.example.ApiClientes.dtos.DadosAtualizacaoCliente;
import com.example.ApiClientes.dtos.DadosCadastroCliente;
import com.example.ApiClientes.enums.TipoDeCPF;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name="Cliente")
@Table(name = "Clientes")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Cliente {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String sobrenome;

    private int idade;

    private String nomedamae;

    @Enumerated(EnumType.STRING)
    private TipoDeCPF tipodecpf;

    private Boolean ativo;

    public Cliente(DadosCadastroCliente dados) {
        this.nome = dados.nome();
        this.sobrenome = dados.sobrenome();
        this.idade = dados.idade();
        this.nomedamae = dados.nomedamae();
        this.tipodecpf = dados.tipodecpf();
        this.ativo = true;

    }

    public void atualizarinformacoes(DadosAtualizacaoCliente dados) {

        if(dados.nome() != null){
            this.nome = dados.nome();
        }
        if(dados.sobrenome() != null){
            this.sobrenome = dados.sobrenome();
        }
        if(dados.idade() != null){
            this.idade = Integer.parseInt(dados.idade());
        }
    }

    public void excluir() {
        this.ativo = false;
    }
}
