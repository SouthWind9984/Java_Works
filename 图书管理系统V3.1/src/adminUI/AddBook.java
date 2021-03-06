package adminUI;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;

import entity.BookData;

import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import severice.BookSever;

import javax.swing.JButton;

public class AddBook extends JPanel implements ActionListener {
	//业务层对象
	private BookSever bookSever = new BookSever();
	
	//组件
	private JTextField bookId; 
	private JTextField bookName;
	private JTextField bookAuthor;
	private JTextField bookPrice;
	private JTextField bookNumber;
	private JButton addBook = new JButton("添加图书");
	
	/**
	 * 添加监听事件
	 */
	
	public void monitor() {
		addBook.addActionListener(this);
		addBook.setActionCommand("add");
	}
	/**
	 * Create the panel.
	 */
	public AddBook() {
		monitor();//实现监听
		setSize(980,435);
		
		JLabel lblNewLabel = new JLabel("增加图书");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("华文彩云", Font.ITALIC, 30));
		
		JLabel lblNewLabel_1 = new JLabel("ID：");
		lblNewLabel_1.setFont(new Font("微软雅黑 Light", Font.PLAIN, 24));
		
		JLabel lblNewLabel_2 = new JLabel("书名：");
		lblNewLabel_2.setFont(new Font("微软雅黑 Light", Font.PLAIN, 24));
		
		JLabel lblNewLabel_3 = new JLabel("作者：");
		lblNewLabel_3.setFont(new Font("微软雅黑 Light", Font.PLAIN, 24));
		
		JLabel lblNewLabel_4 = new JLabel("价格：");
		lblNewLabel_4.setFont(new Font("微软雅黑 Light", Font.PLAIN, 24));
		
		JLabel lblNewLabel_5 = new JLabel("数量：");
		lblNewLabel_5.setFont(new Font("微软雅黑 Light", Font.PLAIN, 24));
		
		bookId = new JTextField();
		bookId.setFont(new Font("华文楷体", Font.PLAIN, 20));
		bookId.setHorizontalAlignment(SwingConstants.CENTER);
		bookId.setColumns(10);
		
		bookName = new JTextField();
		bookName.setFont(new Font("华文楷体", Font.PLAIN, 20));
		bookName.setHorizontalAlignment(SwingConstants.CENTER);
		bookName.setColumns(10);
		
		bookAuthor = new JTextField();
		bookAuthor.setFont(new Font("华文楷体", Font.PLAIN, 20));
		bookAuthor.setHorizontalAlignment(SwingConstants.CENTER);
		bookAuthor.setColumns(10);
		
		bookPrice = new JTextField();
		bookPrice.setFont(new Font("华文楷体", Font.PLAIN, 20));
		bookPrice.setHorizontalAlignment(SwingConstants.CENTER);
		bookPrice.setColumns(10);
		
		bookNumber = new JTextField();
		bookNumber.setFont(new Font("华文楷体", Font.PLAIN, 20));
		bookNumber.setHorizontalAlignment(SwingConstants.CENTER);
		bookNumber.setColumns(10);
		
		
		addBook.setFont(new Font("宋体", Font.PLAIN, 25));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(247)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblNewLabel_2)
								.addComponent(lblNewLabel_4))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(bookName, 0, 0, Short.MAX_VALUE)
								.addComponent(bookPrice, GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE))
							.addGap(36)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel_3)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(bookAuthor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel_5)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(bookNumber)))
							.addPreferredGap(ComponentPlacement.RELATED, 238, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 966, Short.MAX_VALUE)))
					.addContainerGap())
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(388, Short.MAX_VALUE)
					.addComponent(lblNewLabel_1)
					.addGap(18)
					.addComponent(bookId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(371))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(419)
					.addComponent(addBook)
					.addContainerGap(428, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(25)
					.addComponent(lblNewLabel)
					.addGap(53)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(bookId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(27)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3)
						.addComponent(lblNewLabel_2)
						.addComponent(bookName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(bookAuthor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_4)
								.addComponent(bookPrice, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(24)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_5)
								.addComponent(bookNumber, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addGap(48)
					.addComponent(addBook)
					.addGap(82))
		);
		setLayout(groupLayout);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		if(e.getActionCommand().equals("add")) {
			int id =Integer.parseInt(bookId.getText());
			float price = Float.parseFloat(bookPrice.getText());
			int number= Integer.parseInt(bookNumber.getText());
			BookData book = new BookData(id,bookName.getText(),bookAuthor.getText(),price,number);
			if((bookSever.findBook(id)) == null) {
				bookSever.creatBook(book);
				JOptionPane.showMessageDialog(this, "图书添加成功！");
			}
			else {
				JOptionPane.showMessageDialog(this, "该ID已被占用！");
			}
		}
	}
}
