package com.accenture.accenturetest.infrastructure.dto.product;


import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class ProductsByBranchResponseDTO {

    private String branchName;
    private List<ProductResponseDTO> products;

}
