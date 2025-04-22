package com.accenture.accenturetest.infrastructure.dto.franchise;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Builder
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FranchiseDTO {

  @NotBlank(message = "El nombre de la franquicia es obligatorio.")
  private String name;
}
