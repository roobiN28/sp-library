package com.robin.library;

import com.robin.library.domain.Book;
import com.robin.library.domain.BookStatus;
import com.robin.library.repository.BookRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LibraryApplicationTests {

	@Autowired
	BookRepository bookRepository;

	@Test
	public void contextLoads() {
		Book book =  new Book(1,"book_name", "book_author");
		bookRepository.save(book);
		book = bookRepository.getOne(1);
		assert book.getId().equals(1);
		assert book.getName().equals("book_name");
		assert book.getAuthor().equals("book_author");
		assert book.getStatus().equals(BookStatus.IN_LIBRARY);
	}

}
