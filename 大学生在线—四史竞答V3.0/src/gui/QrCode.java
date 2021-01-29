package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import longin.SavePhoto;

public class QrCode extends JFrame implements WindowListener {

	private JPanel contentPane;
	
	

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public QrCode(String filename) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(QrCode.class.getResource("/img/微信图片_20200608191955.jpg")));
		this.addWindowListener(this);
		setTitle("大学生在线—四史竞答V3.0");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 388, 350);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		filename=filename.replaceAll("https://node2d-public.hep.com.cn/wxapp/qrcode/", "");
		String filepath = SavePhoto.class.getClassLoader().getResource("").getPath();
		try {
			filepath = URLDecoder.decode(filepath, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		filepath=filepath.replaceAll("file:/", "")+"Qrcode//"+filename;
		ImageIcon img = new ImageIcon(filepath);
		img.setImage(img.getImage().getScaledInstance(260,260,Image.SCALE_DEFAULT));
		
		JLabel lblNewLabel_1 = new JLabel("请使用微信扫码登陆");
		lblNewLabel_1.setForeground(new Color(169, 169, 169));
		lblNewLabel_1.setBackground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 17));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 280, 355, 25);
		contentPane.add(lblNewLabel_1);
		JLabel QR =new JLabel(img);
		QR.setBounds(58, 10, 260, 260);
		contentPane.add(QR);
		setLocation((int)(Toolkit.getDefaultToolkit().getScreenSize().getWidth()-this.getWidth())/2,
				(int)(Toolkit.getDefaultToolkit().getScreenSize().getHeight()-this.getHeight())/2 );
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
	public void windowClosing(WindowEvent arg0) {
		// TODO 自动生成的方法存根
		Font font = new Font("楷体", 0, 16);
		JLabel	mesg = new JLabel("<html><body>"
				+"登陆取消，软件将自动关闭！<br>"
				+"<body></html>");
		mesg.setFont(font);
//		mesg.setBounds(10, 280, 355, 25);
		JOptionPane.showMessageDialog(null,mesg
				,"关闭提醒",1);
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
