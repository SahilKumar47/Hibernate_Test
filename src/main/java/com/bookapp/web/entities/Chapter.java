package com.bookapp.web.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Chapter {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String title;
	private Integer chapterNumber;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "book_fk")
	private Book book;

	public Chapter() {

	}

	public Chapter(String title, Integer chapterNumber) {
		this.title = title;
		this.chapterNumber = chapterNumber;
	}

	public Chapter(Integer id, String title, Integer chapterNumber) {
		this.id = id;
		this.title = title;
		this.chapterNumber = chapterNumber;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getChapterNumber() {
		return chapterNumber;
	}

	public void setChapterNumber(Integer chapterNumber) {
		this.chapterNumber = chapterNumber;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Chapter [id=");
		builder.append(id);
		builder.append(", title=");
		builder.append(title);
		builder.append(", chapterNumber=");
		builder.append(chapterNumber);
		builder.append("]");
		return builder.toString();
	}

}
