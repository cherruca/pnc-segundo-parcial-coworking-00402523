package com.uca.pncsegundoparcialcoworking.controller;

import com.uca.pncsegundoparcialcoworking.domain.entity.Space;
import com.uca.pncsegundoparcialcoworking.domain.enums.SpaceType;
import com.uca.pncsegundoparcialcoworking.dto.SpaceRequestDTO;
import com.uca.pncsegundoparcialcoworking.service.SpaceService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/spaces")
@AllArgsConstructor
public class SpaceController {

    private final SpaceService spaceService;

    @PostMapping
    public ResponseEntity<Space> createSpace(@Valid @RequestBody SpaceRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(spaceService.createSpace(dto));
    }

    @GetMapping
    public ResponseEntity<List<Space>> getAllSpaces(
            @RequestParam(required = false) SpaceType type,
            @RequestParam(required = false) Boolean available) {
        return ResponseEntity.ok(spaceService.getAllSpaces(type, available));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Space> getSpaceById(@PathVariable Long id) {
        return ResponseEntity.ok(spaceService.getSpaceById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Space> updateSpace(
            @PathVariable Long id,
            @Valid @RequestBody SpaceRequestDTO dto) {
        return ResponseEntity.ok(spaceService.updateSpace(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Space> deleteSpace(@PathVariable Long id) {
        return ResponseEntity.ok(spaceService.deleteSpace(id));
    }
}
