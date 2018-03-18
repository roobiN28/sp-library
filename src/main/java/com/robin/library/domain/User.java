package com.robin.library.domain;

import lombok.*;

import java.util.List;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor @ToString
public class User {
	private Integer id;
	private String firstName;
	private String lastName;
	private List<Book> lendedBooks;

}
