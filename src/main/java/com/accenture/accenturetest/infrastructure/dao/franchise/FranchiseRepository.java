package com.accenture.accenturetest.infrastructure.dao.franchise;

import com.accenture.accenturetest.domain.model.Franchise;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FranchiseRepository extends JpaRepository<Franchise, Long> {}
