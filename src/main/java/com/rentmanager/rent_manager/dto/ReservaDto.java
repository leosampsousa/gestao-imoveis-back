package com.rentmanager.rent_manager.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class ReservaDto {
    private Long id;
    private Long imovelId;
    private String imovelNome; // Opcional, util para retorno
    private Long hospedeId;
    private String hospedeNome; // Opcional, util para retorno
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private BigDecimal precoTotal;
}
