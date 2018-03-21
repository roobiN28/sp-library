package com.robin.library;

import com.robin.library.domain.Book;
import com.robin.library.domain.LendBook;
import com.robin.library.domain.User;
import com.robin.library.service.BookService;
import com.robin.library.service.LibraryService;
import com.robin.library.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.time.LocalDate;

@SpringBootApplication
public class LibraryApplication {
	@Autowired
	private BookService bookService;

	@Autowired
	private UserService userService;

	@Autowired
	private LibraryService libraryService;

	public static void main(String[] args) {
		SpringApplication.run(LibraryApplication.class, args);
	}

	@PostConstruct
	public void init(){
		// init some sample data to database
		bookService.add(new Book(1, "Harry Potter", "J.R.R. Rowling"));
		Book witcher = new Book(2, "Wiedźmin", "Andrzej Sapkowski");
		User user = new User("Ala", "Kowalska");
		bookService.add(witcher);
		userService.add(user);
		libraryService.lendBook(user, witcher);
		Book book = bookService.get(1).get();
		System.out.println(book.getName() + " " + book.getAuthor());
	}
}