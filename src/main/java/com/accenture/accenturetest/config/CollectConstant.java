package com.accenture.accenturetest.config;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CollectConstant {

  public static final String BRANCH_NOT_FOUND = "Sucursal no encontrada";
  public static final String PRODUCT_NOT_FOUND = "Producto no encontrado";
  public static final String PRODUCT_NOT_ASOCIATED_TO_BRANCH =
      "El producto no pertenece a la sucursal";
  public static final String PRODUCT_OR_BRACH_INVALID =
      "No se encontró la sucursal o el producto con los ID proporcionados o el stock no es válido.";
  public static final String STOCK_UPDATED_SUCCESSFULLY = "Stock updated successfully";

  public static final String INVALID_PRODUCT_NAME = "Nombre del producto no puede ser nulo o vacío";

  public static final String UPDATE_NAME_SUCCESSFUL =
      "Nombre del producto actualizado correctamente";
}
