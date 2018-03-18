package com.robin.library.repository;

import com.robin.library.domain.Book;
import com.robin.library.utils.HibernateUtils;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class BookRepositoryImpl implements BookRepository {
	private SessionFactory factory = new HibernateUtils().getSessionFactory();

	@Override
	public void add(Book book) {
		Session session = factory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.save(book);
			transaction.commit();
			session.close();
		} catch (HibernateException e) {
			if (transaction != null) transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	@Override
	public Book get(Integer id) {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		Book book = session.get(Book.class, id);
		transaction.commit();
		session.close();
		return book;
	}

	@Override
	public void update(Book book) {
		Session session = factory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.update(book);
			transaction.commit();
			session.close();
		} catch (HibernateException e) {
			if (transaction != null) transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	@Override
	public Book delete(Integer id) {
		Book book = null;
		Session session = factory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			book = session.get(Book.class, id);
			if(book != null) {
				session.delete(book);
			}
			transaction.commit();
			session.close();
		} catch (HibernateException e) {
			if (transaction != null) transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return book;
	}

	@Override
	public List<Book> all() {
		Session session = factory.openSession();
		List books = session.createQuery("from Book").list();
		session.close();
		return books;
	}
}
