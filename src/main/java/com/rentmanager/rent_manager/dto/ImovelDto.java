package com.rentmanager.rent_manager.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rentmanager.rent_manager.entity.Imovel;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ImovelDto {

    @JsonIgnore
    private final String mensagemErroCampoObrigatorio = "Campo obrigatório não prenchido";

    @JsonIgnore
    private final String mensagemErroTamanhoLimite = "Tamanho limite do campo excedido";

    private Long id;

    @Size(max = 100, message = mensagemErroTamanhoLimite)
    private String nome;

    @NotBlank(message = mensagemErroCampoObrigatorio)
    @Size(max = 10, message = mensagemErroTamanhoLimite)
    private String cep;

    @NotBlank(message = mensagemErroCampoObrigatorio)
    @Size(max = 100, message = mensagemErroTamanhoLimite)
    private String estado;

    @NotBlank(message = mensagemErroCampoObrigatorio)
    @Size(max = 100, message = mensagemErroTamanhoLimite)
    private String cidade;

    @Size(max = 100, message = mensagemErroTamanhoLimite)
    private String bairro;

    @NotBlank(message = mensagemErroCampoObrigatorio)
    @Size(max = 100, message = mensagemErroTamanhoLimite)
    private String logradouro;

    @Size(max = 100, message = mensagemErroTamanhoLimite)
    private String numero;

    @Size(max = 100, message = mensagemErroTamanhoLimite)
    private String complemento;

    @Size(max = 100, message = mensagemErroTamanhoLimite)
    private String senhaWifi;

    @Size(max = 100, message = mensagemErroTamanhoLimite)
    private String senhaPorta;

    public Imovel toEntity() {
        return new Imovel(nome, cep, estado, cidade, bairro, logradouro, numero, complemento, senhaWifi, senhaPorta);
    }

    public static ImovelDto fromEntity(Imovel imovel) {
        ImovelDto dto = new ImovelDto();
        BeanUtils.copyProperties(imovel, dto);
        return dto;
    }

}
