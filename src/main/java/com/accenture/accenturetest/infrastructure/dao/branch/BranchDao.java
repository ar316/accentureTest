package com.accenture.accenturetest.infrastructure.dao.branch;

import com.accenture.accenturetest.domain.model.Branch;

import java.util.Optional;

public interface BranchDao {
  Optional<Branch> findById(Long branchId);

  Branch save(Branch branch);
}
