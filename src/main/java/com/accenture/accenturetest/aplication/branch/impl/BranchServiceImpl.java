package com.accenture.accenturetest.aplication.branch.impl;

import com.accenture.accenturetest.aplication.branch.BranchService;
import com.accenture.accenturetest.config.ex.BranchNotFoundException;
import com.accenture.accenturetest.config.ex.ProductNotFoundException;
import com.accenture.accenturetest.domain.model.Branch;
import com.accenture.accenturetest.domain.model.Product;
import com.accenture.accenturetest.infrastructure.dao.branch.BranchDao;
import com.accenture.accenturetest.infrastructure.dao.product.ProductDao;
import com.accenture.accenturetest.infrastructure.dto.product.ProductRequestDTO;
import com.accenture.accenturetest.infrastructure.dto.product.ProductResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
@RequiredArgsConstructor
public class BranchServiceImpl implements BranchService {

  private final BranchDao branchDao;
  private final ProductDao productDao;
  private final Function<ProductRequestDTO, Product> productDtoToEntity;
  private final Function<Product, ProductResponseDTO> entityToProductDto;

  @Override
  public ProductResponseDTO addProductToBranch(Long branchId, ProductRequestDTO request) {

    Branch branch =
        branchDao
            .findById(branchId)
            .orElseThrow(() -> new BranchNotFoundException("Sucursal no encontrada"));

    Product product = new Product();
    product.setName(request.getName());
    product.setStock(request.getStock());
    product.setBranch(branch);
    Product savedProduct = productDao.save(product);
    return entityToProductDto.apply(savedProduct);
  }

  @Override
  public List<ProductResponseDTO> getProductsByBranchId(Long branchId) {
    return productDao.getProductsByBranchId(branchId).stream().map(entityToProductDto).toList();
  }

  @Override
  public String deleteProductFromBranch(Long branchId, Long productId) {
    Optional<Branch> branch = branchDao.findById(branchId);
    Optional<Product> product = productDao.findById(productId);

    branch
        .flatMap(b -> product.filter(p -> p.getBranch().getId().equals(b.getId())))
        .ifPresentOrElse(
            productDao::delete,
            () -> {
              if (product.isEmpty()) {
                throw new ProductNotFoundException("Producto no encontrado");
              } else {
                throw new BranchNotFoundException("El producto no pertenece a la sucursal");
              }
            });

    if (branch.isEmpty()) {
      throw new BranchNotFoundException("Sucursal no encontrada");
    }

    return "Ok";
  }
}
