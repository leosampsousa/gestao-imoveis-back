package com.rentmanager.rent_manager.service;

import com.rentmanager.rent_manager.dto.HospedeDto;
import com.rentmanager.rent_manager.entity.Hospede;
import com.rentmanager.rent_manager.exception.BusinessException;
import com.rentmanager.rent_manager.repository.HospedeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HospedeService {

    private HospedeRepository hospedeRepository;

    @Autowired
    public HospedeService(HospedeRepository hospedeRepository) {
        this.hospedeRepository = hospedeRepository;
    }

    @Transactional
    public HospedeDto salvar(HospedeDto dto) {
        if (hospedeJaCadastrado(dto.getDocumento())) {
            throw new BusinessException(dto.getTipoDocumento().toString() +  " já cadastrado");
        }
        Hospede hospede =  hospedeRepository.save(dto.toEntity());
        return HospedeDto.fromEntity(hospede);
    }

    private boolean hospedeJaCadastrado(String documento) {
        Optional<Hospede> optHospede = hospedeRepository.findByDocumento(documento);
        return optHospede.isPresent();
    }

    public List<HospedeDto> listar() {
        return hospedeRepository.findAll().stream()
                .map(HospedeDto::fromEntity)
                .toList();
    }
}
