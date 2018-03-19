package com.robin.library.controller;

import com.robin.library.domain.Book;
import com.robin.library.domain.User;
import com.robin.library.service.BookService;
import com.robin.library.service.LibraryService;
import com.robin.library.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("library")
public class LibraryController {
	@Autowired
	LibraryService libraryService;

	@Autowired
	BookService bookService;

	@Autowired
	UserService userService;

	@RequestMapping(value = "lend", method = RequestMethod.POST)
	void lend(@RequestParam Integer bookId, @RequestParam Integer userId) {
		Optional<User> user = userService.get(userId);
		Optional<Book> book = bookService.get(bookId);

		libraryService.lendBook(user.get(), book.get());
	}

	@RequestMapping(value = "giveback", method = RequestMethod.POST)
	void giveBack(@RequestParam Integer bookId, @RequestParam Integer userId) {
		Optional<User> user = userService.get(userId);
		Optional<Book> book = bookService.get(bookId);

		libraryService.giveBackBook(user.get(), book.get());
	}

	@RequestMapping(value = "lended", method = RequestMethod.GET)
	Integer lendedBookCount() {
		return libraryService.lendedBookCount();
	}

	@RequestMapping(value = "books", method = RequestMethod.GET)
	Integer bookInLibrary() {
		return libraryService.booksInLibraryCount();
	}
}
