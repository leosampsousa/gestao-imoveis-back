package com.rentmanager.rent_manager.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity(name = "hospede")
@NoArgsConstructor
public class Hospede {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", length = 100, nullable = false)
    private String nome;

    @Column(name = "sobrenome", length = 100, nullable = false)
    private String sobrenome;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_documento", length = 10, nullable = false)
    private TipoDocumentoEnum tipoDocumento;

    @Column(name = "documento", length = 100, nullable = false, unique = true)
    private String documento;

    @Column(name = "email", length = 100, nullable = false)
    private String email;

    @Column(name = "telefone", length = 100, nullable = false)
    private String telefone;

    @Column(name = "observacoes", length = 1000)
    private String observacoes;

    public Hospede(String nome, String sobrenome, TipoDocumentoEnum tipoDocumento, String documento, String email, String telefone, String observacoes) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.tipoDocumento = tipoDocumento;
        this.documento = documento;
        this.email = email;
        this.telefone = telefone;
        this.observacoes = observacoes;
    }
}
