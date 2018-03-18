package com.robin.library.service;

import com.robin.library.domain.Book;
import com.robin.library.repository.BookRepository;
import com.robin.library.repository.BookRepositoryImpl;

import java.util.List;

public class BookServiceImpl implements BookService {
	private BookRepository bookRepository = new BookRepositoryImpl();
	@Override
	public void add(Book book) {
		bookRepository.add(book);
	}

	@Override
	public Book get(Integer id) {
		return bookRepository.get(id);
	}

	@Override
	public void update(Book book) {
		bookRepository.update(book);
	}

	@Override
	public Book delete(Integer id) {
		return bookRepository.delete(id);
	}

	@Override
	public List<Book> all() {
		return bookRepository.all();
	}
}
