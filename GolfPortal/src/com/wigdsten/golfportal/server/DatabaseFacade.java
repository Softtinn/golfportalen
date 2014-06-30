package com.wigdsten.golfportal.server;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.classic.Session;

import com.wigdsten.golfportal.server.entities.TestInfo;

@SuppressWarnings("deprecation")
public class DatabaseFacade {

	private SessionFactory sessionFactory;
	private Session session;

	public void openSession() {
		if (this.sessionFactory == null) {
			this.sessionFactory = new AnnotationConfiguration().configure()
					.buildSessionFactory();
		}
		if (this.session == null) {
			this.session = this.sessionFactory.openSession();
		}
	}

	public void beginTransaction() {
		if (this.session != null) {
			this.session.beginTransaction();
		}
	}

	public void commitTransaction() {
		if ((this.session != null) && this.session.getTransaction().isActive()) {
			this.session.getTransaction().commit();
		}
	}

	public void closeSession() {
		if ((this.session != null) && this.session.isOpen()) {
			this.session.close();
			this.session = null;
		}
		if ((this.sessionFactory != null) && !this.sessionFactory.isClosed()) {
			this.sessionFactory.close();
			this.sessionFactory = null;
		}
	}

	public void storeData(TestInfo testInfo) {

		openSession();
		beginTransaction();

		this.session.save(testInfo);

		commitTransaction();
		closeSession();

	}
}
