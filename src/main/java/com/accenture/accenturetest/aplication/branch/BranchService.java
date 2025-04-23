package com.accenture.accenturetest.aplication.branch;

import com.accenture.accenturetest.infrastructure.dto.product.ProductRequestDTO;
import com.accenture.accenturetest.infrastructure.dto.product.ProductResponseDTO;

import java.util.List;

public interface BranchService {
    ProductResponseDTO addProductToBranch(Long branchId, ProductRequestDTO request);

    List<ProductResponseDTO> getProductsByBranchId(Long branchId);

    String deleteProductFromBranch(Long branchId, Long productId);
}
