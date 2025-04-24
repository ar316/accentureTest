package com.accenture.accenturetest.infrastructure.dao.product;

import com.accenture.accenturetest.domain.model.Product;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

public interface ProductDao {
    Product save(Product product);

    List<Product> getProductsByBranchId(Long branchId);

    Optional<Product> findById(Long productId);

    void delete(Product product);

    Optional<Product> findProductByIdAndBranchId(Long productId, Long branchId);
}
