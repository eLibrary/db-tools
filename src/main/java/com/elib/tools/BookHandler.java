package com.elib.tools;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.elib.entity.Book;
import com.elib.tools.parser.BookParser;
import com.elib.tools.transliterator.BookTransliterator;
import com.elib.tools.util.Constants;

public class BookHandler {

  private BookParser parser = new BookParser();
  private BookTransliterator transliterator = new BookTransliterator();

  public List<Book> processBooks(List<File> files) {
    List<Book> books = new ArrayList<Book>();
    for (File file : files) {
      Book book = parser.parseFileName(file.getName());
      book.setTimeAdded(new Date());
      book.setAbsolutePath(file.getAbsolutePath());
      book.setFilename(file.getName());
      book.setFilesize(file.getTotalSpace());
      book.setMd5(calculateChecksumMD5(file));
      book.setDownloadUrl(Constants.ELIBRARY_HOST + file.getPath());
      if (book.getLanguage().equalsIgnoreCase(Constants.RUSSIAN_LANGUAGE)) {
        book.setAuthor(transliterator.translateIntoRussian(book.getAuthor()));
        book.setTitle(transliterator.translateIntoRussian(book.getTitle()));
        book.setSeries(transliterator.translateIntoRussian(book.getSeries()));
        book.setPublisher(transliterator.translateIntoRussian(book.getPublisher()));
        book.setEdition(transliterator.translateIntoRussian(book.getEdition()));
      }
      book.setSearchString(createSearchString(book));
      books.add(book);
    }
    return books;
  }

  private String calculateChecksumMD5(File file) {
    String checksum = "";
    try {
      FileInputStream fis = new FileInputStream(file);
      byte[] buffer = new byte[1024];
      MessageDigest complete = MessageDigest.getInstance("MD5");
      int numRead;
      do {
        numRead = fis.read(buffer);
        if (numRead > 0) {
          complete.update(buffer, 0, numRead);
        }
      } while (numRead != -1);
      fis.close();
      byte[] bf = complete.digest();
      for (int i = 0; i < bf.length; i++) {
        checksum += Integer.toString((bf[i] & 0xff) + 0x100, 16).substring(1);
      }
    } catch (IOException | NoSuchAlgorithmException e) {
      e.printStackTrace();
    }
    return checksum;
  }

  private String createSearchString(Book book) {
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
