package adminUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout.Alignment;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import entity.BookData;
import severice.BookSever;

public class DeleteBook extends JPanel implements ActionListener {
	//创建业务对象
	private BookSever bookSever = new BookSever();
	
	//添加组件
	private JTextField bookId;
	private JTextField bookName;
	private JTextField bookAuthor;
	private JTable table;
	private JButton findID = new JButton("Id查找");
	private JButton findNaem = new JButton("查找书名");
	private JButton findAuthor = new JButton("查找作者");
	private JButton deleteBook = new JButton("删除图书");
	private JScrollPane scrollPane = new JScrollPane();
	/**
	 * 添加监听事件
	 */
	
	public void monitor() {
		findID.addActionListener(this);
		findID.setActionCommand("findID");
		
		deleteBook.addActionListener(this);
		deleteBook.setActionCommand("delete");
	}
	/**
	 * Create the panel.
	 */
	public DeleteBook() {
		monitor();
		setSize(980,435);
		
		JLabel lblNewLabel = new JLabel("删除图书");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("华文彩云", Font.ITALIC, 35));
		
		JLabel lblNewLabel_1 = new JLabel("ID:");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 20));
		
		JLabel lblNewLabel_2 = new JLabel("书名：");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 20));
		
		bookId = new JTextField();
		bookId.setFont(new Font("宋体", Font.PLAIN, 20));
		bookId.setHorizontalAlignment(SwingConstants.CENTER);
		bookId.setColumns(10);
		
		bookName = new JTextField();
		bookName.setFont(new Font("宋体", Font.PLAIN, 20));
		bookName.setHorizontalAlignment(SwingConstants.CENTER);
		bookName.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("作者：");
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 20));
		
		bookAuthor = new JTextField();
		bookAuthor.setFont(new Font("宋体", Font.PLAIN, 20));
		bookAuthor.setHorizontalAlignment(SwingConstants.CENTER);
		bookAuthor.setColumns(10);
		
		
		findID.setFont(new Font("华文隶书", Font.PLAIN, 22));
		
		
		findNaem.setFont(new Font("华文隶书", Font.PLAIN, 22));
		
		
		findAuthor.setFont(new Font("华文隶书", Font.PLAIN, 22));
		
		
		
		
		deleteBook.setForeground(new Color(204, 255, 255));
		deleteBook.setBackground(new Color(255, 102, 51));
		deleteBook.setFont(new Font("宋体", Font.PLAIN, 20));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 952, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(80)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 818, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(315, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel_3)
							.addGap(18)
							.addComponent(bookAuthor))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_2)
								.addComponent(lblNewLabel_1))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(bookId)
								.addComponent(bookName, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE))))
					.addGap(58)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(findAuthor)
						.addComponent(findNaem)
						.addComponent(findID))
					.addGap(278))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(389)
					.addComponent(deleteBook, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(444, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(bookId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(findID))
					.addGap(31)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel_2)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(bookName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(findNaem)))
					.addGap(31)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3)
						.addComponent(bookAuthor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(findAuthor))
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(deleteBook, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(29, Short.MAX_VALUE))
		);
		table = new JTable();
		table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"ID", "\u4E66\u540D", "\u4F5C\u8005", "\u4EF7\u683C", "\u6570\u91CF"
				}
			));
		table.setRowHeight(30);
		DefaultTableCellRenderer cr = new DefaultTableCellRenderer();
		  cr.setHorizontalAlignment(JLabel.CENTER);
		  table.setDefaultRenderer(Object.class, cr);
		 JTableHeader head = table.getTableHeader(); // 创建表格标题对象
		head.setPreferredSize(new Dimension(head.getWidth(), 40));// 设置表头大小
		head.setFont(new Font("华文楷体", Font.PLAIN, 30));
		scrollPane.setViewportView(table);
		setLayout(groupLayout);
	}
	public void fulsh() {
		setVisible(false);
		scrollPane.remove(table);
		setVisible(true);
	}
	Object[] [] data = new Object[1][5];
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		if(e.getActionCommand().equals("findID")) {
			System.out.println("单击");
			int id = Integer.parseInt(bookId.getText());
			BookData book;
			if((book=bookSever.findBook(id))!=null) {
				System.out.println("找到");
				
				data[0][0]=book.getBookID();
				data[0][1]=book.getBookname();
				data[0][2]=book.getAuthor();
				data[0][3]=book.getMoney();
				data[0][4]=book.getNumber();
				table = new JTable();
				table.setModel(new DefaultTableModel(
						data,
						new String[] {
							"ID", "\u4E66\u540D", "\u4F5C\u8005", "\u4EF7\u683C", "\u6570\u91CF"
						}
					));
				table.setRowHeight(45);
				DefaultTableCellRenderer cr = new DefaultTableCellRenderer();
				  cr.setHorizontalAlignment(JLabel.CENTER);
				  table.setDefaultRenderer(Object.class, cr);
				 JTableHeader head = table.getTableHeader(); // 创建表格标题对象
				head.setPreferredSize(new Dimension(head.getWidth(), 40));// 设置表头大小
				head.setFont(new Font("华文楷体", Font.PLAIN, 30));
				table.setFont(new Font("华文楷体", Font.PLAIN, 30));
				scrollPane.setViewportView(table);
			}
			else {
				JOptionPane.showMessageDialog(this, "请输入正确ID！");
			}
		}
		if(e.getActionCommand().equals("delete")) {
			int id = Integer.parseInt(bookId.getText());
			if(bookSever.dleteBook(id)) {
				JOptionPane.showMessageDialog(this, "删除成功！");
			}
		}
	}

}
