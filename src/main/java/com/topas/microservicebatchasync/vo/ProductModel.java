package com.topas.microservicebatchasync.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.EqualsAndHashCode;
@Entity
@Data
//@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ProductModel extends AuditModel{

	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private int id;

	 @Column(nullable = false)
	 private String code;
	 private String name;
	 private double price;

}
