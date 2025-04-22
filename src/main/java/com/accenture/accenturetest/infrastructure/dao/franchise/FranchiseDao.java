package com.accenture.accenturetest.infrastructure.dao.franchise;

import com.accenture.accenturetest.domain.model.Franchise;

public interface FranchiseDao {
    Franchise save(Franchise franchise);

    Franchise findById(Long id);
}
