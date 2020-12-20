package adminUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import entity.UserData;
import severice.UserSever;

public class DelUser extends JPanel implements ActionListener {
	//业务对象
	private UserSever userSever = new UserSever();
	//组件
	private JTextField userName;
	private JTable table;
	private JButton findUser = new JButton("查找用户");
	private JButton deleteUser = new JButton("删除用户");
	
	JScrollPane scrollPane = new JScrollPane();
	/*
	 * 添加监听事件
	 */
	public void montior() {
		findUser.addActionListener(this);
		findUser.setActionCommand("findUser");
		
		deleteUser.addActionListener(this);
		deleteUser.setActionCommand("deleteUser");
	}
	
	/**
	 * Create the panel.
	 */
	public DelUser() {
		montior();
		setSize(980,435);
		JLabel lblNewLabel = new JLabel("删除用户");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("华文彩云", Font.ITALIC, 35));
		
		JLabel lblNewLabel_1 = new JLabel("用户名：");
		lblNewLabel_1.setFont(new Font("等线 Light", Font.PLAIN, 22));
		
		userName = new JTextField();
		userName.setHorizontalAlignment(SwingConstants.CENTER);
		userName.setFont(new Font("华文隶书", Font.PLAIN, 20));
		userName.setColumns(10);
		
		findUser.setFont(new Font("方正舒体", Font.PLAIN, 20));
		
		deleteUser.setFont(new Font("华文行楷", Font.PLAIN, 25));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(394)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(340)
							.addComponent(lblNewLabel_1)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(userName, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(389)
							.addComponent(findUser)))
					.addContainerGap(103, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(79, Short.MAX_VALUE)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 826, GroupLayout.PREFERRED_SIZE)
					.addGap(75))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(377)
					.addComponent(deleteUser)
					.addContainerGap(420, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addGap(32)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(userName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(findUser)
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
					.addGap(38)
					.addComponent(deleteUser)
					.addContainerGap(76, Short.MAX_VALUE))
		);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u7528\u6237\u540D", "\u5BC6\u7801", "\u5730\u5740", "\u4F59\u989D"
			}
		));
		scrollPane.setViewportView(table);
		setLayout(groupLayout);
	}
	Object[] [] data = new Object[1][4];
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO 自动生成的方法存根
		if(arg0.getActionCommand().equals("findUser")) {
			UserData user;
			String Name =userName.getText();
			if((user=userSever.findUser(Name))!=null) {
				data[0][0]=user.getName();
				data[0][1]=user.getPasswd();
				data[0][2]=user.getAddress();
				data[0][3]=user.getMoney();
				table = new JTable();
				table.setModel(new DefaultTableModel(
						data,
						new String[] {
							"ID", "\u4E66\u540D", "\u4F5C\u8005", "\u4EF7\u683C", "\u6570\u91CF"
						}
					));
				scrollPane.setViewportView(table);
			}
			else {
				JOptionPane.showMessageDialog(this, "用户名错误！");
			}
		}
		if(arg0.getActionCommand().equals("deleteUser")) {
			String name = data[0][0].toString();
			if(userSever.deleteUser(name)) {
				JOptionPane.showMessageDialog(this, "删除成功！");
			}
		}
	}

}
