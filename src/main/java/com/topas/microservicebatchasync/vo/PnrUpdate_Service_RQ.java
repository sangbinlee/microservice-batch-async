package com.topas.microservicebatchasync.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PnrUpdate_Service_RQ {
	private String threadName;
	private long threadId;
	private long seq;
}
