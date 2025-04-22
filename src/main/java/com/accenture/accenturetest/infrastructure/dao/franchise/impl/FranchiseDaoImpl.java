package com.accenture.accenturetest.infrastructure.dao.franchise.impl;

import com.accenture.accenturetest.config.ex.FranchiseNotFoundEx;
import com.accenture.accenturetest.domain.model.Franchise;
import com.accenture.accenturetest.infrastructure.dao.franchise.FranchiseDao;
import com.accenture.accenturetest.infrastructure.dao.franchise.FranchiseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class FranchiseDaoImpl implements FranchiseDao {

  private final FranchiseRepository franchiseRepository;

  @Override
  public Franchise save(Franchise franchise) {
    return franchiseRepository.save(franchise);
  }

  @Override
  public Franchise findById(Long id) {
    return franchiseRepository
        .findById(id)
        .orElseThrow(() -> new FranchiseNotFoundEx("Franchise not found with id: " + id));
  }
}
