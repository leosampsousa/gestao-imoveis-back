package com.rentmanager.rent_manager.service;

import com.rentmanager.rent_manager.dto.ReservaDto;
import com.rentmanager.rent_manager.entity.Hospede;
import com.rentmanager.rent_manager.entity.Imovel;
import com.rentmanager.rent_manager.entity.Reserva;
import com.rentmanager.rent_manager.exception.BusinessException;
import com.rentmanager.rent_manager.repository.HospedeRepository;
import com.rentmanager.rent_manager.repository.ImovelRepository;
import com.rentmanager.rent_manager.repository.ReservaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReservaService {

    private final ReservaRepository reservaRepository;
    private final ImovelRepository imovelRepository;
    private final HospedeRepository hospedeRepository;

    @Transactional
    public ReservaDto criarReserva(ReservaDto dto) {
        Imovel imovel = imovelRepository.findById(dto.getImovelId())
                .orElseThrow(() -> new BusinessException("Imóvel não encontrado"));

        Hospede hospede = hospedeRepository.findById(dto.getHospedeId())
                .orElseThrow(() -> new BusinessException("Hóspede não encontrado"));

        if(dto.getDataInicio().isAfter(dto.getDataFim())) {
            throw new BusinessException("A data de início não pode ser posterior à data de fim");
        }

        Reserva reserva = new Reserva();
        reserva.setImovel(imovel);
        reserva.setHospede(hospede);
        reserva.setDataInicio(dto.getDataInicio());
        reserva.setDataFim(dto.getDataFim());
        reserva.setPrecoTotal(dto.getPrecoTotal());

        reserva = reservaRepository.save(reserva);
        return toDto(reserva);
    }

    @Transactional(readOnly = true)
    public List<ReservaDto> listarTodas() {
        return reservaRepository.findAll().stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    private ReservaDto toDto(Reserva reserva) {
        ReservaDto dto = new ReservaDto();
        dto.setId(reserva.getId());
        dto.setImovelId(reserva.getImovel().getId());
        dto.setImovelNome(reserva.getImovel().getNome());
        dto.setHospedeId(reserva.getHospede().getId());
        dto.setHospedeNome(reserva.getHospede().getNome()); // Assumindo que tem getNome() em Hospede, senao precisa ajustar
        dto.setDataInicio(reserva.getDataInicio());
        dto.setDataFim(reserva.getDataFim());
        dto.setPrecoTotal(reserva.getPrecoTotal());
        return dto;
    }
}
