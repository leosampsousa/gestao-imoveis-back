package com.rentmanager.rent_manager.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
@Table(name = "reserva")
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "imovel_id", nullable = false)
    private Imovel imovel;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hospede_id", nullable = false)
    private Hospede hospede;

    @Column(name = "data_inicio", nullable = false)
    private LocalDate dataInicio;

    @Column(name = "data_fim", nullable = false)
    private LocalDate dataFim;

    @Column(name = "preco_total", nullable = false, precision = 10, scale = 2)
    private BigDecimal precoTotal;

    public Reserva(Imovel imovel, Hospede hospede, LocalDate dataInicio, LocalDate dataFim, BigDecimal precoTotal) {
        this.imovel = imovel;
        this.hospede = hospede;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.precoTotal = precoTotal;
    }
}
