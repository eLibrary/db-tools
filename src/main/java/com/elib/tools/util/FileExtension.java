/**
 * 
 */
package com.elib.tools.util;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Pavlo Romankevych
 * 
 */
public final class FileExtension {

  private static final List<String> extensions = new ArrayList<String>();

  public static final String PDF = "pdf";
  public static final String DJVU = "djvu";
  public static final String DOC = "doc";
  public static final String DOCX = "docx";
  public static final String CHM = "chm";

  public static List<String> getExtensions() {
    return extensions;
  }

  static {
    extensions.add(PDF);
    extensions.add(DJVU);
    extensions.add(DOC);
    extensions.add(DOCX);
    extensions.add(CHM);
  }
}
