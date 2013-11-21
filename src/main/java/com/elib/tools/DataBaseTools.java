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
import com.elib.dao.OwnerDAO;
import com.elib.dao.UserDAO;
import com.elib.entity.Book;
import com.elib.entity.Owner;
import com.elib.entity.User;
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
  private BookDAO bookDAO;
  @Autowired
  private UserDAO userDAO;
  @Autowired
  private OwnerDAO ownerDAO;

  @SuppressWarnings("resource")
  public DataBaseTools() {
    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath*:applicationContext.xml");
    AutowireCapableBeanFactory acbFactory = applicationContext.getAutowireCapableBeanFactory();
    acbFactory.autowireBean(this);
  }

  public void fillDataBase(String path, String userEmail) {
    FolderBean folderBean;
    FolderScanner scanner = new FolderScanner();
    FolderFilter filter = new FolderFilter();
    FileNameParser parser = new FileNameParser();
    BookTransliterator bookTransliterator = new BookTransliterator();

    folderBean = scanner.scanFolder(path, true);
    folderBean = filter.filterFolderFiles(folderBean);

    List<Book> booksParsed = parser.parseFileNameToObject(folderBean);
    System.out.println(booksParsed.size());
    List<Book> booksTransliterated = bookTransliterator.transliterateBooks(booksParsed);
    System.out.println(booksTransliterated.size());

    User user = userDAO.findByEmail(userEmail);
    for (Book book : booksTransliterated){
      Owner owner = new Owner(book, user);
      ownerDAO.save(owner);
    }
  }

  /**
   * @param args
   */

  public static void main(String[] args) {
    DataBaseTools baseFiller = new DataBaseTools();
    baseFiller.fillDataBase("D:\\Diploma\\Info\\tmp\\", "admin@admin.com");
  }

}
