package com.accenture.accenturetest.aplication.product.impl;

import com.accenture.accenturetest.aplication.product.ProductService;
import com.accenture.accenturetest.config.CollectConstant;
import com.accenture.accenturetest.config.ex.InvalidArgumentException;
import com.accenture.accenturetest.config.ex.ProductNotFoundException;
import com.accenture.accenturetest.domain.model.Product;
import com.accenture.accenturetest.infrastructure.dao.product.ProductDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

  private final ProductDao productDao;


  /**
   * Actualiza el nombre de un producto específico.
   *
   * @param productId ID del producto que se desea actualizar.
   * @param newName El nuevo nombre para el producto.
   * @return Un mensaje de confirmación indicando que el nombre del producto ha sido actualizado.
   * @status 201 Creado si el nombre del producto se actualiza correctamente.
   */
  @Override
  public String updateProductName(Long productId, String newName) {
    Product product =
        productDao
            .findById(productId)
            .orElseThrow(() -> new ProductNotFoundException(CollectConstant.PRODUCT_NOT_FOUND));

    if (newName == null || newName.trim().isEmpty()) {
      throw new InvalidArgumentException(CollectConstant.INVALID_PRODUCT_NAME);
    }
    product.setName(newName);
    productDao.save(product);
    return CollectConstant.UPDATE_NAME_SUCCESSFUL;
  }
}
