package com.accenture.accenturetest.infrastructure.controllers.franchise;

import com.accenture.accenturetest.aplication.franchise.FranchiseService;
import com.accenture.accenturetest.domain.model.Franchise;
import com.accenture.accenturetest.infrastructure.dto.branch.BranchRequestDTO;
import com.accenture.accenturetest.infrastructure.dto.branch.BranchResponseDTO;
import com.accenture.accenturetest.infrastructure.dto.franchise.FranchiseDTO;
import com.accenture.accenturetest.infrastructure.dto.product.ProductsByBranchResponseDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
  public ResponseEntity<FranchiseDTO> updateName(
      @PathVariable Long id, @RequestParam("newName") String newName) {
    return ResponseEntity.ok(service.updateFranchiseName(id, newName));
  }

  @PostMapping("/{franchiseId}/create-branch")
  public ResponseEntity<BranchResponseDTO> addBranchToFranchise(
      @PathVariable Long franchiseId, @RequestBody BranchRequestDTO branchRequest) {

    BranchResponseDTO branchDTO = service.addBranchToFranchise(franchiseId, branchRequest);
    return ResponseEntity.status(HttpStatus.CREATED).body(branchDTO);
  }

  @GetMapping("/roducts-with-mostStock-per-branch")
  public ResponseEntity<List<ProductsByBranchResponseDTO>> getProductsWithMostStockPerBranch(
      @RequestParam("franchiseId") Long franchiseId) {
    return ResponseEntity.status(HttpStatus.OK)
        .body(service.getProductsWithMostStockPerBranch(franchiseId));
  }
}
