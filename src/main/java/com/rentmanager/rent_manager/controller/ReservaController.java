package com.rentmanager.rent_manager.controller;

import com.rentmanager.rent_manager.dto.ReservaDto;
import com.rentmanager.rent_manager.service.ReservaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservas")
@RequiredArgsConstructor
public class ReservaController {

    private final ReservaService reservaService;

    @PostMapping
    public ResponseEntity<ReservaDto> criarReserva(@RequestBody ReservaDto reservaDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(reservaService.criarReserva(reservaDto));
    }

    @GetMapping
    public ResponseEntity<List<ReservaDto>> listarTodas() {
        return ResponseEntity.ok(reservaService.listarTodas());
    }
}
