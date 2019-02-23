package com.helloworld.sessionfactory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.helloworld.entity.Message;

public class HelloWorldSessionFactory {

	private static SessionFactory sessionFactory = getSessionFactory();
	private static Session session;

	public static SessionFactory getSessionFactory() {
		return new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Message.class)
				.buildSessionFactory();
	}

	public static Session getSession() {
		session = sessionFactory.getCurrentSession(); // It creates a new Session if not exists , else use same session which is in current hibernate context
													  // It automatically configured with both auto-flush and auto-close attributes as true means Session will be automatically flushed and closed.
		return session;
	}

}
