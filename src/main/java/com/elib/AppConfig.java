package com.elib;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.elib.dao.BookDAO;
import com.elib.dao.impl.BookDAOImpl;

/**
 * 
 * @author Pavlo Romankevych
 *
 */
@Configuration
public class AppConfig {

  @Bean
  @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
  public BookDAO bookDAO(){
    return new BookDAOImpl();
  }
  
}
