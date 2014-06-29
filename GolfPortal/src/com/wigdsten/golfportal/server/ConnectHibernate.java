package com.wigdsten.golfportal.server;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.classic.Session;

import com.wigdsten.golfportal.client.TestInfoDTO;

public class ConnectHibernate {

	public void storeData(TestInfoDTO testInfoDTO) {
		TestInfo contact = new TestInfo(testInfoDTO);

		SessionFactory sessionFactory = new AnnotationConfiguration()
				.configure().buildSessionFactory();

		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(contact);

		session.getTransaction().commit();
		session.close();
		sessionFactory.close();

	}
}
