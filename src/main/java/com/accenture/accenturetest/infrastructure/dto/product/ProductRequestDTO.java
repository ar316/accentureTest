package com.accenture.accenturetest.infrastructure.dto.product;


import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class ProductRequestDTO {
    @NotNull
    private String name;
    @Min(0)
    @Max(1000)
    private int stock;
}
