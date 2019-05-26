package com.topas.microservicebatchasync.jpa.postgres.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import com.topas.microservicebatchasync.vo.AuditModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Pnr extends AuditModel {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PNR_SEQ")
	@SequenceGenerator(sequenceName = "pnr_seq", allocationSize = 1, name = "PNR_SEQ")

	private int id;

	@Column(nullable = false)
	private String code;
	private String name;
	private double price;

}
