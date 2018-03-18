package com.robin.library.repository;

import com.robin.library.domain.Book;

import java.util.List;

public interface BookRepository {
	void add(Book book);

	Book get(Integer id);

	void update(Book book);

	Book delete(Integer id);

	List<Book> all();
}
