package com.accenture.accenturetest.domain.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "franquicia")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Franchise {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_frachise")
  private Long id;

  @Column(name = "nombre_frnquicia")
  private String name;

  @OneToMany(mappedBy = "franchise", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Branch> sucursales;
}
