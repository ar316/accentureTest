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

  /**
   * Crea un nuevo producto y lo asocia a una sucursal específica.
   *
   * @param branchId ID de la sucursal donde se añadirá el producto.
   * @param requestDTO Detalles del producto a crear (validados).
   * @return Los detalles del producto creado en la respuesta.
   * @status 201 Creado si el producto se añade correctamente.
   */
  @PostMapping("/{branchId}/create-products")
  public ResponseEntity<ProductResponseDTO> addProductToBranch(
      @PathVariable Long branchId, @RequestBody @Valid ProductRequestDTO requestDTO) {
    ProductResponseDTO response = service.addProductToBranch(branchId, requestDTO);
    return ResponseEntity.status(HttpStatus.CREATED).body(response);
  }

  /**
   * Obtiene todos los productos asociados a una sucursal específica.
   *
   * @param branchId ID de la sucursal cuyos productos se desean obtener.
   * @return Una lista de productos asociados a la sucursal.
   * @status 200 OK si los productos se obtienen correctamente.
   */
  @GetMapping("/get-products")
  public ResponseEntity<List<ProductResponseDTO>> getProductsByBranchId(
      @RequestParam("idBranch") Long branchId) {
    return ResponseEntity.ok().body(service.getProductsByBranchId(branchId));
  }


  /**
   * Elimina un producto de una sucursal específica.
   *
   * @param branchId ID de la sucursal de la que se eliminará el producto.
   * @param productId ID del producto que se desea eliminar.
   * @return Un mensaje de confirmación indicando que el producto ha sido eliminado.
   * @status 200 OK si el producto se elimina correctamente.
   */
  @DeleteMapping("/{branchId}/products/{productId}")
  public ResponseEntity<String> deleteProductFromBranch(
      @PathVariable Long branchId, @PathVariable Long productId) {
    return ResponseEntity.ok(service.deleteProductFromBranch(branchId, productId));
  }


  /**
   * Modifica el stock de un producto en una sucursal específica.
   *
   * @param branchId ID de la sucursal donde pertenece el producto.
   * @param productId ID del producto cuyo stock será modificado.
   * @param newStock Nuevo valor del stock para el producto.
   * @return Un mensaje de confirmación indicando que el stock ha sido actualizado.
   * @throws Exception Si no se encuentra la sucursal o el producto, o si el stock es inválido.
   * @status 200 OK si el stock se actualiza correctamente.
   */
  @PutMapping("/{branchId}/products/{productId}/change-stock")
  public ResponseEntity<String> modifyStock(
      @PathVariable Long branchId,
      @PathVariable Long productId,
      @RequestParam("newStock") int newStock)
      throws Exception {
    return ResponseEntity.ok(service.modifyProductStock(branchId, productId, newStock));
  }


  /**
   * Actualiza el nombre de una sucursal.
   *
   * @param id ID de la sucursal que se desea actualizar.
   * @param newName Nuevo nombre para la sucursal.
   * @return Los detalles actualizados de la sucursal.
   * @status 200 OK si el nombre de la sucursal se actualiza correctamente.
   */
  @PutMapping("/{id}/name")
  public ResponseEntity<BranchResponseDTO> updateName(
      @PathVariable Long id, @RequestParam("newName") String newName) {
    return ResponseEntity.ok(service.updateBranchName(id, newName));
  }
}
