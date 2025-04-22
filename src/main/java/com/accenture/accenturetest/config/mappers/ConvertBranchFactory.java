package com.accenture.accenturetest.config.mappers;

import com.accenture.accenturetest.domain.model.Branch;
import com.accenture.accenturetest.infrastructure.dto.branch.BranchRequestDTO;
import com.accenture.accenturetest.infrastructure.dto.branch.BranchResponseDTO;
import java.util.function.Function;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConvertBranchFactory {

  @Bean
  public Function<Branch, BranchResponseDTO> entityToBranchResponseDTO(ModelMapper mapper) {
    return dto -> mapper.map(dto, BranchResponseDTO.class);
  }

  @Bean
  public Function<BranchRequestDTO, Branch> branchRequestDTOtoEntity(ModelMapper mapper) {
    return entity -> mapper.map(entity, Branch.class);
  }
}
