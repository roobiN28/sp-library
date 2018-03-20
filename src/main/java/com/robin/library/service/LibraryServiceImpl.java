package com.robin.library.service;

import com.robin.library.domain.Book;
import com.robin.library.domain.BookStatus;
import com.robin.library.domain.LendBook;
import com.robin.library.domain.User;
import com.robin.library.repository.BookRepository;
import com.robin.library.repository.LendBookRepository;
import com.robin.library.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class LibraryServiceImpl implements LibraryService {
	private static final int MAX_LENDING_DAYS = 14;
	private static final int PENALTY_COST = 20;
	@Autowired
	private LendBookRepository lendBookRepository;
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BookRepository bookRepository;

	@Override
	public void lendBook(User user, Book book) {
		LendBook lendBook = new LendBook();
		lendBook.setUser(user);
		lendBook.setBook(book);
		lendBook.setLendingStart(LocalDate.now());
		book.setStatus(BookStatus.LENDED);
		bookRepository.save(book);
		lendBookRepository.save(lendBook);
	}

	@Override
	public void giveBackBook(User user, Book book) {
		LendBook lendedBook = lendBookRepository.findByBookIdAndAndUserIdAndLendingEndIsNull(book.getId(), user.getId()).get(0);
		lendedBook.setLendingEnd(LocalDate.now().plusDays(2)); // only for simulate

		if (lendedBook.getLendingStart().plusDays(MAX_LENDING_DAYS).isBefore(lendedBook.getLendingEnd())) {
			user.increaseDebtBy(PENALTY_COST);
			userRepository.save(user);
		}
		book.setStatus(BookStatus.IN_LIBRARY);
		bookRepository.save(book);
		lendBookRepository.save(lendedBook);
	}

	@Override
	public Integer lendedBooksCount() {
		return bookRepository.countByStatus(BookStatus.LENDED);
	}

	@Override
	public Integer booksInLibraryCount() {
		return bookRepository.countByStatus(BookStatus.IN_LIBRARY);
	}
}
