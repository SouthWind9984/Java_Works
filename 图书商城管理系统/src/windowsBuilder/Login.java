package windowsBuilder;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import adminUI.Admin;
import dao.BookDao;
import dao.UserDao;
import entity.UserData;
import severice.UserSever;
import ui.Reg;

public class Login extends JFrame implements ActionListener, ItemListener{
	
	//创建业务处理对象
	private UserSever userSever = new UserSever();
//	private UserDao userdao = new UserDao();
	//添加组件
	private JPanel contentPane;
	private JTextField name;
	private JPasswordField pwd;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	JButton login = new JButton("登陆");
	JButton reg = new JButton("快速注册》");
	JRadioButton user = new JRadioButton("用户",true);
	JRadioButton admin = new JRadioButton("管理员");
	int ua = 0;
	static String NAME =null;
	//添加监听事件
	public void monitor() {
		login.addActionListener(this);
		login.setActionCommand("login");
		
		reg.addActionListener(this);
		reg.setActionCommand("reg");
		
		user.addItemListener(this);
		admin.addItemListener(this);

	}
	//构造函数
	public Login() {
		monitor();//实现监听
//		userdao.inputUser();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 321);
		setLocation((int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth() - this.getWidth()) / 2,
					(int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() - this.getHeight()) / 2);//居中显示窗体
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("小小怪图书商城");
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setFont(new Font("幼圆", Font.PLAIN, 24));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(250, 240, 230));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(139)
							.addComponent(lblNewLabel))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(panel, GroupLayout.DEFAULT_SIZE, 465, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addGap(13)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE))
		);
		
		JLabel lblNewLabel_1 = new JLabel("登陆窗口");
		lblNewLabel_1.setForeground(new Color(0, 206, 209));
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 18));
		
		JLabel lblNewLabel_2 = new JLabel("用户名：");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 16));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblNewLabel_3 = new JLabel("密码：");
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 16));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		
		name = new JTextField();
		name.setColumns(10);
		name.setHorizontalAlignment(SwingConstants.CENTER);
		name.setFont(new Font("华文隶书", Font.PLAIN, 20));
		name.setColumns(10);
		
		pwd = new JPasswordField();

		
		
		login.setFont(new Font("宋体", Font.PLAIN, 18));
		login.setForeground(new Color(255, 69, 0));
		
		
		reg.setBackground(new Color(255, 255, 255));
		reg.setForeground(new Color(153, 50, 204));
		
		
		buttonGroup.add(user);
		
	
		buttonGroup.add(admin);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(169)
					.addComponent(lblNewLabel_1)
					.addGap(114))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(121)
					.addComponent(login)
					.addPreferredGap(ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
					.addComponent(reg)
					.addContainerGap())
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(70)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(lblNewLabel_3, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblNewLabel_2, Alignment.LEADING))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addComponent(pwd)
						.addComponent(name, GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE))
					.addContainerGap(147, Short.MAX_VALUE))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(138)
					.addComponent(user)
					.addGap(18)
					.addComponent(admin)
					.addContainerGap(156, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(5)
					.addComponent(lblNewLabel_1)
					.addPreferredGap(ComponentPlacement.RELATED, 6, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(admin)
						.addComponent(user))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(name, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(34)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3)
						.addComponent(pwd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(login)
						.addComponent(reg))
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		
		if(e.getActionCommand().equals("login")) {
			switch (ua) {
			case 0: //用户登陆判断
				UserData user = new UserData();
				if((user=userSever.findUser(name.getText()))==null) 
				{
					System.out.println(user);
					JOptionPane.showMessageDialog(this, "用户名不存在！");
				}
				else
				{
					if(user.getPasswd().equals(new String(pwd.getPassword()))) {
						JOptionPane.showMessageDialog(this, "登陆成功！");
						NAME=user.getName();
						BookStore bookStore = new BookStore();
						bookStore.setVisible(true);
						dispose();
					}
					else {
						JOptionPane.showMessageDialog(this, "密码错误！");
					}
				}
				break;
			case 1: //管理员判断                                                        
				if(name.getText().equals("admin")) {
					if(new String(pwd.getPassword()).equals("admin")) {
						JOptionPane.showMessageDialog(this, "登陆成功！");
						Admin admin = new Admin();
						admin.setVisible(true);
						dispose();
					}
						
					else
						JOptionPane.showMessageDialog(this, "密码错误！");
				}
				else {
					JOptionPane.showMessageDialog(this, "非管理员禁止登陆！");
				}
				break;
			}
		}
		if(e.getActionCommand().equals("reg")) {
			//创建注册窗体
			Reg regg = new Reg();
			regg.setVisible(true);
//			this.setVisible(false);//隐藏当前注册窗体
			dispose();
		}
	}
	@Override
	public void itemStateChanged(ItemEvent arg0) {
		// TODO 自动生成的方法存根
		if(arg0.getSource()==user) {
			ua=0;
		}
		if(arg0.getSource()==admin) {
			ua=1;
		}
	}
}
