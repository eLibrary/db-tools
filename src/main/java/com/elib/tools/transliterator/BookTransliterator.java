package com.elib.tools.transliterator;

import java.util.List;

import com.elib.entity.Book;
import com.elib.tools.util.Constants;

/**
 * @author Mykhaylo Fedyna
 * 
 */
public class BookTransliterator {
	
	private Transliterator transliterator = new Transliterator();
	
	public List<Book> transliterateBooks(List<Book> books){
	  for (Book book: books){
	    if (book.getLanguage().equalsIgnoreCase(Constants.RUSSIAN_LANGUAGE)){
	      book.setAuthor(transliterator.translateIntoRussian(book.getAuthor()));
	      book.setTitle(transliterator.translateIntoRussian(book.getTitle()));
	      book.setSeries(transliterator.translateIntoRussian(book.getSeries()));
	      book.setPublisher(transliterator.translateIntoRussian(book.getPublisher()));
	      book.setEdition(transliterator.translateIntoRussian(book.getEdition()));   
	    }
	    book.setSearchString(createSearchString(book));
	    System.out.println(book);
	  }
	return books;	
	}
	
	private String createSearchString(Book book){
	  StringBuilder searchString = new StringBuilder();
	  searchString.append(book.getTitle());
	  searchString.append(book.getAuthor());
	  searchString.append(book.getSeries());
	  searchString.append(book.getEdition());
	  searchString.append(book.getPublisher());
	  searchString.append(book.getYear());
	  searchString.append(book.getIdentifier());
	  return searchString.toString();
	}
	
}
