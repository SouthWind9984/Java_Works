package windowsBuilder;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import entity.BookData;
import entity.UserData;
import severice.UserSever;
import severice.UserSever;

import javax.swing.JTable;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JTextField;
import javax.swing.JButton;

public class Cart extends JPanel implements ActionListener {
	//创建业务对象
	private UserSever userSever = new UserSever();
	//添加所需组件
	private JTable table;
	private JTextField textField;//商品id
	JLabel price = new JLabel("New label");
	JButton del = new JButton("移除");
	
	JButton pay = new JButton("购买");
	JButton delall = new JButton("清空购物车");
	JScrollPane scrollPane = new JScrollPane();
	ArrayList<BookData> booklist = new ArrayList<BookData>();
	float sum=0;//总价
	//添加监控
		public void monitor() {
			del.addActionListener(this);
			del.setActionCommand("del");
			
			pay.addActionListener(this);
			pay.setActionCommand("pay");
			
			delall.addActionListener(this);
			delall.setActionCommand("all");
			
		}
		
	/**
	 * Create the panel.
	 */
	public Cart() {
		
		monitor();//实现监控
		setSize(785,450);
		
		
		
		JLabel lblNewLabel = new JLabel("商品列表：");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("华文中宋", Font.PLAIN, 20));
		
		JLabel lblNewLabel_1 = new JLabel("总价：");
		lblNewLabel_1.setFont(new Font("华文隶书", Font.PLAIN, 18));
		

		price.setForeground(Color.RED);
		price.setFont(new Font("华文隶书", Font.PLAIN, 20));
		
		JLabel lblNewLabel_3 = new JLabel("移除商品ID:");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		
		pay.setBackground(new Color(255, 69, 0));
		pay.setForeground(new Color(248, 248, 255));
		pay.setFont(new Font("华文行楷", Font.PLAIN, 25));
		
		
		delall.setForeground(new Color(0, 0, 0));
		delall.setBackground(new Color(102, 205, 170));
		delall.setFont(new Font("华文行楷", Font.PLAIN, 22));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(59)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel_3)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(del)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
									.addComponent(delall)
									.addGap(30)))
							.addComponent(pay, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE))
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 631, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(95, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(542, Short.MAX_VALUE)
					.addComponent(lblNewLabel_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(price)
					.addGap(118))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(334)
					.addComponent(lblNewLabel)
					.addContainerGap(361, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(62)
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 212, GroupLayout.PREFERRED_SIZE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_1)
								.addComponent(price))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(pay)
								.addComponent(delall)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(22)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_3)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(del))))
					.addContainerGap(51, Short.MAX_VALUE))
		);
		
		booklist=FindBook.shopping;
		int size =booklist.size();
		Object[][] data = new Object[size][5];
			for(int i=0;i<size;i++) {
				BookData book2 = booklist.get(i);
					data[i][0]=book2.getBookID();
					data[i][1]=book2.getBookname();
					data[i][2]=book2.getAuthor();
					data[i][3]=book2.getMoney();
					data[i][4]=book2.getNumber();
					sum+=book2.getMoney();
				}
			String s =""+sum;
		price.setText(s);
		table = new JTable();
		table.setModel(new DefaultTableModel(
				data,
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
	
	public void fulsh() {
		

		scrollPane.remove(table);
		scrollPane.setVisible(false);
		scrollPane.setViewportView(table);
		scrollPane.setVisible(true);

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		if(e.getActionCommand()=="del") {
			boolean flag =false;
			if(textField.getText().length()!=0) {
			for (int i=0;i<booklist.size();i++) {
				if(booklist.get(i).getBookID()==Integer.parseInt(textField.getText())) {
					booklist.remove(i);
					JOptionPane.showMessageDialog(this, "移除成功！");
					fulsh();
					break;
				}
				else {
					flag=true;
				}
			}
			
			}
			else
				JOptionPane.showMessageDialog(this, "ID不能为空！");
			if(flag) {
				JOptionPane.showMessageDialog(this, "ID错误！");
			}
		}
		if(e.getActionCommand()=="all") {
			int n=JOptionPane.showConfirmDialog(this,"确定要清空吗？","删除提示",0);
			if(n==0) {
				booklist.removeAll(booklist);
				JOptionPane.showMessageDialog(this, "移除成功！");
				fulsh();
			}
		}
		if(e.getActionCommand()=="pay")
		{
			for(UserData user : userSever.readUser()) {
				if(user.getName()==Login.NAME) {
					if(user.getMoney()>sum) {
						user.setMoney(user.getMoney()-sum);
						userSever.updataUser(user);
						booklist.removeAll(booklist);
						JOptionPane.showMessageDialog(this, "购买成功，24h内到达"+user.getAddress()+"!");
					}
					else {
						JOptionPane.showMessageDialog(this, "余额不足，请先充值！");
					}
				}
			}
		}
	}
}
