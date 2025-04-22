package com.accenture.accenturetest.infrastructure.dto.branch;

import com.accenture.accenturetest.infrastructure.dto.product.ProductSummaryDTO;

import java.util.List;

public class BranchResponseDTO {
    private Long id;
    private String name;
    private List<ProductSummaryDTO> products;
}
