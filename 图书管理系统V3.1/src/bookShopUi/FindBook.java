package bookShopUi;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.naming.spi.DirStateFactory.Result;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;

import entity.BookData;
import severice.BookSever;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import java.awt.Color;
import java.awt.Dimension;

public class FindBook extends JPanel implements ActionListener{
	
	//创建业务层
	private BookSever booksever = new BookSever();
	
	//所需组件
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;;

	JButton findId = new JButton("ID查找");
	JButton findname = new JButton("书名查找");
	JButton findAuthor = new JButton("作者查找");
	JButton cart = new JButton("添加商品到购物车");
	private final JScrollPane scrollPane = new JScrollPane();
	private final JTable table = new JTable();
	

	//添加监控
	public void monitor() {
		findId.addActionListener(this);
		findId.setActionCommand("findId");
		
		findname.addActionListener(this);
		findname.setActionCommand("name");
		
		findAuthor.addActionListener(this);
		findAuthor.setActionCommand("author");
		
		cart.addActionListener(this);
		cart.setActionCommand("cart");
		
	}
	
	/**
	 * Create the panel.
	 */
	public FindBook() {
		monitor();//实现监听
		setSize(785,450);
		
		JLabel lblNewLabel = new JLabel("ID：");
		lblNewLabel.setFont(new Font("华文行楷", Font.PLAIN, 18));
		
		JLabel lblNewLabel_1 = new JLabel("书名：");
		lblNewLabel_1.setFont(new Font("华文行楷", Font.PLAIN, 18));
		
		JLabel lblNewLabel_2 = new JLabel("作者：");
		lblNewLabel_2.setFont(new Font("华文行楷", Font.PLAIN, 18));
		
		textField = new JTextField();
		textField.setFont(new Font("华文隶书", Font.PLAIN, 16));
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("华文隶书", Font.PLAIN, 16));
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("华文隶书", Font.PLAIN, 16));
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setColumns(10);
		
	
		findId.setFont(new Font("华文细黑", Font.PLAIN, 16));
		
	
		findname.setFont(new Font("华文细黑", Font.PLAIN, 16));
		

		findAuthor.setFont(new Font("华文细黑", Font.PLAIN, 16));
		

		cart.setForeground(new Color(240, 255, 240));
		cart.setFont(new Font("华文隶书", Font.PLAIN, 18));
		cart.setBackground(new Color(255, 0, 0));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(226)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel)
								.addComponent(lblNewLabel_1)
								.addComponent(lblNewLabel_2))
							.addGap(2)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(textField_2)
								.addComponent(textField)
								.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE))
							.addGap(28)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(findId)
								.addComponent(findname)
								.addComponent(findAuthor)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(297)
							.addComponent(cart))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(31)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 730, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(24, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(34)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(findId))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(findname))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(findAuthor))
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
					.addComponent(cart)
					.addGap(30))
		);
		table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"id", "\u4E66\u540D", "\u4F5C\u8005", "\u4EF7\u683C", "\u6570\u91CF"
				}
			));
		 JTableHeader head = table.getTableHeader(); // 创建表格标题对象
		head.setPreferredSize(new Dimension(head.getWidth(), 20));// 设置表头大小
		head.setFont(new Font("华文楷体", Font.PLAIN, 20));
		table.setFont(new Font("华文楷体", Font.PLAIN, 20));
		table.setRowHeight(25);
		DefaultTableCellRenderer cr = new DefaultTableCellRenderer();
		  cr.setHorizontalAlignment(JLabel.CENTER);
		  table.setDefaultRenderer(Object.class, cr);
		scrollPane.setViewportView(table);
		setLayout(groupLayout);
	}
	//创建临时购物车
	 	ArrayList<BookData> booklist = new ArrayList<BookData>();
	static ArrayList<BookData> shopping = new ArrayList<BookData>();
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		if(e.getActionCommand().equals("findId"))
		{
			System.out.println("单击");
			if((textField.getText().length()==0)) {
				JOptionPane.showMessageDialog(this, "ID不能为空！");
			}
			else {
				
				BookData book = new BookData();
				if((book=booksever.findBook(Integer.parseInt(textField.getText())))!=null) {
//					result.append("ID\t书名\t作者\t价格\t数量\n");
					booklist.add(book);
					int size =booklist.size();
					Object[][] data = new Object[size][5];
						for(int i=0;i<size;i++) {
							BookData book2 = booklist.get(i);
								data[i][0]=book2.getBookID();
								data[i][1]=book2.getBookname();
								data[i][2]=book2.getAuthor();
								data[i][3]=book2.getMoney();
								data[i][4]=book2.getNumber();
							}
					
					table.setModel(new DefaultTableModel(
							data,
							new String[] {
									"id", "\u4E66\u540D", "\u4F5C\u8005", "\u4EF7\u683C", "\u6570\u91CF"
							}
						));
				}
				else {
					JOptionPane.showMessageDialog(this, "什么也没有找到！");
				}
			}
		}
		if(e.getActionCommand().equals("cart")) {
			if(booklist.size()==0) {
				JOptionPane.showMessageDialog(this, "请先去选择商品！");
			}
			else {
				shopping=booklist;
				JOptionPane.showMessageDialog(this, "商品添加成功！");
			}
		}
	}
}
