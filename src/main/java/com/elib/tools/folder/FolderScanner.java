/**
 * 
 */
package com.elib.tools.folder;

import java.io.File;

import com.elib.tools.util.Constants;

/**
 * @author Pavlo Romankevych
 * 
 */
public class FolderScanner extends FolderProcessor {

  public FolderScanner() {
  }

  public FolderBean scanFolder(String folderName, boolean scanSubfolders) {
    setFolderBean(new FolderBean(folderName));
    scan(folderName, scanSubfolders);
    if (getFolderBean().getFiles() != null) {
      createResultFile(getFolderBean().getFiles(), Constants.SCAN_RESULT_FILE_NAME);
    }
    return getFolderBean();
  }

  private void scan(String folderName, boolean scanSubfolder) {
    File folder = new File(folderName);
    File[] list = folder.listFiles();
    if (list == null)
      return;
    for (File file : list) {
      if (file.isFile()) {
        if (!checkAndDeleteResultFiles(file)) {
          getFolderBean().getFiles().add(file);
          getFolderBean().getFileNameList().add(file.getName());
        }
      } else if (scanSubfolder==true){
        scan(file.getAbsolutePath(), scanSubfolder);        
      }
    }
  }

}
