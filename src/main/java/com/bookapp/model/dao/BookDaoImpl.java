package com.bookapp.model.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.bookapp.model.dao.factory.HibernateSessionFactory;
import com.bookapp.web.entities.Book;
import com.bookapp.web.entities.Chapter;
import com.bookapp.web.entities.Publisher;

public class BookDaoImpl implements BookDao {

	private SessionFactory factory;

	public BookDaoImpl() {
		factory = HibernateSessionFactory.getSessionFactory();
	}

	public Session getSession() {
		return factory.openSession();
	}

	@Override
	public void persistObjectGraph(Book book) {
		Session session = getSession();
		Transaction tx = session.getTransaction();

		List<Chapter> chapters = book.getChapters();
		Publisher publisher = book.getPublisher();
		try {
			tx.begin();
			session.save(book);
			for (Chapter chapter : chapters) {
				session.save(chapter);
			}
			session.save(publisher);
			tx.commit();
		} catch (HibernateException e) {
			System.out.println("Some internal error occured");
			e.printStackTrace();
			tx.rollback();
		} finally {
			if (session != null) {
				session.close();
			}
		}

	}

	@Override
	public Book retrieveObjectGraph(String isbn) {
		Session session = getSession();
		Transaction tx = session.getTransaction();
		Book book = null;
		try {
			tx.begin();
			String hql = "select b from Book b where b.isbn= :isbn";
			Query query = session.createQuery(hql);
			query.setParameter("isbn", isbn);
			List<Book> bookList = query.getResultList();
			for (Book b : bookList) {
				book = b;
			}
			Publisher publisher = book.getPublisher();
			List<Chapter> chapter = book.getChapters();
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return book;
	}

}
