package com.rentmanager.rent_manager.controller;

import com.rentmanager.rent_manager.dto.HospedeDto;
import com.rentmanager.rent_manager.service.HospedeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/hospede")
public class HospedeController {

    private final HospedeService hospedeService;

    @Autowired
    public HospedeController (HospedeService hospedeService) {
        this.hospedeService = hospedeService;
    }

    @PostMapping
    private ResponseEntity<HospedeDto> salvar(@RequestBody @Valid HospedeDto dto) {
        HospedeDto hospedeSalvo = hospedeService.salvar(dto);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(hospedeSalvo.getId())
                .toUri();
        return ResponseEntity.created(location).body(hospedeSalvo);
    }
}
