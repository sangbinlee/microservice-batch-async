package com.topas.microservicebatchasync.vo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
//@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Customer extends AuditModel{

	// "customer_seq" is Oracle sequence name.
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CUST_SEQ")
    @SequenceGenerator(sequenceName = "customer_seq", allocationSize = 1, name = "CUST_SEQ")
    Long id;
	
    String name;

    @Column(unique = true, nullable = false)
	String email;

    @Column(name = "CREATED_DATE")
    Date date;

    //getters and setters, contructors
}
