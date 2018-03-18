package com.robin.library.controller;

import com.robin.library.domain.Book;
import com.robin.library.service.BookService;
import com.robin.library.service.BookServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("book")
public class BookController {

	private BookService bookService = new BookServiceImpl();

	@RequestMapping(value = "add", method = RequestMethod.POST)
	void all(@RequestBody Book book) {
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

	@RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
	Book delete(@PathVariable Integer id) {
		return bookService.delete(id);
	}
}
