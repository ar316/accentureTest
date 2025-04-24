package com.accenture.accenturetest.aplication.branch;

import com.accenture.accenturetest.infrastructure.dto.branch.BranchResponseDTO;
import com.accenture.accenturetest.infrastructure.dto.product.ProductRequestDTO;
import com.accenture.accenturetest.infrastructure.dto.product.ProductResponseDTO;

import java.util.List;

public interface BranchService {
    /**
     * Crea un nuevo producto y lo asocia a una sucursal específica.
     *
     * @param branchId ID de la sucursal donde se añadirá el producto.
     * @param request Detalles del producto a crear (validados).
     * @return Los detalles del producto creado en la respuesta.
     * @status 201 Creado si el producto se añade correctamente.
     */
    ProductResponseDTO addProductToBranch(Long branchId, ProductRequestDTO request);

    /**
     * Obtiene todos los productos asociados a una sucursal específica.
     *
     * @param branchId ID de la sucursal cuyos productos se desean obtener.
     * @return Una lista de productos asociados a la sucursal.
     * @status 200 OK si los productos se obtienen correctamente.
     */
    List<ProductResponseDTO> getProductsByBranchId(Long branchId);


    /**
     * Elimina un producto de una sucursal específica.
     *
     * @param branchId ID de la sucursal de la que se eliminará el producto.
     * @param productId ID del producto que se desea eliminar.
     * @return Un mensaje de confirmación indicando que el producto ha sido eliminado.
     * @status 200 OK si el producto se elimina correctamente.
     */
    String deleteProductFromBranch(Long branchId, Long productId);


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
    String modifyProductStock(Long branchId, Long productId, int newStock);


    /**
     * Actualiza el nombre de una sucursal.
     *
     * @param id ID de la sucursal que se desea actualizar.
     * @param newName Nuevo nombre para la sucursal.
     * @return Los detalles actualizados de la sucursal.
     * @status 200 OK si el nombre de la sucursal se actualiza correctamente.
     */
    BranchResponseDTO updateBranchName(Long id, String newName);
}
