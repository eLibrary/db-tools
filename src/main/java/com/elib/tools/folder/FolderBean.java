/**
 * 
 */
package com.elib.tools.folder;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Pavlo Romankevych
 * 
 */
public class FolderBean {

  private final String folderName;
  private List<File> files = new ArrayList<File>();
  private List<String> fileNameList = new ArrayList<String>();
  private File resultFile;

  public FolderBean(String folderName) {
    this.folderName = folderName;
  }

  public String getFolderName() {
    return folderName;
  }

  public List<File> getFiles() {
    return files;
  }

  public void setFiles(List<File> files) {
    this.files = files;
  }

  public List<String> getFileNameList() {
    return fileNameList;
  }

  public void setFileNameList(List<String> fileNameList) {
    this.fileNameList = fileNameList;
  }

  public File getResultFile() {
    return resultFile;
  }

  public void setResultFile(File resultFile) {
    this.resultFile = resultFile;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fileNameList == null) ? 0 : fileNameList.hashCode());
    result = prime * result + ((files == null) ? 0 : files.hashCode());
    result = prime * result + ((folderName == null) ? 0 : folderName.hashCode());
    result = prime * result + ((resultFile == null) ? 0 : resultFile.hashCode());
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
    FolderBean other = (FolderBean) obj;
    if (fileNameList == null) {
      if (other.fileNameList != null)
        return false;
    } else if (!fileNameList.equals(other.fileNameList))
      return false;
    if (files == null) {
      if (other.files != null)
        return false;
    } else if (!files.equals(other.files))
      return false;
    if (folderName == null) {
      if (other.folderName != null)
        return false;
    } else if (!folderName.equals(other.folderName))
      return false;
    if (resultFile == null) {
      if (other.resultFile != null)
        return false;
    } else if (!resultFile.equals(other.resultFile))
      return false;
    return true;
  }
}