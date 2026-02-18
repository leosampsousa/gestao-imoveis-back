package com.rentmanager.rent_manager.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rentmanager.rent_manager.entity.Hospede;
import com.rentmanager.rent_manager.entity.TipoDocumentoEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HospedeDto {

    @JsonIgnore
    private final String mensagemErroCampoObrigatorio = "Campo obrigatório não prenchido";

    @JsonIgnore
    private final String mensagemErroTamanhoLimite = "Tamanho limite do campo excedido";

    private Long id;

    @NotBlank(message = mensagemErroCampoObrigatorio)
    @Size(max = 100, message = mensagemErroTamanhoLimite)
    private String nome;

    @NotBlank(message = mensagemErroCampoObrigatorio)
    @Size(max = 100, message = mensagemErroTamanhoLimite)
    private String sobrenome;

    @NotNull(message = mensagemErroCampoObrigatorio)
    private TipoDocumentoEnum tipoDocumento;

    @NotBlank(message = mensagemErroCampoObrigatorio)
    @Size(max = 100, message = mensagemErroTamanhoLimite)
    private String documento;

    @NotBlank(message = mensagemErroCampoObrigatorio)
    @Size(max = 100, message = mensagemErroTamanhoLimite)
    private String email;

    @NotBlank(message = mensagemErroCampoObrigatorio)
    @Size(max = 100, message = mensagemErroTamanhoLimite)
    private String telefone;

    @Size(max = 1000, message = mensagemErroTamanhoLimite)
    private String observacoes;

    public Hospede toEntity() {
        return new Hospede(
                nome,
                sobrenome,
                tipoDocumento,
                documento,
                email,
                telefone,
                observacoes
        );
    }

    public static HospedeDto fromEntity(Hospede hospede) {
        HospedeDto dto = new HospedeDto();
        BeanUtils.copyProperties(hospede, dto);
        return dto;
    }
}
