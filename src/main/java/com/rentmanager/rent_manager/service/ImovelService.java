package com.rentmanager.rent_manager.service;

import com.rentmanager.rent_manager.dto.ImovelDto;
import com.rentmanager.rent_manager.entity.Imovel;
import com.rentmanager.rent_manager.entity.ImovelFoto;
import com.rentmanager.rent_manager.exception.BusinessException;
import com.rentmanager.rent_manager.repository.ImovelFotoRepository;
import com.rentmanager.rent_manager.repository.ImovelRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class ImovelService {

    private final ImovelRepository imovelRepository;

    private final ImovelFotoRepository imovelFotoRepository;

    @Autowired
    public ImovelService(ImovelRepository imovelRepository, ImovelFotoRepository imovelFotoRepository) {
        this.imovelRepository = imovelRepository;
        this.imovelFotoRepository = imovelFotoRepository;
    }

    @Transactional
    public ImovelDto salvar(ImovelDto dto) {
        Imovel imovelSalvo = imovelRepository.save(dto.toEntity());
        return ImovelDto.fromEntity(imovelSalvo);
    }

    public List<ImovelDto> listarTodos() {
        return imovelRepository.findAll().stream()
                .map(ImovelDto::fromEntity)
                .toList();
    }

    @Transactional
    public boolean salvarFotos(Long id, List<MultipartFile> files) throws IOException {
        Optional<Imovel> optImovel = imovelRepository.findById(id);
        if (optImovel.isEmpty()) {
            throw new BusinessException("Imóvel não existe");
        }

        Imovel imovel = optImovel.get();
        int count = 0;
        for (MultipartFile file : files) {
            imovelFotoRepository.save(new ImovelFoto(imovel, file.getBytes(), file.getContentType(), count++));
        }

        return true;
    }
}
