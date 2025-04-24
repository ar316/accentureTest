package com.accenture.accenturetest.infrastructure.controllers.product;

import com.accenture.accenturetest.aplication.product.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/prduct")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class ProductController {

  private final ProductService service;

  /**
   * Actualiza el nombre de un producto específico.
   *
   * @param productId ID del producto que se desea actualizar.
   * @param newName El nuevo nombre para el producto.
   * @return Un mensaje de confirmación indicando que el nombre del producto ha sido actualizado.
   * @status 201 Creado si el nombre del producto se actualiza correctamente.
   */
  @PutMapping("/{productId}/name")
  public ResponseEntity<String> updateProductName(
      @PathVariable Long productId, @RequestParam("newName") String newName) {
    return ResponseEntity.ok().body(service.updateProductName(productId, newName));
  }
}
