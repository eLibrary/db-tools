package com.elib;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.elib.dao.BookDAO;
import com.elib.dao.OwnerDAO;
import com.elib.dao.RoleDAO;
import com.elib.dao.UserDAO;
import com.elib.dao.UserLibraryDAO;
import com.elib.dao.impl.BookDAOImpl;
import com.elib.dao.impl.OwnerDAOImpl;
import com.elib.dao.impl.RoleDAOImpl;
import com.elib.dao.impl.UserDAOImpl;
import com.elib.dao.impl.UserLibraryDAOImpl;

/**
 * 
 * @author Pavlo Romankevych
 * 
 */
@Configuration
public class AppConfig {

  @Bean
  @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
  public BookDAO bookDAO() {
    return new BookDAOImpl();
  }

  @Bean
  @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
  public UserDAO userDAO() {
    return new UserDAOImpl();
  }

  @Bean
  @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
  public OwnerDAO ownerDAO() {
    return new OwnerDAOImpl();
  }

  @Bean
  @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
  public UserLibraryDAO userLibraryDAO() {
    return new UserLibraryDAOImpl();
  }

  @Bean
  @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
  public RoleDAO roleDAO() {
    return new RoleDAOImpl();
  }
}
