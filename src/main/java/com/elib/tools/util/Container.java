package com.elib.tools.util;

/**
 * 
 * @author Pavlo Romankevych
 *
 */

public class Container {

  private String newString = "";
  private String value = "";

  public String getNewString() {
    return newString;
  }

  public void setNewString(String newString) {
    this.newString = newString;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((newString == null) ? 0 : newString.hashCode());
    result = prime * result + ((value == null) ? 0 : value.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Container other = (Container) obj;
    if (newString == null) {
      if (other.newString != null)
        return false;
    } else if (!newString.equals(other.newString))
      return false;
    if (value == null) {
      if (other.value != null)
        return false;
    } else if (!value.equals(other.value))
      return false;
    return true;
  }
  
  
}
