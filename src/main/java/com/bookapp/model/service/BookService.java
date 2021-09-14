package com.bookapp.model.service;

import com.bookapp.web.entities.Book;

public interface BookService {
	void persistObjectGraph(Book book);

	Book retrieveObjectGraph(String isbn);
}
