package com.topas.microservicebatchasync.vo;

import java.util.Date;

import lombok.Data;

@Data
public class Board {
	private long id;
	private String writer;
	private String title;
	private String content;
	private Date regDate;
	private long hitCount;
}