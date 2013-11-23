package com.elib.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.elib.dao.BookDAO;
import com.elib.entity.Book;

public class BookService {

  @Autowired
  private BookDAO bookDAO;

  @SuppressWarnings("resource")
  public BookService() {
    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath*:applicationContext.xml");
    AutowireCapableBeanFactory acbFactory = applicationContext.getAutowireCapableBeanFactory();
    acbFactory.autowireBean(this);
  }

  public List<Book> searchBook(String str) {
    return bookDAO.findByAll(str);
  }

}
