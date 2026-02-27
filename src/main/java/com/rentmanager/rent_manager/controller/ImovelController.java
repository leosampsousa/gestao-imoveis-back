package com.rentmanager.rent_manager.controller;

import com.rentmanager.rent_manager.dto.ImovelDto;
import com.rentmanager.rent_manager.service.ImovelService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/imovel")
public class ImovelController {

    private final ImovelService imovelService;

    @Autowired
    public ImovelController(ImovelService imovelService) {
        this.imovelService = imovelService;
    }

    @PostMapping
    public ResponseEntity<ImovelDto> salvar(@RequestBody @Valid ImovelDto dto) {
        ImovelDto imovelSalvo = imovelService.salvar(dto);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(imovelSalvo.getId())
                .toUri();
        return ResponseEntity.created(location).body(imovelSalvo);
    }

    @GetMapping
    public ResponseEntity<List<ImovelDto>> listarTodos() {
        return ResponseEntity.ok(imovelService.listarTodos());
    }

    @PostMapping("/{id}/fotos")
    public ResponseEntity<?> uploadFotos(
            @PathVariable Long id,
            @RequestParam(value = "files", required = false) List<MultipartFile> files
    ) throws IOException {
        imovelService.salvarFotos(id, files);
        return ResponseEntity.ok().build();
    }
}
