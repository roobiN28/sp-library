package com.robin.library.controller;

import com.robin.library.domain.Book;
import com.robin.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("book")
public class BookController {

	@Autowired
	private BookService bookService;

	@RequestMapping(value = "add", method = RequestMethod.POST)
	void add(@RequestBody Book book) {
		bookService.add(book);
	}

	@RequestMapping(value = "update", method = RequestMethod.PUT)
	void update(@RequestBody Book book) {
		bookService.update(book);
	}

	@RequestMapping(value = "all", method = RequestMethod.GET)
	List<Book> all() {
		return bookService.all();
	}

	@RequestMapping(value = "get/{id}", method = RequestMethod.GET)
	Book get(@PathVariable Integer id) {
		return bookService.get(id).get();
	}

	@RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
	void delete(@PathVariable Integer id) {
		Optional<Book> book = bookService.get(id);
		if (book.isPresent()) {
			bookService.delete(book.get());
		}
	}
}
