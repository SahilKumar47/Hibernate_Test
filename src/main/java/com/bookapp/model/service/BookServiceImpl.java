package com.bookapp.model.service;

import com.bookapp.model.dao.BookDao;
import com.bookapp.model.dao.BookDaoImpl;
import com.bookapp.web.entities.Book;

public class BookServiceImpl  implements BookService{

	private BookDao bookdao = new BookDaoImpl();
	
	@Override
	public void persistObjectGraph(Book book) {
		bookdao.persistObjectGraph(book);
	}

	@Override
	public Book retrieveObjectGraph(String isbn) {
		return bookdao.retrieveObjectGraph(isbn);
	}

}
