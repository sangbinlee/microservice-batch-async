package com.topas.microservicebatchasync.vo;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
//@Entity
@Data
//@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class City extends AuditModel{

	  private Long id;
	  private String name;
	  private String state;
	  private String country;

}
