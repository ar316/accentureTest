package com.accenture.accenturetest.domain.model;

import jakarta.persistence.*;

@Entity
@Table(name = "franquicia")
public class Franchise {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long idFranchise;

  @Column(name = "nombre_frnquicia")
  private String name;
}
