package com.accenture.accenturetest.domain.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "sucursal")
public class Branch {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long idBranch;

  @Column(name = "nombre_sucursal")
  private String name;

  @ManyToOne
  @JoinColumn(name = "franquicia_id")
  private Franchise franchise;

  @OneToMany(mappedBy = "branch", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Product> products;


}
