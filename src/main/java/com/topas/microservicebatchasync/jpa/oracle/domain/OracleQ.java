package com.topas.microservicebatchasync.jpa.oracle.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "ORACLE_Q")
@AllArgsConstructor
@NoArgsConstructor
public class OracleQ {
  
  @Id
  @GeneratedValue
  @Column(name = "ID")
  private Long id;
  
  @Column(name = "NAME")
  private String name;
  
}