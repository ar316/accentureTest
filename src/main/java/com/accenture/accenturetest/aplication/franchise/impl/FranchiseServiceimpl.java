package com.accenture.accenturetest.aplication.franchise.impl;

import com.accenture.accenturetest.aplication.franchise.FranchiseService;
import com.accenture.accenturetest.domain.model.Branch;
import com.accenture.accenturetest.domain.model.Franchise;
import com.accenture.accenturetest.domain.model.Product;
import com.accenture.accenturetest.infrastructure.dao.branch.BranchDao;
import com.accenture.accenturetest.infrastructure.dao.franchise.FranchiseDao;
import com.accenture.accenturetest.infrastructure.dto.branch.BranchRequestDTO;
import com.accenture.accenturetest.infrastructure.dto.branch.BranchResponseDTO;
import com.accenture.accenturetest.infrastructure.dto.franchise.FranchiseDTO;

import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

import com.accenture.accenturetest.infrastructure.dto.product.ProductResponseDTO;
import com.accenture.accenturetest.infrastructure.dto.product.ProductsByBranchResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FranchiseServiceimpl implements FranchiseService {

  private final FranchiseDao franchiseDao;
  private final BranchDao branchDao;
  private final Function<FranchiseDTO, Franchise> franchiseDTOToEntity;
  private final Function<Franchise, FranchiseDTO> entityToFranchiseDTO;
  private final Function<Branch, BranchResponseDTO> entityToBranchDTO;


  /**
   * Crea una nueva franquicia.
   *
   * @param dto Detalles de la franquicia que se desea crear (validado).
   * @return Los detalles de la franquicia creada en la respuesta.
   * @status 201 Creado si la franquicia se crea correctamente.
   */
  @Override
  public FranchiseDTO createFranchise(FranchiseDTO dto) {
    Franchise franchise = franchiseDTOToEntity.apply(dto);
    return entityToFranchiseDTO.apply(franchiseDao.save(franchise));
  }


  /**
   * Actualiza el nombre de una franquicia.
   *
   * @param id ID de la franquicia que se desea actualizar.
   * @param newName El nuevo nombre para la franquicia.
   * @return Los detalles actualizados de la franquicia.
   * @status 200 OK si el nombre de la franquicia se actualiza correctamente.
   */
  @Override
  public FranchiseDTO updateFranchiseName(Long id, String newName) {
    Franchise franchise = franchiseDao.findById(id);

    franchise.setName(newName);
    franchise.getId();
    return entityToFranchiseDTO.apply(franchiseDao.save(franchise));
  }


  /**
   * Crea una nueva sucursal y la asocia a una franquicia específica.
   *
   * @param franchiseId ID de la franquicia a la que se asociará la nueva sucursal.
   * @param branchRequest Detalles de la sucursal que se desea crear.
   * @return Detalles de la sucursal creada en la respuesta.
   * @status 201 Creado si la sucursal se añade correctamente a la franquicia.
   */
  @Override
  public BranchResponseDTO addBranchToFranchise(Long franchiseId, BranchRequestDTO branchRequest) {
    Franchise franchise = franchiseDao.findById(franchiseId);

    Branch response =
        branchDao.save(Branch.builder().name(branchRequest.getName()).franchise(franchise).build());

    return entityToBranchDTO.apply(response);
  }


  /**
   * Obtiene el producto con mayor stock por sucursal para una franquicia específica.
   *
   * @param franchiseId ID de la franquicia cuyas sucursales se desean consultar.
   * @return Una lista de productos con mayor stock, indicando a qué sucursal pertenecen.
   * @status 200 OK si los datos se obtienen correctamente.
   */
  public List<ProductsByBranchResponseDTO> getProductsWithMostStockPerBranch(Long franchiseId) {
    Franchise franchise = franchiseDao.findById(franchiseId);

    List<Branch> branches = franchise.getSucursales();

    if (branches == null || branches.isEmpty()) {
      return List.of();
    }

    return branches.stream()
        .map(
            branch -> {
              Product productWithMostStock =
                  branch.getProducts().stream()
                      .max(Comparator.comparingInt(Product::getStock))
                      .orElse(null);

              return ProductsByBranchResponseDTO.builder()
                  .branchName(branch.getName())
                  .products(
                      productWithMostStock != null
                          ? List.of(mapToProductResponseDTO(productWithMostStock))
                          : List.of())
                  .build();
            })
        .toList();
  }

  private ProductResponseDTO mapToProductResponseDTO(Product product) {
    return ProductResponseDTO.builder()
        .id(product.getId())
        .name(product.getName())
        .stock(product.getStock())
        .build();
  }
}
