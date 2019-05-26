package com.topas.microservicebatchasync.jpa.oracle.domain;

import java.sql.Timestamp;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Q {
	private long qId;
	private long qName;
	private double price;
	private String code;
	private String name;
	private Date c_date;
	private Timestamp timestamp;
}
