package com.accenture.accenturetest.infrastructure.dto.branch;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BranchResponseDTO {
  private Long id;
  private String name;
}
