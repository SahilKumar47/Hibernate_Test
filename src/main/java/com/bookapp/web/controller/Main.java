package com.bookapp.web.controller;

import java.util.ArrayList;
import java.util.List;

import com.bookapp.model.service.BookService;
import com.bookapp.model.service.BookServiceImpl;
import com.bookapp.web.entities.Book;
import com.bookapp.web.entities.Chapter;
import com.bookapp.web.entities.Publisher;

public class Main {
	public static void main(String[] args) {
		BookService bookService = new BookServiceImpl();
		Publisher publisher = new Publisher("MANN", "Manning Publications Co.");
		Book book = new Book("9781617290459", "Java Persistence with Hibernate, Second Edition");
		book.setPublisher(publisher);
		List<Chapter> chapters = new ArrayList<Chapter>();
		Chapter chapter1 = new Chapter("Introducing JPA and Hibernate", 1);
		chapters.add(chapter1);
		Chapter chapter2 = new Chapter("Domain Models and Metadata", 2);
		chapters.add(chapter2);
		book.setChapters(chapters);

		//persisting into the tables
		bookService.persistObjectGraph(book);
		
		//fetching records
		Book book1 = bookService.retrieveObjectGraph("9781617290459");
		System.out.println(book);
		System.out.println(book.getPublisher());
		
		
	}
}
