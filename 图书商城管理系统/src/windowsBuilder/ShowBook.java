package windowsBuilder;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.SystemColor;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import entity.BookData;
import severice.BookSever;

public class ShowBook extends JPanel {
	
	private BookSever bookSever = new BookSever();
//	private BookDao bookDao = new BookDao();
	private JTable table;
	

	/**
	 * Create the panel.
	 */
	public ShowBook() {
		setSize(785,450);
		setBackground(new Color(245, 245, 245));
		setLayout(new GridLayout(1, 0, 0, 0));
	
		JScrollPane scrollPane = new JScrollPane();
		
		add(scrollPane);
//		bookDao.inputBook();
//		bookDao.outputBook();//读出
//		int id=100;
//		BookData book1 = new BookData(id++,"Java","小小怪",66.66f,20);
//		bookSever.creatBook(book1);
		int size = bookSever.readBook().size();
		
		Object [] [] data = new Object[size][5];
		for(int i=0;i<size;i++) {
			BookData book = bookSever.readBook().get(i);
				data[i][0]=book.getBookID();
				data[i][1]=book.getBookname();
				data[i][2]=book.getAuthor();
				data[i][3]=book.getMoney();
				data[i][4]=book.getNumber();
				
			}

		
		table = new JTable();
		table.setRowHeight(30);
		DefaultTableCellRenderer cr = new DefaultTableCellRenderer();
		  cr.setHorizontalAlignment(JLabel.CENTER);
		  table.setDefaultRenderer(Object.class, cr);
		 JTableHeader head = table.getTableHeader(); // 创建表格标题对象
		head.setPreferredSize(new Dimension(head.getWidth(), 40));// 设置表头大小
		head.setFont(new Font("华文楷体", Font.PLAIN, 30));
		table.setBackground(SystemColor.control);
		table.setBorder(new MatteBorder(2, 1, 2, 1, (Color) new Color(0, 255, 255)));
		table.setForeground(Color.DARK_GRAY);
		table.setFont(new Font("华文楷体", Font.PLAIN, 28));
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setModel(new DefaultTableModel(
			data,
			new String[] {
				"id", "\u4E66\u540D", "\u4F5C\u8005", "\u4EF7\u683C", "\u6570\u91CF"
			}
		));
		table.getColumnModel().getColumn(1).setPreferredWidth(128);
		table.getColumnModel().getColumn(2).setPreferredWidth(134);
		table.getColumnModel().getColumn(3).setPreferredWidth(80);
		scrollPane.setViewportView(table);
		setVisible(true);
	}

}
