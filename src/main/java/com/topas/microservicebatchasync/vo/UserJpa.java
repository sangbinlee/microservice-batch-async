package com.topas.microservicebatchasync.vo;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
//@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class UserJpa extends AuditModel {
//    @Id
//    @GeneratedValue(strategy=GenerationType.AUTO)
//    private Integer id;

	private String name;

	private String email;

}
