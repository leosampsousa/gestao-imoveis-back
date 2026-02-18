package com.rentmanager.rent_manager.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity(name = "imovel")
@NoArgsConstructor
public class Imovel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(nullable = false, length = 10)
    private String cep;

    @Column(nullable = false, length = 100)
    private String estado;

    @Column(nullable = false, length = 100)
    private String cidade;

    @Column(length = 100)
    private String bairro;

    @Column(nullable = false, length = 100)
    private String logradouro;

    @Column(length = 100)
    private String numero;

    @Column(length = 100)
    private String complemento;

    @Column(name = "senha_wifi", length = 100)
    private String senhaWifi;

    @Column(name="senha_porta", length = 100)
    private String senhaPorta;


    public Imovel(String nome, String cep, String estado, String cidade, String bairro, String logradouro, String numero, String complemento, String senhaWifi, String senhaPorta) {
        this.nome = nome;
        this.cep = cep;
        this.estado = estado;
        this.cidade = cidade;
        this.bairro = bairro;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.senhaWifi = senhaWifi;
        this.senhaPorta = senhaPorta;
    }
}
