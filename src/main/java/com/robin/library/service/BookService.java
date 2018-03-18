package com.robin.library.service;

import com.robin.library.domain.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {
	void add(Book book);

	Optional<Book> get(Integer id);

	void update(Book book);

	void delete(Book book);

	List<Book> all();
}
