package com.elib.tools;

import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JButton;

import com.elib.entity.Book;

import javax.swing.JScrollPane;

@SuppressWarnings("serial")
public class ProcessedBooksWindow extends JFrame {

  private JPanel contentPane;
  private JTable table;
  private String[] columnNames = { "title", "author", "series", "edition", "publisher", "year", "language", "ISBN",
      "dpi", "pages", "extension" };
  private Object[][] data;

  /**
   * Create the frame.
   */
  public ProcessedBooksWindow(List<Book> books) {
    setTitle("Processed Books");
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    setBounds(100, 100, 1000, 501);
    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    setContentPane(contentPane);
    contentPane.setLayout(null);

    data = new Object[books.size()][11];
    for (int i = 0; i < books.size(); i++) {
      data[i][0]=books.get(i).getTitle();
      data[i][1]=books.get(i).getAuthor();
      data[i][2]=books.get(i).getSeries();
      data[i][3]=books.get(i).getEdition();
      data[i][4]=books.get(i).getPublisher();
      data[i][5]=books.get(i).getYear();
      data[i][6]=books.get(i).getLanguage();
      data[i][7]=books.get(i).getIdentifier();
      data[i][8]=books.get(i).getDpi();
      data[i][9]=books.get(i).getPages();
      data[i][10]=books.get(i).getExtension();
    }
    table = new JTable(data, columnNames);
    table.setCellSelectionEnabled(true);
    table.setColumnSelectionAllowed(true);
    table.setBounds(10, 10, this.getWidth()-10, this.getHeight()-50);
    table.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
    contentPane.add(table);

    JButton btnNewButton = new JButton("Store to DB");
    btnNewButton.setBounds(824, 422, 150, 30);
    contentPane.add(btnNewButton);

    JScrollPane scrollPane = new JScrollPane(table);
    scrollPane.setBounds(10, 10, 964, 350);
    contentPane.add(scrollPane);

  }
}
