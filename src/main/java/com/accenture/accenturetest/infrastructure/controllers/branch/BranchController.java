package com.accenture.accenturetest.infrastructure.controllers.branch;

import com.accenture.accenturetest.aplication.branch.BranchService;
import com.accenture.accenturetest.infrastructure.dto.branch.BranchResponseDTO;
import com.accenture.accenturetest.infrastructure.dto.product.ProductRequestDTO;
import com.accenture.accenturetest.infrastructure.dto.product.ProductResponseDTO;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/branch")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class BranchController {

  private final BranchService service;

  @PostMapping("/{branchId}/create-products")
  public ResponseEntity<ProductResponseDTO> addProductToBranch(
      @PathVariable Long branchId, @RequestBody @Valid ProductRequestDTO requestDTO) {
    ProductResponseDTO response = service.addProductToBranch(branchId, requestDTO);
    return ResponseEntity.status(HttpStatus.CREATED).body(response);
  }

  @GetMapping("/get-products")
  public ResponseEntity<List<ProductResponseDTO>> getProductsByBranchId(
      @RequestParam("idBranch") Long branchId) {
    return ResponseEntity.status(HttpStatus.CREATED).body(service.getProductsByBranchId(branchId));
  }

  @DeleteMapping("/{branchId}/products/{productId}")
  public ResponseEntity<String> deleteProductFromBranch(
      @PathVariable Long branchId, @PathVariable Long productId) {
    return ResponseEntity.ok(service.deleteProductFromBranch(branchId, productId));
  }

  @PutMapping("/{branchId}/products/{productId}/change-stock")
  public ResponseEntity<String> modifyStock(
      @PathVariable Long branchId,
      @PathVariable Long productId,
      @RequestParam("newStock") int newStock)
      throws Exception {
    return ResponseEntity.ok(service.modifyProductStock(branchId, productId, newStock));
  }

  @PutMapping("/{id}/name")
  public ResponseEntity<BranchResponseDTO> updateName(
      @PathVariable Long id, @RequestParam("newName") String newName) {
    return ResponseEntity.ok(service.updateBranchName(id, newName));
  }
}
