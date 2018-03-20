package com.robin.library.service;

import com.robin.library.domain.Book;
import com.robin.library.domain.User;

public interface LibraryService {
	void lendBook(User user, Book book);
	void giveBackBook(User user, Book book);
	Integer lendedBooksCount();
	Integer booksInLibraryCount();
}
