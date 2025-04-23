package com.accenture.accenturetest.infrastructure.dto.product;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class ProductResponseDTO {
  private Long id;
  private String name;
  private int stock;
}
