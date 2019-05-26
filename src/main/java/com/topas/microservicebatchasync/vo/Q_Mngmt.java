package com.topas.microservicebatchasync.vo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
//@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Q_Mngmt extends AuditModel{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Q_SEQ")
    @SequenceGenerator(sequenceName = "q_mngmt_seq", allocationSize = 1, name = "Q_SEQ")
	private Integer id;
	private String name;
	private String email;
}
