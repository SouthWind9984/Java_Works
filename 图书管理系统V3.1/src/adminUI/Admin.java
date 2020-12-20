package adminUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import bookShopUi.Login;
import dao.BookDao;
import dao.UserDao;

public class Admin extends JFrame implements ActionListener, WindowListener {
	private BookDao bookDao = new BookDao();
	private UserDao userDao = new UserDao();
	//所需组件
	private JPanel contentPane;
	JMenuItem addBook = new JMenuItem("增加图书");
	JMenuItem showBook = new JMenuItem("浏览图书");
	JMenuItem updataBook = new JMenuItem("更新图书");
	JMenuItem deleteBook = new JMenuItem("删除图书");
	
	JMenuItem addUser = new JMenuItem("增加用户");
	JMenuItem showUser = new JMenuItem("查看用户");
	JMenuItem updataUser = new JMenuItem("更新用户");
	JMenuItem deleteUser = new JMenuItem("删除用户");
	
	JMenuItem intro = new JMenuItem("本程序简介");
	private final JMenuItem exist = new JMenuItem("退出登陆");
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Admin frame = new Admin();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
	
	/**
	 * 	添加监听事件
	 */
	
	public void montior() {
		addBook.addActionListener(this);
		addBook.setActionCommand("addBook");
		
		showBook.addActionListener(this);
		showBook.setActionCommand("showBook");
		
		updataBook.addActionListener(this);
		updataBook.setActionCommand("updataBook");
		
		deleteBook.addActionListener(this);
		deleteBook.setActionCommand("deleteBook");
		
		addUser.addActionListener(this);
		addUser.setActionCommand("addUser");
		
		showUser.addActionListener(this);
		showUser.setActionCommand("showUser");
		
		updataUser.addActionListener(this);
		updataUser.setActionCommand("updataUser");
		
		deleteUser.addActionListener(this);
		deleteUser.setActionCommand("deleteUser");
		
		intro.addActionListener(this);
		intro.setActionCommand("intro");
	
		exist.addActionListener(this);
		exist.setActionCommand("exist");
		
		this.addWindowListener(this);
	}

	/**
	 * Create the frame.
	 */
	public Admin() {
		montior();	//实现监听事件
		setTitle("图书商城管理系统—By丶SouthWind");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 521);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("图书管理");
		mnNewMenu.setFont(new Font("华文行楷", Font.ITALIC, 25));
		menuBar.add(mnNewMenu);
		
		
		addBook.setForeground(new Color(245, 245, 245));
		addBook.setHorizontalAlignment(SwingConstants.CENTER);
		addBook.setBackground(new Color(255, 69, 0));
		addBook.setFont(new Font("华文隶书", Font.ITALIC, 18));
		mnNewMenu.add(addBook);
		
		
		showBook.setForeground(new Color(0, 0, 51));
		showBook.setHorizontalAlignment(SwingConstants.CENTER);
		showBook.setBackground(new Color(245, 255, 250));
		showBook.setFont(new Font("华文隶书", Font.ITALIC, 18));
		mnNewMenu.add(showBook);
		
		
		updataBook.setForeground(new Color(245, 255, 250));
		updataBook.setHorizontalAlignment(SwingConstants.CENTER);
		updataBook.setBackground(new Color(255, 69, 0));
		updataBook.setFont(new Font("华文隶书", Font.ITALIC, 18));
		mnNewMenu.add(updataBook);
		
		
		deleteBook.setForeground(new Color(0, 0, 51));
		deleteBook.setHorizontalAlignment(SwingConstants.CENTER);
		deleteBook.setBackground(new Color(248, 248, 255));
		deleteBook.setFont(new Font("华文隶书", Font.ITALIC, 18));
		mnNewMenu.add(deleteBook);
		
		JMenu mnNewMenu_1 = new JMenu("用户管理");
		mnNewMenu_1.setFont(new Font("华文行楷", Font.PLAIN, 25));
		menuBar.add(mnNewMenu_1);
		
		
		addUser.setForeground(new Color(224, 255, 255));
		addUser.setBackground(new Color(255, 0, 51));
		addUser.setFont(new Font("华文隶书", Font.ITALIC, 18));
		mnNewMenu_1.add(addUser);
		
		
		showUser.setBackground(new Color(245, 255, 250));
		showUser.setFont(new Font("华文隶书", Font.ITALIC, 18));
		mnNewMenu_1.add(showUser);
		
		
		updataUser.setForeground(new Color(224, 255, 255));
		updataUser.setBackground(new Color(255, 0, 51));
		updataUser.setFont(new Font("华文隶书", Font.ITALIC, 18));
		mnNewMenu_1.add(updataUser);
		
		
		deleteUser.setBackground(new Color(245, 255, 250));
		deleteUser.setFont(new Font("华文隶书", Font.ITALIC, 18));
		mnNewMenu_1.add(deleteUser);
		
		JMenu mnNewMenu_2 = new JMenu("关于");
		mnNewMenu_2.setFont(new Font("华文行楷", Font.PLAIN, 25));
		menuBar.add(mnNewMenu_2);
		
		
		intro.setFont(new Font("华文隶书", Font.ITALIC, 18));
		mnNewMenu_2.add(intro);
		exist.setFont(new Font("华文隶书", Font.PLAIN, 18));
		
		mnNewMenu_2.add(exist);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGap(0, 972, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGap(0, 434, Short.MAX_VALUE)
		);
		contentPane.setLayout(gl_contentPane);
//		System.out.println(contentPane.getHeight());
//		System.out.println(contentPane.getWidth());
		setLocation((int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth() - this.getWidth()) / 2,
				(int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() - this.getHeight()) / 2);//居中显示窗体
	}
	public void fulsh() {
		contentPane.setVisible(false);
		contentPane.removeAll();
		contentPane.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		if(e.getActionCommand().equals("showBook")) {
			ShowAllBook showAllBook = new ShowAllBook();
			fulsh();
			contentPane.add(showAllBook);
			
		}
		if(e.getActionCommand().equals("addBook")) {
			AddBook addBook = new AddBook();
			fulsh();
			contentPane.add(addBook);
		}
			
		if(e.getActionCommand().equals("updataBook")) {
			FindAndUpdata findAndUpdata = new FindAndUpdata();
			fulsh();
			contentPane.add(findAndUpdata);
		}
		if(e.getActionCommand().equals("deleteBook")) {
			DeleteBook deleteBook = new DeleteBook();
			fulsh();
			contentPane.add(deleteBook);
		}
		if(e.getActionCommand().equals("addUser")) {
			AddUser addUser = new AddUser();
			fulsh();
			contentPane.add(addUser);
		}
		if(e.getActionCommand().equals("showUser")) {
			ShowAllUser showAllUser = new ShowAllUser();
			fulsh();
			contentPane.add(showAllUser);
		}
		if(e.getActionCommand().equals("updataUser")) {
			FindUser findUser = new FindUser();
			fulsh();
			contentPane.add(findUser);
		}
		if(e.getActionCommand().equals("deleteUser")) {
			DelUser deleuser = new DelUser();
			fulsh();
			contentPane.add(deleuser);
		}
		if(e.getActionCommand().equals("intro")) {
			Intro intro = new Intro();
			fulsh();
			contentPane.add(intro);
		}
		if(e.getActionCommand().equals("exist")) {
			int n=JOptionPane.showConfirmDialog(this,"确定要退出吗？","退出提示",1,2);
			if(n==0) {
				Login log = new Login();
				log.setVisible(true);
				dispose();
				userDao.outputUser();
				bookDao.outputBook();
			}
		}
		
	}

	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO 自动生成的方法存根
		if(e.getSource()==this) {
			System.out.println("窗口关闭");
			userDao.outputUser();
			bookDao.outputBook();
		}
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO 自动生成的方法存根
		
	}

}
