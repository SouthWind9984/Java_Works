package adminUI;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import entity.UserData;
import severice.UserSever;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

public class AddUser extends JPanel implements ActionListener {
	//创建业务对象
	private UserSever userSever = new UserSever();
	
	//组件
	private JTextField name;
	private JTextField pwd;
	private JTextField addres;
	private JTextField money;
	private JButton addUser = new JButton("增加用户");
	
	/**
	 * 	添加监听
	 */
	public void monitor() {
		addUser.addActionListener(this);
		addUser.setActionCommand("add");
	}
	/**
	 * Create the panel.
	 */
	public AddUser() {
		setSize(980,435);
		monitor();
		JLabel lblNewLabel = new JLabel("增加用户");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("华文彩云", Font.ITALIC, 30));
		
		JLabel lblNewLabel_1 = new JLabel("用户名：");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("等线 Light", Font.PLAIN, 22));
		
		JLabel lblNewLabel_1_1 = new JLabel("密码：");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1.setFont(new Font("等线 Light", Font.PLAIN, 22));
		
		JLabel lblNewLabel_1_2 = new JLabel("地址：");
		lblNewLabel_1_2.setFont(new Font("等线 Light", Font.PLAIN, 22));
		
		JLabel lblNewLabel_1_3 = new JLabel("余额：");
		lblNewLabel_1_3.setFont(new Font("等线 Light", Font.PLAIN, 22));
		
		name = new JTextField();
		name.setHorizontalAlignment(SwingConstants.CENTER);
		name.setFont(new Font("宋体", Font.PLAIN, 20));
		name.setColumns(10);
		
		pwd = new JTextField();
		pwd.setHorizontalAlignment(SwingConstants.CENTER);
		pwd.setFont(new Font("宋体", Font.PLAIN, 20));
		pwd.setColumns(10);
		
		addres = new JTextField();
		addres.setHorizontalAlignment(SwingConstants.CENTER);
		addres.setFont(new Font("宋体", Font.PLAIN, 20));
		addres.setColumns(10);
		
		money = new JTextField();
		money.setHorizontalAlignment(SwingConstants.CENTER);
		money.setFont(new Font("宋体", Font.PLAIN, 20));
		money.setColumns(10);
		
		
		addUser.setFont(new Font("华文行楷", Font.PLAIN, 25));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(284)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblNewLabel_1_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblNewLabel_1_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblNewLabel_1_3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(addres, GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
								.addComponent(pwd, GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
								.addComponent(money)
								.addComponent(name, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(367)
							.addComponent(addUser, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(50)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 798, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(132, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
					.addGap(33)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(name, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addComponent(pwd, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1_2, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addComponent(addres, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1_3, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addComponent(money, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addGap(26)
					.addComponent(addUser, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(108, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO 自动生成的方法存根
		if(arg0.getActionCommand().equals("add")) {
			String str = name.getText();
			
			if((userSever.findUser(str))==null) {
				UserData user = new UserData(str,pwd.getText(),addres.getText(),Float.parseFloat(money.getText()));
				userSever.creatUser(user);
				System.out.println("用户添加成功");
			}
			else {
				JOptionPane.showMessageDialog(this, "该用户名已被占用！");
			}
		}
	}

}
