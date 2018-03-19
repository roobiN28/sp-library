package com.robin.library.service;

import com.robin.library.domain.Book;
import com.robin.library.domain.LendBook;
import com.robin.library.domain.User;
import com.robin.library.repository.LendBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class LibraryServiceImpl implements LibraryService {
	@Autowired
	private LendBookRepository lendBookRepository;

	@Override
	public void lendBook(User user, Book book) {
		LendBook lendBook = new LendBook();
		lendBook.setUser(user);
		lendBook.setBook(book);
		lendBook.setLendingStart(LocalDate.now());
		lendBookRepository.save(lendBook);
	}

	@Override
	public void giveBackBook(User user, Book book) {
		LendBook lendedBook = lendBookRepository.findByBookIdAndAndUserIdAndLendingEndIsNull(book.getId(), user.getId()).get(0);
		lendedBook.setLendingEnd(LocalDate.now().plusDays(2));
		lendBookRepository.save(lendedBook);
	}

	@Override
	public Integer lendedBookCount() {
		return lendBookRepository.countLendedBooks();
	}

	@Override
	public Integer booksInLibraryCount() {
		return lendBookRepository.countNotLendedBooks();
	}
}
