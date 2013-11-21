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
	
	public List<Book> transliterateBooks(List<Book> list){
		
		for ( int i = 0; i < list.size(); i++){
			if(list.get(i).getLanguage().toLowerCase().equals(Constants.RUSSIAN_LANGUAGE)){
				//TODO ALL
				list.get(i).setAuthor(transliterator.translateIntoRussian(list.get(i).getAuthor()));
				list.get(i).setTitle(transliterator.translateIntoRussian(list.get(i).getTitle()));
				list.get(i).setSeries(transliterator.translateIntoRussian(list.get(i).getSeries()));
				list.get(i).setPublisher(transliterator.translateIntoRussian(list.get(i).getPublisher()));
				list.get(i).setEdition(transliterator.translateIntoRussian(list.get(i).getEdition()));
			}
			System.out.println(list.get(i));
		}
	return list;	
	}
	
}
