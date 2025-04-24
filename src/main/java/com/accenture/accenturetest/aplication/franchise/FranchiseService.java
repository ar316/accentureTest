package com.accenture.accenturetest.aplication.franchise;

import com.accenture.accenturetest.infrastructure.dto.branch.BranchRequestDTO;
import com.accenture.accenturetest.infrastructure.dto.branch.BranchResponseDTO;
import com.accenture.accenturetest.infrastructure.dto.franchise.FranchiseDTO;
import com.accenture.accenturetest.infrastructure.dto.product.ProductsByBranchResponseDTO;

import java.util.List;

public interface FranchiseService {
    FranchiseDTO createFranchise(FranchiseDTO dto);

    FranchiseDTO updateFranchiseName(Long id, String newName);

    BranchResponseDTO addBranchToFranchise(Long franchiseId, BranchRequestDTO branchRequest);

    List<ProductsByBranchResponseDTO> getProductsWithMostStockPerBranch(Long franchiseId);
}
