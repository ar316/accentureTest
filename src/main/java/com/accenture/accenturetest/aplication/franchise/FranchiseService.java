package com.accenture.accenturetest.aplication.franchise;

import com.accenture.accenturetest.infrastructure.dto.branch.BranchRequestDTO;
import com.accenture.accenturetest.infrastructure.dto.branch.BranchResponseDTO;
import com.accenture.accenturetest.infrastructure.dto.franchise.FranchiseDTO;
import com.accenture.accenturetest.infrastructure.dto.product.ProductsByBranchResponseDTO;

import java.util.List;

public interface FranchiseService {
    /**
     * Crea una nueva franquicia.
     *
     * @param dto Detalles de la franquicia que se desea crear (validado).
     * @return Los detalles de la franquicia creada en la respuesta.
     * @status 201 Creado si la franquicia se crea correctamente.
     */
    FranchiseDTO createFranchise(FranchiseDTO dto);

    /**
     * Actualiza el nombre de una franquicia.
     *
     * @param id ID de la franquicia que se desea actualizar.
     * @param newName El nuevo nombre para la franquicia.
     * @return Los detalles actualizados de la franquicia.
     * @status 200 OK si el nombre de la franquicia se actualiza correctamente.
     */
    FranchiseDTO updateFranchiseName(Long id, String newName);


    /**
     * Crea una nueva sucursal y la asocia a una franquicia específica.
     *
     * @param franchiseId ID de la franquicia a la que se asociará la nueva sucursal.
     * @param branchRequest Detalles de la sucursal que se desea crear.
     * @return Detalles de la sucursal creada en la respuesta.
     * @status 201 Creado si la sucursal se añade correctamente a la franquicia.
     */
    BranchResponseDTO addBranchToFranchise(Long franchiseId, BranchRequestDTO branchRequest);


    /**
     * Obtiene el producto con mayor stock por sucursal para una franquicia específica.
     *
     * @param franchiseId ID de la franquicia cuyas sucursales se desean consultar.
     * @return Una lista de productos con mayor stock, indicando a qué sucursal pertenecen.
     * @status 200 OK si los datos se obtienen correctamente.
     */
    List<ProductsByBranchResponseDTO> getProductsWithMostStockPerBranch(Long franchiseId);
}
