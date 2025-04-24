package com.accenture.accenturetest.aplication.product;

public interface ProductService {

    /**
     * Actualiza el nombre de un producto específico.
     *
     * @param productId ID del producto que se desea actualizar.
     * @param newName El nuevo nombre para el producto.
     * @return Un mensaje de confirmación indicando que el nombre del producto ha sido actualizado.
     * @status 201 Creado si el nombre del producto se actualiza correctamente.
     */
    String updateProductName(Long productId, String newName);
}
