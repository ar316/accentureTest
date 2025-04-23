package com.accenture.accenturetest.aplication.franchise.impl;

import com.accenture.accenturetest.aplication.franchise.FranchiseService;
import com.accenture.accenturetest.domain.model.Branch;
import com.accenture.accenturetest.domain.model.Franchise;
import com.accenture.accenturetest.infrastructure.dao.branch.BranchDao;
import com.accenture.accenturetest.infrastructure.dao.franchise.FranchiseDao;
import com.accenture.accenturetest.infrastructure.dto.branch.BranchRequestDTO;
import com.accenture.accenturetest.infrastructure.dto.branch.BranchResponseDTO;
import com.accenture.accenturetest.infrastructure.dto.franchise.FranchiseDTO;

import java.util.function.Function;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FranchiseServiceimpl implements FranchiseService {

  private final FranchiseDao franchiseDao;
  private final BranchDao branchDao;
  private final Function<FranchiseDTO, Franchise> franchiseDTOToEntity;
  private final Function<Franchise, FranchiseDTO> entityToFranchiseDTO;
  private final Function<Branch, BranchResponseDTO> entityToBranchDTO;

  @Override
  public FranchiseDTO createFranchise(FranchiseDTO dto) {
    Franchise franchise = franchiseDTOToEntity.apply(dto);
    return entityToFranchiseDTO.apply(franchiseDao.save(franchise));
  }

  @Override
  public FranchiseDTO updateFranchiseName(Long id, String newName) {
    Franchise franchise = franchiseDao.findById(id);

    franchise.setName(newName);
    franchise.getId();
    return entityToFranchiseDTO.apply(franchiseDao.save(franchise));
  }

  @Override
  public BranchResponseDTO addBranchToFranchise(Long franchiseId, BranchRequestDTO branchRequest) {
    Franchise franchise = franchiseDao.findById(franchiseId);

    Branch response =
        branchDao.save(Branch.builder().name(branchRequest.getName()).franchise(franchise).build());

    return entityToBranchDTO.apply(response);
  }
}
