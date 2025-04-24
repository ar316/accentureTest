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

  @PutMapping("/{productId}/name")
  public ResponseEntity<String> updateProductName(
      @PathVariable Long productId, @RequestParam("newName") String newName) {
    return ResponseEntity.status(HttpStatus.CREATED)
        .body(service.updateProductName(productId, newName));
  }
}
