package com.bookapp.model.dao;

import com.bookapp.web.entities.Book;

public interface BookDao {
	void persistObjectGraph(Book book);

	Book retrieveObjectGraph(String isbn);
}
