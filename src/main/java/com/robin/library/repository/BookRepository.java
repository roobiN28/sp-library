package com.robin.library.repository;

import com.robin.library.domain.Book;
import com.robin.library.domain.BookStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
	Integer countByStatus(BookStatus status);
}
