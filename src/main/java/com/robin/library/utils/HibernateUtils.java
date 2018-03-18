package com.robin.library.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
	private static SessionFactory factory;
	public HibernateUtils() {
		if(factory == null) {
			factory = new Configuration().configure().buildSessionFactory();
		}
	}

	public static SessionFactory getSessionFactory() {
		return factory;
	}
}
