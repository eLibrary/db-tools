package com.elib.service;

import java.util.Map;

import com.elib.entity.User;

public interface UserService {
  
  /**
   * 
   * @param email
   * @return user if user exist and correct password
   */
  User logIn(String email, String password);
  
  /**
   * 
   * @param userInfo
   * @return user if all data is correct
   */
  User register(Map<String, Object> userInfo);
  
}
