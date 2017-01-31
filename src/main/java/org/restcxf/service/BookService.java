package org.restcxf.service;

import java.util.HashMap;
import java.util.Map;


import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.restcxf.common.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/bookservice")
public class BookService {
	protected final Logger logger = LoggerFactory.getLogger(BookService.class);
	private Map<String, Book> bookMap = new HashMap<>(); 
	
	@GET
	@Path("/getbook/{name}")
	@Produces({"application/xml","application/json"})
	@Consumes({"application/xml","application/json","application/x-www-form-urlencoded"})
	public Response getBook(@PathParam("name") String name) {
		logger.debug("book name:" + name);
		Book book = bookMap.get(name);
		if(book == null) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		} else {
			return Response.ok(book).build();
		}
	}
	
	@POST
	@Path("/addbook")
	@Produces({"application/xml","application/json"})
	@Consumes({"application/xml","application/json","application/x-www-form-urlencoded"})
	public Response addBook(@FormParam("name") String bookName,
							@FormParam("autuor") String author) {
		logger.debug("Adding book");
		Book book = new Book();
		book.setBookName(bookName);
		book.setAuthor(author);
		if(bookMap.get(bookName) == null) {
			bookMap.put(bookName, book);
		}
		
		return Response.ok(book).build();
	}
	

}
