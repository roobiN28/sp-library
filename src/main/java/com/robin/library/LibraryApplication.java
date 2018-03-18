package com.robin.library;

import com.robin.library.domain.Book;
import com.robin.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LibraryApplication implements CommandLineRunner {
	@Autowired
	private BookService bookService;

	public static void main(String[] args) {
		SpringApplication.run(LibraryApplication.class, args);
	}


	@Override
	public void run(String... strings) {
		bookService.add(new Book(1, "Harry Potter", "J.R.R. Rowling"));
		bookService.add(new Book(2, "Wiedźmin", "Andrzej Sapkowski"));
		Book book = bookService.get(1).get();
		System.out.println(book.getName() + " " + book.getAuthor());
		bookService.delete(new Book(1, "Harry Potter", "J.R.R. Rowling"));
	}
}