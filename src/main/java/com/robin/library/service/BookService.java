package com.robin.library.service;

import com.robin.library.domain.Book;

import java.util.List;

public interface BookService {
	void add(Book book);

	Book get(Integer id);

	void update(Book book);

	Book delete(Integer id);

	List<Book> all();
}
