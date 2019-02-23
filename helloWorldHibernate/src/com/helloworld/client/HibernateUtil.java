package com.helloworld.client;

import org.hibernate.Session;

import com.helloworld.entity.Message;
import com.helloworld.sessionfactory.HelloWorldSessionFactory;

public class HibernateUtil {

	public static void main(String[] args) {

		// Saving objects
		Session session1 = HelloWorldSessionFactory.getSession();
		session1.beginTransaction();
		Message message = new Message();
		message.setText("Hello Hibernate logging");
		session1.save(message);
		session1.getTransaction().commit();
		System.out.println("Record Inserted Successfully");

		// Finding objects
		Session session2 = HelloWorldSessionFactory.getSession();
		session2.beginTransaction();
		Message getMessageObj = session2.get(Message.class, message.getId());
		session2.getTransaction().commit();
		System.out.println(getMessageObj);

		// Updating objects
		Session session3 = HelloWorldSessionFactory.getSession();
		session3.beginTransaction();
		Message getMessageToUpdateObj = session3.get(Message.class, message.getId());
		getMessageToUpdateObj.setText("Hello Hibernate logg");
		session3.saveOrUpdate(getMessageToUpdateObj);
		session3.getTransaction().commit();
		System.out.println(getMessageToUpdateObj);

		// Deleting objects
		Session session4 = HelloWorldSessionFactory.getSession();
		session4.beginTransaction();
		Message getMessageToDeleteObj = session4.get(Message.class, message.getId());
		session4.delete(getMessageToDeleteObj);
		session4.getTransaction().commit();

	}

}
