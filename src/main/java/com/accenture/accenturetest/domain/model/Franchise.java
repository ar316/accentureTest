package com.accenture.accenturetest.domain.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "franquicia")
public class Franchise {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long idFranchise;

  @Column(name = "nombre_frnquicia")
  private String name;

  @OneToMany(mappedBy = "franchise", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Branch> sucursales;
}
