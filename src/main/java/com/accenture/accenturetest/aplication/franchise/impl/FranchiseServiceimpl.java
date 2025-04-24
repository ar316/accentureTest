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

  @Override
  public FranchiseDTO createFranchise(FranchiseDTO dto) {
    Franchise franchise = franchiseDTOToEntity.apply(dto);
    return entityToFranchiseDTO.apply(franchiseDao.save(franchise));
  }

  @Override
  public FranchiseDTO updateFranchiseName(Long id, String newName) {
    Franchise franchise = franchiseDao.findById(id);

    franchise.setName(newName);
    franchise.getId();
    return entityToFranchiseDTO.apply(franchiseDao.save(franchise));
  }

  @Override
  public BranchResponseDTO addBranchToFranchise(Long franchiseId, BranchRequestDTO branchRequest) {
    Franchise franchise = franchiseDao.findById(franchiseId);

    Branch response =
        branchDao.save(Branch.builder().name(branchRequest.getName()).franchise(franchise).build());

    return entityToBranchDTO.apply(response);
  }

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

  // Método auxiliar para mapear Product a ProductResponseDTO.
  private ProductResponseDTO mapToProductResponseDTO(Product product) {
    return ProductResponseDTO.builder()
        .id(product.getId())
        .name(product.getName())
        .stock(product.getStock())
        .build();
  }
}
