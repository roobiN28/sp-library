package com.robin.library;

import com.robin.library.domain.Book;
import com.robin.library.service.BookService;
import com.robin.library.service.BookServiceImpl;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class LibraryApplication implements CommandLineRunner {
	public static void main(String[] args) {
		SpringApplication.run(LibraryApplication.class, args);
	}



	@Override
	public void run(String... strings) {
		BookService bookService = new BookServiceImpl();

		bookService.add(new Book(1,"Harry Potter", "J.R.R. Rowling"));
		bookService.add(new Book(2,"Wiedźmin", "Andrzej Sapkowski"));
		Book book = bookService.get(1);
		System.out.println(book.getName() + " " + book.getAuthor());
	}
}