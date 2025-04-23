package com.accenture.accenturetest.infrastructure.dao.branch.impl;

import com.accenture.accenturetest.config.ex.BranchNotFoundException;
import com.accenture.accenturetest.domain.model.Branch;
import com.accenture.accenturetest.infrastructure.dao.branch.BranchDao;
import com.accenture.accenturetest.infrastructure.dao.branch.BranchRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class BranchDaoImpl implements BranchDao {

  private final BranchRepository branchRepository;

  @Override
  public Optional<Branch> findById(Long branchId) {
    return branchRepository
        .findById(branchId);
  }

  @Override
  public Branch save(Branch branch) {
    return branchRepository.save(branch);
  }
}
