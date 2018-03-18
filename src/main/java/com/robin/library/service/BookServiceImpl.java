package com.robin.library.service;

import com.robin.library.domain.Book;
import com.robin.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
	@Autowired
	private BookRepository bookRepository;

	@Override
	public void add(Book book) {
		bookRepository.save(book);
	}

	@Override
	public Optional<Book> get(Integer id) {
		return bookRepository.findById(id);
	}

	@Override
	public void update(Book book) {
		bookRepository.save(book);
	}

	@Override
	public void delete(Book book) {
		bookRepository.delete(book);
	}

	@Override
	public List<Book> all() {
		return bookRepository.findAll();
	}
}
