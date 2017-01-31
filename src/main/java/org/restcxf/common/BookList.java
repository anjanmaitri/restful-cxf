package org.restcxf.common;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="BookList")
public class BookList implements Serializable {
	private static final long serialVersionUID = 1L;
	private List<Book> bookList;
	public List<Book> getBookList() {
		return bookList;
	}
	public void setBookList(List<Book> bookList) {
		this.bookList = bookList;
	}
}
