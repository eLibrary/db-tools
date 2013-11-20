/**
 * 
 */
package com.elib.tools;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.elib.dao.BookDAO;
import com.elib.entity.Book;
import com.elib.tools.folder.FolderBean;
import com.elib.tools.folder.FolderFilter;
import com.elib.tools.folder.FolderScanner;
import com.elib.tools.parser.FileNameParser;
import com.elib.tools.transliterator.BookTransliterator;

/**
 * @author Pavlo Romankevych
 * 
 */
@Component
public class DataBaseTools {
  @Autowired
  BookDAO bookDAO;

  @SuppressWarnings("resource")
  public DataBaseTools() {
    ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath*:applicationContext.xml");
    AutowireCapableBeanFactory acbFactory = ctx.getAutowireCapableBeanFactory();
    acbFactory.autowireBean(this);
  }

  public void doJob() {
    FolderScanner scanner = new FolderScanner();
    FolderFilter filter = new FolderFilter();
    FileNameParser parser = new FileNameParser();
    FolderBean folderBean = scanner.scanFolder("D:\\Diploma\\Info\\tmp", true);
    folderBean = filter.filterFolderFiles(folderBean);
    List<Book> booksPr = parser.parseFileNameToObject(folderBean);
    System.out.println(booksPr.size());
    BookTransliterator bookTransliterator = new BookTransliterator();
    List<Book> booksTr = bookTransliterator.transliterateBooks(booksPr);
    System.out.println(booksTr.size());
    bookDAO.save(booksTr.get(0));
  }

  /**
   * @param args
   */

  public static void main(String[] args) {
    DataBaseTools baseFiller = new DataBaseTools();
    baseFiller.doJob();
  }

}
