/**
 * 
 */
package com.elib.tools;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.elib.dao.BookDAO;
import com.elib.dao.OwnerDAO;
import com.elib.dao.RoleDAO;
import com.elib.dao.UserDAO;
import com.elib.dao.UserLibraryDAO;
import com.elib.entity.Book;
import com.elib.entity.Owner;
import com.elib.entity.User;
import com.elib.tools.folder.FolderBean;
import com.elib.tools.folder.FolderFilter;
import com.elib.tools.folder.FolderScanner;

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
  @Autowired
  private RoleDAO roleDAO;
  @Autowired
  private UserLibraryDAO userLibraryDAO;

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
    BookHandler handler = new BookHandler();

    folderBean = scanner.scanFolder(path, true);
    folderBean = filter.filterFolderFiles(folderBean);
    List<Book> books = handler.processBooks(folderBean.getFiles());

    User user = userDAO.findByEmail(userEmail);
    for (Book book : books) {
      Owner owner = new Owner(book, user);
      ownerDAO.save(owner);
    }
  }

  public void test(String email) {
    User user = userDAO.findByEmail(email);
    List<Owner> owners = ownerDAO.findByUser(user);
    for (Owner o : owners) {
      System.out.println(o.getBook());
    }
    Set<User> users = roleDAO.findByRole("admin").getUsers();
    for (User u : users) {
      System.out.println(u.getFirstName());
    }
    List<Book> books = bookDAO.findByAll("Eckel");
    for (Book b : books) {
      System.out.println(b.getFilename());
    }
  }

  /**
   * @param args
   */

  public static void main(String[] args) {
    DataBaseTools baseFiller = new DataBaseTools();
    baseFiller.fillDataBase("D:\\Diploma\\Info\\tmp\\", "admin@admin.com");
    baseFiller.test("admin@admin.com");
  }

}
