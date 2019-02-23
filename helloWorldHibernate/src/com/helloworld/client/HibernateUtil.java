package com.helloworld.client;

import org.hibernate.Session;

import com.helloworld.entity.Message;
import com.helloworld.sessionfactory.HelloWorldSessionFactory;

public class HibernateUtil {

	public static void main(String[] args) {
		Session session = HelloWorldSessionFactory.getSession();
		session.beginTransaction();
		Message message = new Message();
		message.setText("Hello Hibernate logging");
		session.save(message);
		session.getTransaction().commit();
		System.out.println("Record Inserted Successfully");
	}

}
