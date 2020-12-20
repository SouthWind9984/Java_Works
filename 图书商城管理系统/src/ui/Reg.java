package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import dao.UserDao;
import entity.UserData;
import severice.UserSever;

public class Reg extends JFrame implements ActionListener{
	
	//创建业务处理对象
	private UserSever userSever = new UserSever();
	private UserDao userdao = new UserDao();
	//添加组件
	private JPanel contentPane;
	private JTextField name;
	private JPasswordField pwd1;
	private JPasswordField pwd2;
	private JTextField address;
	private JButton reg = new JButton("Register");
	private JButton login = new JButton("返回登陆》");
	
	//添加监听事件
	public void monitor() {
		reg.addActionListener(this);
		reg.setActionCommand("reg");
		
		login.addActionListener(this);
		login.setActionCommand("login");
		
	}
	//空参构造
	public Reg() {
		monitor();//加入监听事件
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 521, 431);
		setLocation((int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth() - this.getWidth()) / 2,
				(int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() - this.getHeight()) / 2);//居中显示窗体
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("小小怪图书商城");
		lblNewLabel.setForeground(new Color(255, 69, 0));
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 26));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(248, 248, 255));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(150)
					.addComponent(lblNewLabel)
					.addContainerGap(38, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(58, Short.MAX_VALUE)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 365, GroupLayout.PREFERRED_SIZE)
					.addGap(70))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 279, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		JLabel lblNewLabel_1 = new JLabel("注册窗口");
		lblNewLabel_1.setForeground(new Color(255, 69, 0));
		lblNewLabel_1.setFont(new Font("幼圆", Font.PLAIN, 20));
		
		JLabel lblNewLabel_2 = new JLabel("用户名：");
		lblNewLabel_2.setFont(new Font("华文隶书", Font.PLAIN, 18));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblNewLabel_3 = new JLabel("密码：");
		lblNewLabel_3.setFont(new Font("华文隶书", Font.PLAIN, 18));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblNewLabel_4 = new JLabel("确认密码：");
		lblNewLabel_4.setFont(new Font("华文隶书", Font.PLAIN, 18));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblNewLabel_5 = new JLabel("地址：");
		lblNewLabel_5.setFont(new Font("华文隶书", Font.PLAIN, 18));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		
		name = new JTextField();
		name.setColumns(10);
		
		pwd1 = new JPasswordField();
		
		pwd2 = new JPasswordField();
		
		address = new JTextField();
		address.setColumns(10);
		
		
		reg.setForeground(new Color(165, 42, 42));
		reg.setFont(new Font("华文宋体", Font.PLAIN, 22));
		
		
		login.setForeground(new Color(147, 112, 219));
		login.setBackground(Color.WHITE);
		login.setFont(new Font("宋体", Font.PLAIN, 16));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(156)
					.addComponent(lblNewLabel_1))
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(26)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_panel.createSequentialGroup()
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
										.addComponent(lblNewLabel_3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(lblNewLabel_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
									.addGap(18)
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
										.addComponent(name)
										.addComponent(pwd1, GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)))
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(8)
									.addComponent(lblNewLabel_5)
									.addGap(28)
									.addComponent(address, GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE))))
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(pwd2)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addContainerGap(88, Short.MAX_VALUE)
					.addComponent(reg, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(login)
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_1)
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(name, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(31)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3)
						.addComponent(pwd1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(30)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(pwd2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_4))
					.addGap(36)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(address, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_5))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(login)
						.addComponent(reg))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		if(e.getActionCommand().equals("reg")) {
			if(name.getText().length()<3) {
				JOptionPane.showMessageDialog(this, "用户名不能少于3个字符！");
			}
			else if(new String (pwd1.getPassword()).length()<6) {
				JOptionPane.showMessageDialog(this, "密码至少6位");
			}
			else if(!(new String(pwd1.getPassword()).equals((new String(pwd2.getPassword()))))) {
				JOptionPane.showMessageDialog(this, "两次密码不相等");
			}
			else if(address.getText().length()==0) {
				JOptionPane.showMessageDialog(this, "地址不能为空");
			}
			else {
				UserData user = new UserData(name.getText(),new String(pwd1.getPassword()),address.getText(),0f);
				if(userSever.creatUser(user))
				{
					JOptionPane.showMessageDialog(this, "注册成功！");
					userdao.outputUser();
				}
				else
					JOptionPane.showMessageDialog(this, "用户名存在，注册失败！");
			}
		}
		if(e.getActionCommand().equals("login")) {
			//显示登陆窗口
			windowsBuilder.Login login = new windowsBuilder.Login();
			login.setVisible(true);
			dispose();
		}
	}
}
