package com.accenture.accenturetest.infrastructure.dao.product;

import com.accenture.accenturetest.domain.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository  extends JpaRepository<Product, Long> {
    @Query("select p from Product p where p.branch.id = ?1")
    List<Product> findByBranch_Id(Long id); }
