/**
 * 
 */
package com.elib.tools.parser;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.elib.entity.Book;
import com.elib.tools.folder.FolderBean;
import com.elib.tools.util.Constants;
import com.elib.tools.util.FileExtension;

/**
 * @author Pavlo Romankevych
 * 
 */
public class FileNameParser {

  public List<Book> parseFileNameToObject(FolderBean folderBean) {
    List<Book> books = new ArrayList<Book>();
    for (File file : folderBean.getFiles()) {
      Book book = parseFileName(file.getName());
      book.setTimeAdded(new Date());
      book.setAbsolutePath(file.getAbsolutePath());
      book.setFilename(file.getName());
      book.setFilesize(file.getTotalSpace());
      book.setMd5(calculateChecksumMD5(file));
      book.setDownloadUrl(Constants.ELIBRARY_HOST + file.getPath());
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

  private Container parseStringAndGetValue(String str, String valuePattern, int offsetBegin, int offsetEnd, boolean trim) {
    Container container = new Container();
    Pattern pattern = Pattern.compile(valuePattern);
    Matcher matcher;
    String result = "";
    if (trim) {
      matcher = pattern.matcher(str.replaceAll("(\\s)", ""));
    } else {
      matcher = pattern.matcher(str);
    }
    if (matcher.find()) {
      result = matcher.group(0);
      int endIndex = matcher.group(0).length() - offsetEnd;
      container.setValue(result.substring(offsetBegin, endIndex));
    }
    String newStr = str.replace(result, "");
    container.setNewString(newStr);
    return container;
  }

  private Book parseFileName(String str) {
    Book book = new Book();
    Container kromsated = parseStringAndGetValue(str, "(\\()(K{1})(\\))", 1, 1, true);
    book.setKromsated(!kromsated.getValue().isEmpty());
    Container color = parseStringAndGetValue(kromsated.getNewString(), "(\\()(C{1})(\\))", 1, 1, true);
    book.setColor(!color.getValue().isEmpty());
    Container ocr = parseStringAndGetValue(color.getNewString(), "(\\()(T{1})(\\))", 1, 1, true);
    book.setOcr(!ocr.getValue().isEmpty());
    Container landscape = parseStringAndGetValue(ocr.getNewString(), "(\\()(L{1})(\\))", 1, 1, true);
    book.setLandscape(!landscape.getValue().isEmpty());
    Container bookmarks = parseStringAndGetValue(landscape.getNewString(), "(\\()(O{1})(\\))", 1, 1, true);
    book.setBookmarks(!bookmarks.getValue().isEmpty());
    Container scanmagic = parseStringAndGetValue(bookmarks.getNewString(), "(\\()(S{1})(\\))", 1, 1, true);
    book.setKromsatedByScanmagic(!scanmagic.getValue().isEmpty());
    Container pages = parseStringAndGetValue(scanmagic.getNewString(), "(\\()(\\d+?)(s\\))", 1, 2, true);
    if (!pages.getValue().isEmpty())
      book.setPages(Integer.valueOf(pages.getValue()));
    Container language = parseStringAndGetValue(pages.getNewString(), "(\\()(\\w{2}+)(\\))", 1, 1, true);
    if (!language.getValue().isEmpty())
      book.setLanguage(language.getValue());
    else
      book.setLanguage(Constants.ENGLISH_LANGUAGE);
    Container isbn = parseStringAndGetValue(language.getNewString(), "(\\(ISBN)(.+?)(\\))", 6, 1, false);
    book.setIdentifier(isbn.getValue());
    Container extension = parseStringAndGetValue(isbn.getNewString(), "(\\.)(\\w{3,5}+)($)", 1, 0, true);
    book.setExtension(extension.getValue());
    Container dpi = parseStringAndGetValue(extension.getNewString(), "(\\()(\\d+?)(dpi\\))", 1, 4, true);
    if (!dpi.getValue().isEmpty())
      book.setDpi(Integer.valueOf(dpi.getValue()));
    else if (book.getExtension().equalsIgnoreCase(FileExtension.DJVU))
      book.setDpi(Constants.DEFAULT_DPI_DJVU);
    else
      book.setDpi(Constants.DEFAULT_DPI_PDF);
    Container otherItems = parseStringAndGetValue(dpi.getNewString(), "(\\)\\s\\()(.+?)(\\))", 3, 1, false);
    if (otherItems.getValue().isEmpty()) {
      book.setSeries("");
      Container editionPublisherYear = parseStringAndGetValue(dpi.getNewString(), "(\\()(.+?)(\\))", 1, 1, false);
      if (!editionPublisherYear.getValue().isEmpty()) {
        Container year = parseStringAndGetValue(editionPublisherYear.getValue().replaceAll("(,\\s|\\s,)", ","),
                "(\\d{4}+)", 0, 0, false);
        if (!year.getValue().isEmpty())
          book.setYear(Integer.valueOf(year.getValue()));
        if (!year.getNewString().isEmpty()) {
          Container edition = parseStringAndGetValue(year.getNewString(), "(^|\\s)(\\d{1,2}+)(e izd.,|ed.,)", 0, 2,
                  false);
          book.setEdition(edition.getValue());
          if (!edition.getNewString().isEmpty()) {
            Container publisher = parseStringAndGetValue(edition.getNewString(), "(.+,$)", 0, 1, false);
            book.setPublisher(publisher.getValue());
          }
        }
      }
      if (!editionPublisherYear.getNewString().isEmpty()) {
        Container author = parseStringAndGetValue(editionPublisherYear.getNewString(), "(.+?)([A-z]\\.{1}\\s{1})", 0,
                1, false);
        book.setAuthor(author.getValue());
        book.setTitle(author.getNewString());
      }
    } else {
      Container year = parseStringAndGetValue(otherItems.getValue().replaceAll("(,\\s|\\s,)", ","), "(\\d{4}+)", 0, 0,
              false);
      if (!year.getValue().isEmpty())
        book.setYear(Integer.valueOf(year.getValue()));
      if (!year.getNewString().isEmpty()) {
        Container edition = parseStringAndGetValue(year.getNewString(), "(^|\\s)(\\d{1,2}+)(e izd.,|ed.,)", 0, 2, false);
        book.setEdition(edition.getValue());
        if (!edition.getNewString().isEmpty()) {
          Container publisher = parseStringAndGetValue(edition.getNewString(), "(.+,$)", 0, 1, false);
          book.setPublisher(publisher.getValue());
        }
      }
      Container series = parseStringAndGetValue(otherItems.getNewString(), "(\\(.+$)", 1, 0, false);
      book.setSeries(series.getValue());
      if (!series.getNewString().isEmpty()) {
        Container author = parseStringAndGetValue(series.getNewString(), "(.+?)([A-z]\\.{1}\\s{1})", 0, 1, false);
        book.setAuthor(author.getValue());
        book.setTitle(author.getNewString());
      }
    }
    return book;
  }

}
