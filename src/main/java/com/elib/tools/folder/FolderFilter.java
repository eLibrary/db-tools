/**
 * 
 */
package com.elib.tools.folder;

import java.io.File;

import com.elib.tools.util.Constants;
import com.elib.tools.util.FileExtension;

/**
 * @author Pavlo Romankevych
 * 
 */
public class FolderFilter extends FolderProcessor {

  public FolderFilter() {
  }

  public FolderBean filterFolderFiles(FolderBean folderBean) {
    setFolderBean(new FolderBean(folderBean.getFolderName()));
    for (File file : folderBean.getFiles()) {
      for (String extension : FileExtension.getExtensions()) {
        if (isAllowedExtension(file, extension)) {
          getFolderBean().getFiles().add(file);
          getFolderBean().getFileNameList().add(file.getName());
        }
      }
    }
    if (getFolderBean().getFiles() != null) {
      createResultFile(getFolderBean().getFiles(), Constants.FILTER_RESULT_FILE_NAME);
    }
    return getFolderBean();
  }

  public FolderBean filterFolderFilesByExtension(FolderBean folderBean, String extension) {
    setFolderBean(new FolderBean(folderBean.getFolderName()));
    for (File file : folderBean.getFiles()) {
      if (isAllowedExtension(file, extension)) {
        getFolderBean().getFiles().add(file);
        getFolderBean().getFileNameList().add(file.getName());
      }
    }
    if (getFolderBean().getFileNameList() != null) {
      createResultFile(getFolderBean().getFiles(), "(" + extension + ")" + Constants.FILTER_RESULT_FILE_NAME);
    }
    return getFolderBean();
  }

  private boolean isAllowedExtension(File file, String extension) {
    int beginIndex = file.getName().lastIndexOf(".");
    int endIndex = file.getName().length();
    String str = "";
    if (beginIndex != -1) {
      str = file.getName().substring(beginIndex, endIndex);
    }
    if (str.equalsIgnoreCase("."+extension)) {
      return true;
    }
    return false;
  }

}
