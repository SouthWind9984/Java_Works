package bookShopUi;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import dao.BookDao;
import dao.UserDao;

import javax.swing.JPasswordField;

public class BookStore extends JFrame implements ActionListener, ItemListener, WindowListener {
	private BookDao bookDao = new BookDao();
	private UserDao userDao = new UserDao();
	private JPanel contentPane;
	JMenuItem showbook = new JMenuItem("查看所有书籍");
	JMenuItem findbook = new JMenuItem("查找书籍");
	JMenuItem pay = new JMenuItem("购买书籍");
	JMenuItem updata = new JMenuItem("信息修改");
	JMenuItem money = new JMenuItem("余额充值");
	JMenuItem exit = new JMenuItem("退出登陆");

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					BookStore frame = new BookStore();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
/**
 * 添加事件监控
 */
	public void monitor() {
		showbook.addActionListener(this);
		showbook.setActionCommand("show");
		
//		showbook.addItemListener(this);
		
		findbook.addActionListener(this);
		findbook.setActionCommand("find");
		
		pay.addActionListener(this);
		pay.setActionCommand("pay");
		
		updata.addActionListener(this);
		updata.setActionCommand("updata");
		
		money.addActionListener(this);
		money.setActionCommand("money");
		
		exit.addActionListener(this);
		exit.setActionCommand("exit");
		
		this.addWindowListener(this);
		
	}
	
	/**
	 * Create the frame.
	 */
	public BookStore() {
		monitor();//实现监听
		//数据
//		bookDao.inputBook();//写入
		setTitle("小小怪图书商城—By丶SouthWind");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 520);
		setLocation((int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth() - this.getWidth()) / 2,
				(int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() - this.getHeight()) / 2);//居中显示窗体
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(173, 216, 230));
		setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("Menu");
		mnNewMenu.setFont(new Font("Dialog", Font.PLAIN, 20));
		mnNewMenu.setHorizontalAlignment(SwingConstants.CENTER);
		menuBar.add(mnNewMenu);

		mnNewMenu.add(showbook);

		mnNewMenu.add(findbook);

		mnNewMenu.add(pay);

		JMenu mnNewMenu_1 = new JMenu("Info");
		mnNewMenu_1.setHorizontalAlignment(SwingConstants.RIGHT);
		mnNewMenu_1.setFont(new Font("Dialog", Font.PLAIN, 20));
		menuBar.add(mnNewMenu_1);
		mnNewMenu_1.add(updata);

		mnNewMenu_1.add(money);

		mnNewMenu_1.add(exit);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGap(0, 772, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGap(0, 432, Short.MAX_VALUE)
		);
		contentPane.setLayout(gl_contentPane);

	}
	//刷新面板
	public void fulsh() {
		contentPane.setVisible(false);
		contentPane.removeAll();
		contentPane.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		if(e.getActionCommand()=="show")
		{
//			System.out.println("action");
			ShowBook showbook = new ShowBook();
			fulsh();
			contentPane.add(showbook);
		}
		if(e.getActionCommand().equals("find")) {
			FindBook findbook = new FindBook();
			fulsh();
			contentPane.add(findbook);
		}
		if(e.getActionCommand().equals("pay")) {
			Cart cart = new Cart();
			fulsh();
			contentPane.add(cart);
		}
		if(e.getActionCommand().equals("updata")) {
			Info info = new Info();
			fulsh();
			contentPane.add(info);
		}
		if(e.getActionCommand().equals("money")) {
			Recharge recharge = new Recharge();
			fulsh();
			contentPane.add(recharge);
		}
		if(e.getActionCommand().equals("exit")) {
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
	public void itemStateChanged(ItemEvent arg0) {
		// TODO 自动生成的方法存根
		if(arg0.getSource().equals("show")) {
//			System.out.println("item");
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
