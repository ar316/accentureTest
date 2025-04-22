package com.accenture.accenturetest.config.mappers;

import com.accenture.accenturetest.domain.model.Franchise;
import com.accenture.accenturetest.infrastructure.dto.franchise.FranchiseDTO;
import lombok.experimental.FieldNameConstants;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

@Configuration
public class ConvertFranchiseFactory {

  @Bean
  public Function<Franchise, FranchiseDTO> entityToFranchiseDTO(ModelMapper mapper) {
    return dto -> mapper.map(dto, FranchiseDTO.class);
  }

  @Bean
  public Function<FranchiseDTO, Franchise> FranchiseDTOtoEntity(ModelMapper mapper) {
    return entity -> mapper.map(entity, Franchise.class);
  }
}
