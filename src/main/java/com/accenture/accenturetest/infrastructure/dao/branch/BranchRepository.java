package com.accenture.accenturetest.infrastructure.dao.branch;

import com.accenture.accenturetest.domain.model.Branch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BranchRepository extends JpaRepository<Branch, Long> {}
