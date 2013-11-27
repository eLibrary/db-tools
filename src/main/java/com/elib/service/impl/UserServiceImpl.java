package com.elib.service.impl;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.elib.dao.RoleDAO;
import com.elib.dao.UserDAO;
import com.elib.entity.User;
import com.elib.service.UserService;
import com.elib.tools.util.Constants;

public class UserServiceImpl implements UserService {

  @Autowired
  private UserDAO userDAO;
  @Autowired
  private RoleDAO roleDAO;

  @Override
  public User logIn(String email, String password) {
    if (email != null && password != null) {
      User user = userDAO.findByEmail(email);
      if (user != null) {
        if (password.equals(user.getPassword())) {
          return user;
        }
      }
    }
    return null;
  }

  @Override
  public User register(Map<String, Object> userInfo) {
    if (userInfo != null) {
      User user = new User();
      user.setFirstName((String) userInfo.get(Constants.USER_FIRSTNAME_KEY));
      user.setLastName((String) userInfo.get(Constants.USER_LASTNAME_KEY));
      user.setEmail((String) userInfo.get(Constants.USER_EMAIL_KEY));
      user.setPassword((String) userInfo.get(Constants.USER_PASSWORD_KEY));
      user.setDateOfBirth((Date) userInfo.get(Constants.USER_DATE_OF_BIRTHD_KEY));
      user.setRole(roleDAO.findByRole(Constants.USER_ROLE_REGISTERED));
    }
    return null;
  }

}
