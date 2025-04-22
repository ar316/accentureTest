package com.accenture.accenturetest.infrastructure.controllers.franchise;


import com.accenture.accenturetest.aplication.franchise.FranchiseService;
import com.accenture.accenturetest.domain.model.Franchise;
import com.accenture.accenturetest.infrastructure.dto.franchise.FranchiseDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/franchises")
@RequiredArgsConstructor
public class FranchiseController {


    private final FranchiseService service;

    @PostMapping
    public ResponseEntity<FranchiseDTO> create(@RequestBody @Valid FranchiseDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createFranchise(dto));
    }

    @PutMapping("/{id}/name")
    public ResponseEntity<FranchiseDTO> updateName(@PathVariable Long id, @RequestBody String newName) {
        return ResponseEntity.ok(service.updateFranchiseName(id, newName));
    }
}
