package com.accenture.accenturetest.config.mappers;

import com.accenture.accenturetest.domain.model.Product;
import com.accenture.accenturetest.infrastructure.dto.product.ProductRequestDTO;
import com.accenture.accenturetest.infrastructure.dto.product.ProductResponseDTO;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

@Configuration
public class ConvertProductFactory {

  @Bean
  public Function<Product, ProductResponseDTO> entityToProductDto(ModelMapper mapper) {
    return dto -> mapper.map(dto, ProductResponseDTO.class);
  }

  @Bean
  public Function<ProductRequestDTO, Product> productDtoToEntity(ModelMapper mapper) {
    return entity -> mapper.map(entity, Product.class);
  }
}
