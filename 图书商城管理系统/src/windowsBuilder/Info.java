package windowsBuilder;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import severice.UserSever;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import entity.UserData;

public class Info extends JPanel implements ActionListener {
	//创建业务对象
	private UserSever usersever = new UserSever();
	//添加所需组件
	private JTextField pwd;
	private JTextField addres;
	private JLabel money = new JLabel("New label");
	private JLabel name = new JLabel("New label");
	private JButton updata = new JButton("提交修改");
	//添加监听事件
	public void montior() {
		updata.addActionListener(this);
		updata.setActionCommand("updata");
	}
	/**
	 * Create the panel.
	 */
	public Info() {
		montior();
		setSize(785,450);
		
		JLabel lblNewLabel = new JLabel("个人信息");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("华文彩云", Font.PLAIN, 30));
		
		JLabel lblNewLabel_1 = new JLabel("姓名：");
		lblNewLabel_1.setFont(new Font("微软雅黑 Light", Font.PLAIN, 20));
		
		JLabel lblNewLabel_2 = new JLabel("密码：");
		lblNewLabel_2.setFont(new Font("微软雅黑 Light", Font.PLAIN, 20));
		
		JLabel lblNewLabel_3 = new JLabel("地址：");
		lblNewLabel_3.setFont(new Font("微软雅黑 Light", Font.PLAIN, 20));
		
		JLabel lblNewLabel_4 = new JLabel("余额：");
		lblNewLabel_4.setFont(new Font("微软雅黑 Light", Font.PLAIN, 20));
		
		pwd = new JTextField();
		pwd.setHorizontalAlignment(SwingConstants.CENTER);
		pwd.setFont(new Font("微软雅黑 Light", Font.PLAIN, 20));
		pwd.setColumns(10);
		
		addres = new JTextField();
		addres.setHorizontalAlignment(SwingConstants.CENTER);
		addres.setFont(new Font("微软雅黑 Light", Font.PLAIN, 20));
		addres.setColumns(10);
		
	
		money.setHorizontalAlignment(SwingConstants.CENTER);
		money.setFont(new Font("微软雅黑 Light", Font.PLAIN, 20));
		
		
		updata.setFont(new Font("华文隶书", Font.PLAIN, 25));
		
	
		name.setHorizontalAlignment(SwingConstants.CENTER);
		name.setFont(new Font("微软雅黑 Light", Font.PLAIN, 20));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(237)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel_3)
							.addGap(18)
							.addComponent(addres, GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel_2)
							.addGap(18)
							.addComponent(pwd, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel_1)
							.addGap(18)
							.addComponent(name, GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel_4)
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(money, GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
								.addComponent(updata, GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE))))
					.addGap(328))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(34)
					.addComponent(lblNewLabel)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(name))
					.addGap(29)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(pwd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(34)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3)
						.addComponent(addres, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(29)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_4)
						.addComponent(money))
					.addGap(42)
					.addComponent(updata)
					.addContainerGap(77, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
		UserData user= usersever.findUser(Login.NAME);
		pwd.setText(user.getPasswd());
		
		addres.setText(user.getAddress());
		String s = "" + user.getMoney();
		name.setText(user.getName());
		money.setText(s);
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO 自动生成的方法存根
		if(arg0.getActionCommand().equals("updata")) {
			for(int i=0;i<usersever.readUser().size();i++) {
				UserData user =usersever.readUser().get(i);
				if(user.getName()==name.getText()) {
					user.setPasswd(pwd.getText());
					user.setAddress(addres.getText());
					usersever.updataUser(user);
					JOptionPane.showMessageDialog(this,"信息修改成功！","提示",1);
				}
			}
			
		}
	}

}
