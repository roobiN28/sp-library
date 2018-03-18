package com.robin.library.domain;

import lombok.*;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor @ToString
public class Book {
	private Integer id;
	private String name;
	private String author;
}
