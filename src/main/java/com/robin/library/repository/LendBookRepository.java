package com.robin.library.repository;

import com.robin.library.domain.Book;
import com.robin.library.domain.BookStatus;
import com.robin.library.domain.LendBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LendBookRepository extends JpaRepository<LendBook, Integer> {
	List<LendBook> findByBookIdAndAndUserIdAndLendingEndIsNull(Integer bookId, Integer userId);
}
