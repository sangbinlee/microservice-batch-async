package com.topas.microservicebatchasync.vo;

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
	private Date c_date;
	private Timestamp timestamp;
}
