package client;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.List;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import dao.Userdao;
import entity.User;

public class Login extends JFrame implements ActionListener, KeyListener {
	 static ArrayList<String> users = new ArrayList<String>();
	private Userdao userdao = new Userdao();
	private JPanel contentPane;
	private JTextField name;
	private JPasswordField pwd;
	JButton login = new JButton("登陆");
	JButton reg = new JButton("注册>>");
	static String NAME ="";
	public String getName() {
		return NAME;
	}

	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void monitor() {
		login.addActionListener(this);
		login.setActionCommand("login");
		login.addKeyListener(this);
		reg.addActionListener(this);
		reg.setActionCommand("reg");
	}
	/**
	 * Create the frame.
	 */
	public Login() {
		monitor();
		userdao.inputUser();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 457, 346);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		login.setFocusPainted(false);
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		login.setForeground(new Color(0, 0, 51));
		login.setBackground(new Color(204, 255, 255));
		login.setFont(new Font("华文楷体", Font.PLAIN, 24));
		login.setBounds(158, 222, 113, 27);
		contentPane.add(login);
		
		JLabel lblNewLabel_1 = new JLabel("小小怪聊天室");
		lblNewLabel_1.setFont(new Font("华文隶书", Font.PLAIN, 25));
		lblNewLabel_1.setBounds(144, 13, 166, 36);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("用户名：");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setFont(new Font("新宋体", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(85, 91, 72, 18);
		contentPane.add(lblNewLabel_2);
		
		name = new JTextField();
		name.setFont(new Font("宋体", Font.PLAIN, 18));
		name.setBounds(171, 90, 166, 24);
		contentPane.add(name);
		name.setColumns(10);
		
		JLabel lblNewLabel_2_1 = new JLabel("密码：");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2_1.setFont(new Font("新宋体", Font.PLAIN, 18));
		lblNewLabel_2_1.setBounds(85, 159, 72, 18);
		contentPane.add(lblNewLabel_2_1);
		
		pwd = new JPasswordField();
		pwd.setBackground(new Color(255, 255, 255));
		pwd.setEchoChar('*');
		pwd.setFont(new Font("宋体", Font.PLAIN, 18));
		pwd.setBounds(171, 158, 166, 24);
		contentPane.add(pwd);
		
		
		reg.setBorderPainted(false);
		reg.setForeground(new Color(0, 0, 51));
		reg.setSelectedIcon(new ImageIcon(Login.class.getResource("/img/logBj.jpg")));
		reg.setBackground(new Color(255, 255, 255));
		reg.setBounds(0, 272, 113, 27);
		contentPane.add(reg);
		
		JLabel BJ = new JLabel("");
		BJ.setIcon(new ImageIcon(Login.class.getResource("/img/logBj.jpg")));
		BJ.setBounds(0, 0, 439, 299);
		contentPane.add(BJ);
		
		ImageIcon img = new ImageIcon("src//img//LoginBackgroud.jpg");
		setLocation((int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth() - this.getWidth()) / 2,
				(int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() - this.getHeight()) / 2);//居中显示窗体
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		if(e.getActionCommand().equals("login")) {
			if(name.getText().length()==0) {
				JOptionPane.showMessageDialog(this, "用户名不能为空！");
			}
			else if(pwd.getPassword().toString().length()==0) {
				JOptionPane.showMessageDialog(this, "密码不能为空！");
			}
			else {
				String name1 = name.getText();
				boolean flag = false;
				for(User user : userdao.showUser()) {
					if(user.getName().equals(name1)) {
						flag=true;
//						for (String str : users) {
//							if(name1==str) {
//								JOptionPane.showMessageDialog(this, "该用户已经登陆！");
//								flag=false;
//								break;
//							}
//						}
//						if((Server.findUSer(user.getName()))!=null) {
//							JOptionPane.showMessageDialog(this, "该用户已经登陆！");
//							flag=false;
//							break;
//						}
//						if(flag) {
							String pwd1 = new String(pwd.getPassword());
							if(user.getPwd().equals(pwd1)) {
								JOptionPane.showMessageDialog(this, "登陆成功！");
								
								NAME=user.getName();
								users.add(user.getName());
//								Server.userList.add(user.getName());
								ChatRoom chatRoom;
								try {
									chatRoom = new ChatRoom();
									chatRoom.setVisible(true);
									dispose();
								} catch (Exception e1) {
									// TODO 自动生成的 catch 块
									e1.printStackTrace();
								}
								
							}
							else {
								JOptionPane.showMessageDialog(this, "密码错误！");
							}
//						}
					}
				}
				if(!flag)
				JOptionPane.showMessageDialog(this, "用户不存在！");
			}
		}
		if(e.getActionCommand().equals("reg")) {
			Reg reg = new Reg();
			reg.setVisible(true);
			dispose();
		}
	}



	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO 自动生成的方法存根
		
	}



	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO 自动生成的方法存根
		
	}



	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO 自动生成的方法存根

	}
}
