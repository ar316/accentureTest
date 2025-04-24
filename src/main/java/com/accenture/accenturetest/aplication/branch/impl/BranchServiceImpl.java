package com.accenture.accenturetest.aplication.branch.impl;

import com.accenture.accenturetest.aplication.branch.BranchService;
import com.accenture.accenturetest.config.CollectConstant;
import com.accenture.accenturetest.config.ex.BranchNotFoundException;
import com.accenture.accenturetest.config.ex.ProductNotFoundException;
import com.accenture.accenturetest.domain.model.Branch;
import com.accenture.accenturetest.domain.model.Product;
import com.accenture.accenturetest.infrastructure.dao.branch.BranchDao;
import com.accenture.accenturetest.infrastructure.dao.product.ProductDao;
import com.accenture.accenturetest.infrastructure.dto.branch.BranchResponseDTO;
import com.accenture.accenturetest.infrastructure.dto.product.ProductRequestDTO;
import com.accenture.accenturetest.infrastructure.dto.product.ProductResponseDTO;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BranchServiceImpl implements BranchService {

  private final BranchDao branchDao;
  private final ProductDao productDao;
  private final Function<ProductRequestDTO, Product> productDtoToEntity;
  private final Function<Product, ProductResponseDTO> entityToProductDto;
  private final Function<Branch, BranchResponseDTO> entityToBranchDTO;

  @Override
  public ProductResponseDTO addProductToBranch(Long branchId, ProductRequestDTO request) {

    Branch branch =
        branchDao
            .findById(branchId)
            .orElseThrow(() -> new BranchNotFoundException(CollectConstant.BRANCH_NOT_FOUND));

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
                throw new ProductNotFoundException(CollectConstant.PRODUCT_NOT_FOUND);
              } else {
                throw new BranchNotFoundException(CollectConstant.PRODUCT_NOT_ASOCIATED_TO_BRANCH);
              }
            });

    if (branch.isEmpty()) {
      throw new BranchNotFoundException(CollectConstant.BRANCH_NOT_FOUND);
    }

    return "Ok";
  }

  public String modifyProductStock(Long branchId, Long productId, int newStock) {
    return branchDao
        .findById(branchId)
        .flatMap(branch -> productDao.findProductByIdAndBranchId(productId, branchId))
        .filter(product -> newStock >= 0)
        .map(
            product -> {
              product.setStock(newStock);
              productDao.save(product);
              return CollectConstant.STOCK_UPDATED_SUCCESSFULLY;
            })
        .orElseThrow(() -> new BranchNotFoundException(CollectConstant.PRODUCT_OR_BRACH_INVALID));
  }

  @Override
  public BranchResponseDTO updateBranchName(Long id, String newName) {
    Branch branch =
        branchDao
            .findById(id)
            .orElseThrow(() -> new BranchNotFoundException(CollectConstant.BRANCH_NOT_FOUND));
    branch.setName(newName);
    return entityToBranchDTO.apply(branchDao.save(branch));
  }
}
