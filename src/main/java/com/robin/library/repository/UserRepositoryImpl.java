package com.robin.library.repository;

import com.robin.library.domain.Book;
import com.robin.library.domain.User;
import com.robin.library.utils.HibernateUtils;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class UserRepositoryImpl implements UserRepository {
	private SessionFactory factory = new HibernateUtils().getSessionFactory();

	@Override
	public void add(User user) {
		Session session = factory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.save(user);
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
	public User get(Integer id) {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		User user = session.get(User.class, id);
		transaction.commit();
		session.close();
		return user;
	}

	@Override
	public void update(User user) {
		Session session = factory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.update(user);
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
	public User delete(Integer id) {
		return null;
	}

	@Override
	public List<User> all() {
		Session session = factory.openSession();
		List users = session.createQuery("from User").list();
		session.close();
		return users;
	}
}
