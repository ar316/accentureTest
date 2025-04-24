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
@RequestMapping("/api/franchise")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class FranchiseController {

  private final FranchiseService service;

  /**
   * Crea una nueva franquicia.
   *
   * @param dto Detalles de la franquicia que se desea crear (validado).
   * @return Los detalles de la franquicia creada en la respuesta.
   * @status 201 Creado si la franquicia se crea correctamente.
   */
  @PostMapping
  public ResponseEntity<FranchiseDTO> create(@RequestBody @Valid FranchiseDTO dto) {
    return ResponseEntity.status(HttpStatus.CREATED).body(service.createFranchise(dto));
  }

  /**
   * Actualiza el nombre de una franquicia.
   *
   * @param id ID de la franquicia que se desea actualizar.
   * @param newName El nuevo nombre para la franquicia.
   * @return Los detalles actualizados de la franquicia.
   * @status 200 OK si el nombre de la franquicia se actualiza correctamente.
   */
  @PutMapping("/{id}/name")
  public ResponseEntity<FranchiseDTO> updateName(
      @PathVariable Long id, @RequestParam("newName") String newName) {
    return ResponseEntity.ok(service.updateFranchiseName(id, newName));
  }


  /**
   * Crea una nueva sucursal y la asocia a una franquicia específica.
   *
   * @param franchiseId ID de la franquicia a la que se asociará la nueva sucursal.
   * @param branchRequest Detalles de la sucursal que se desea crear.
   * @return Detalles de la sucursal creada en la respuesta.
   * @status 201 Creado si la sucursal se añade correctamente a la franquicia.
   */
  @PostMapping("/{franchiseId}/create-branch")
  public ResponseEntity<BranchResponseDTO> addBranchToFranchise(
      @PathVariable Long franchiseId, @RequestBody BranchRequestDTO branchRequest) {

    BranchResponseDTO branchDTO = service.addBranchToFranchise(franchiseId, branchRequest);
    return ResponseEntity.status(HttpStatus.CREATED).body(branchDTO);
  }


  /**
   * Obtiene el producto con mayor stock por sucursal para una franquicia específica.
   *
   * @param franchiseId ID de la franquicia cuyas sucursales se desean consultar.
   * @return Una lista de productos con mayor stock, indicando a qué sucursal pertenecen.
   * @status 200 OK si los datos se obtienen correctamente.
   */
  @GetMapping("/roducts-with-mostStock-per-branch")
  public ResponseEntity<List<ProductsByBranchResponseDTO>> getProductsWithMostStockPerBranch(
      @RequestParam("franchiseId") Long franchiseId) {
    return ResponseEntity.ok().body(service.getProductsWithMostStockPerBranch(franchiseId));
  }
}
