package com.elib.tools;

import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.Font;

import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.elib.dao.BookDAO;
import com.elib.dao.OwnerDAO;
import com.elib.dao.UserDAO;
import com.elib.entity.Book;
import com.elib.tools.folder.FolderBean;
import com.elib.tools.folder.FolderFilter;
import com.elib.tools.folder.FolderScanner;
import com.elib.tools.util.FileExtension;

import javax.swing.JList;

@SuppressWarnings("serial")
@Component
public class DataBaseAdminTools extends JFrame {

  @Autowired
  private BookDAO bookDAO;
  @Autowired
  private UserDAO userDAO;
  @Autowired
  private OwnerDAO ownerDAO;

  private FolderBean folderBean;
  private FolderScanner scanner = new FolderScanner();
  private FolderFilter filter = new FolderFilter();
  private BookHandler handler = new BookHandler();

  private JPanel contentPane;
  private JTextField textField;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          DataBaseAdminTools frame = new DataBaseAdminTools();
          frame.setVisible(true);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }

  /**
   * Create the frame.
   */
  public DataBaseAdminTools() {
    setTitle("eLibrary-Admin-DBTools");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 750, 400);
    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    setContentPane(contentPane);
    contentPane.setLayout(null);

    textField = new JTextField();
    textField.setBounds(10, 10, 200, 20);
    textField.setFont(new Font("Times New Roman", Font.PLAIN, 12));
    contentPane.add(textField);
    textField.setColumns(10);

    final JLabel lblNewLabel = new JLabel("Count of files: ");
    lblNewLabel.setBounds(10, 335, 200, 20);
    lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 12));
    contentPane.add(lblNewLabel);

    final DefaultListModel<String> model = new DefaultListModel<String>();
    final JList<String> list = new JList<String>();
    list.setBounds(650, 1, 80, 280);
    contentPane.add(list);

    JScrollPane scrollPane = new JScrollPane(list);
    scrollPane.setBounds(10, 42, 709, 275);
    contentPane.add(scrollPane);

    JButton btnNewButton = new JButton("Scan");
    btnNewButton.setBounds(216, 10, 89, 23);
    btnNewButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        model.clear();
        folderBean = scanner.scanFolder(textField.getText(), true);
        for (File file : folderBean.getFiles()) {
          model.addElement(file.getName());
        }
        list.setModel(model);
        lblNewLabel.setText("Count of files: " + folderBean.getFiles().size());
      }
    });
    contentPane.add(btnNewButton);

    JButton btnNewButton_1 = new JButton("Filter");
    btnNewButton_1.setBounds(312, 10, 89, 23);
    btnNewButton_1.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        model.clear();
        folderBean = scanner.scanFolder(textField.getText(), true);
        folderBean = filter.filterFolderFiles(folderBean);
        for (File file : folderBean.getFiles()) {
          model.addElement(file.getName());
        }
        list.setModel(model);
        lblNewLabel.setText("Count of files: " + folderBean.getFiles().size());
      }
    });
    contentPane.add(btnNewButton_1);

    JButton btnNewButton_3 = new JButton("Clear");
    btnNewButton_3.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        model.clear();
        list.setModel(model);
        lblNewLabel.setText("Count of files: 0");
        folderBean = null;
      }
    });
    btnNewButton_3.setBounds(630, 331, 89, 23);
    contentPane.add(btnNewButton_3);

    JButton btnNewButton_4 = new JButton("PDF only");
    btnNewButton_4.setBounds(400, 10, 89, 23);
    btnNewButton_4.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        model.clear();
        folderBean = scanner.scanFolder(textField.getText(), true);
        folderBean = filter.filterFolderFilesByExtension(folderBean, FileExtension.PDF);
        for (File file : folderBean.getFiles()) {
          model.addElement(file.getName());
        }
        list.setModel(model);
        lblNewLabel.setText("Count of files: " + folderBean.getFiles().size());
      }
    });
    contentPane.add(btnNewButton_4);

    JButton btnDjvuOnly = new JButton("DJVU only");
    btnDjvuOnly.setBounds(488, 10, 100, 23);
    btnDjvuOnly.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        model.clear();
        folderBean = scanner.scanFolder(textField.getText(), true);
        folderBean = filter.filterFolderFilesByExtension(folderBean, FileExtension.DJVU);
        for (File file : folderBean.getFiles()) {
          model.addElement(file.getName());
        }
        list.setModel(model);
        lblNewLabel.setText("Count of files: " + folderBean.getFiles().size());
      }
    });
    contentPane.add(btnDjvuOnly);

    JButton btnNewButton_5 = new JButton("Process books");
    btnNewButton_5.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        final List<Book> books = handler.processBooks(folderBean.getFiles());
        ProcessedBooksWindow processedBooksWindow = new ProcessedBooksWindow(books);
        processedBooksWindow.setVisible(true);
      }
    });
    btnNewButton_5.setBounds(587, 10, 132, 23);
    contentPane.add(btnNewButton_5);

  }
}
