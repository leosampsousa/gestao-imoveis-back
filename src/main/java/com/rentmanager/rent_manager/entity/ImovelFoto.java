package com.rentmanager.rent_manager.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity(name = "imovel_foto")
@NoArgsConstructor
@AllArgsConstructor
public class ImovelFoto {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Imovel imovel;

    @Lob
    @Basic(fetch = FetchType.LAZY)
    private byte[] dados;

    private String contentType;

    private Integer ordem;

    public ImovelFoto(Imovel imovel, byte[] dados, String contentType, Integer ordem) {
        this.imovel = imovel;
        this.dados = dados;
        this.contentType = contentType;
        this.ordem = ordem;
    }
}
