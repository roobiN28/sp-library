package com.robin.library.repository;

import com.robin.library.domain.Book;
import com.robin.library.domain.LendBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LendBookRepository extends JpaRepository<LendBook, Integer> {
	List<LendBook> findByBookIdAndAndUserIdAndLendingEndIsNull(Integer bookId, Integer userId);

	@Query("select count(id) from LendBook where lendingEnd is null")
	Integer countLendedBooks();

	@Query("select count(*) from Book as b left join LendBook as lb on b.id = lb.book.id  where lb.lendingStart is null or (lb.lendingStart is not null and lb.lendingEnd is not null)")
	Integer countNotLendedBooks();
}
