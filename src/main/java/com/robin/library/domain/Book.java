package com.robin.library.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String name;
	private String author;

	@Enumerated(EnumType.STRING)
	private BookStatus status;

	@OneToMany(mappedBy = "user")
	private List<LendBook> lendingBook = new ArrayList<>();

	public Book(Integer id, String name, String author) {
		this.status = BookStatus.IN_LIBRARY;
		this.id = id;
		this.name = name;
		this.author = author;
	}

	public Book() {
		this.status = BookStatus.IN_LIBRARY;
	}
}
