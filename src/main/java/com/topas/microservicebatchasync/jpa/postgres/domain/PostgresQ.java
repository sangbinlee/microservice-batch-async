package com.topas.microservicebatchasync.jpa.postgres.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "POSTGRES_Q")
@AllArgsConstructor
@NoArgsConstructor
public class PostgresQ {
  
  @Id
  @GeneratedValue
  @Column(name = "ID")
  private Long id;
  
  @Column(name = "NAME")
  private String name;
  
}