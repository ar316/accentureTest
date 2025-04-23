package com.accenture.accenturetest.infrastructure.dao.product.impl;

import com.accenture.accenturetest.domain.model.Product;
import com.accenture.accenturetest.infrastructure.dao.product.ProductDao;
import com.accenture.accenturetest.infrastructure.dao.product.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductDaoImpl implements ProductDao {

  private final ProductRepository productRepository;

  @Override
  public Product save(Product product) {
    return productRepository.save(product);
  }

  @Override
  public List<Product> getProductsByBranchId(Long branchId) {
    return productRepository.findByBranch_Id(branchId);
  }

  @Override
  public Optional<Product> findById(Long productId) {
    return productRepository.findById(productId);
  }

  @Override
  public void delete(Product product) {
    productRepository.delete(product);
  }
}
