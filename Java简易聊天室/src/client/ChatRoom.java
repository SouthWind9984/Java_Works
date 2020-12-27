package client;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;

import server.Server;
import tool.CsContent;

public class ChatRoom extends JFrame implements ActionListener,Runnable, KeyListener{
	//创建客户端
	Socket clientSocket = new Socket("127.0.0.1",8888);

	Scanner in = new Scanner(System.in);
	private JPanel contentPane;
	JTextArea Mesg = new JTextArea();
	JButton send = new JButton("回车发送信息");
	JTextArea Show = new JTextArea();
	JScrollPane scrollPane = new JScrollPane();
	JButton clear = new JButton("清空屏幕");
	JTextArea userlist = new JTextArea();
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ChatRoom frame = new ChatRoom();
//					frame.setVisible(true);
//					new Thread(frame ).start();
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
 
	
	
	public void monitor() {
		send.addActionListener(this);
		send.setActionCommand("send");
		clear.addActionListener(this);
		clear.setActionCommand("clear");
		Mesg.addKeyListener(this);
	}
	/**
	 * Create the frame.
	 * @throws IOException 
	 * @throws  
	 */
	public ChatRoom() throws Exception {
		monitor();//添加监听事件
		setTitle("客户端");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 625, 530);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(36, 25, 397, 297);
		contentPane.add(scrollPane);
		Show.setFont(new Font("Monospaced", Font.PLAIN, 16));
		
		
		Show.setText("欢迎"+Login.NAME+"进入小小怪聊天室"+"\n");
		Show.setRows(10);
		Show.setColumns(10);
		Show.setBackground(new Color(255, 250, 240));
		scrollPane.setViewportView(Show);
		
		
		send.setForeground(new Color(255, 250, 250));
		send.setFont(new Font("华文隶书", Font.PLAIN, 18));
		send.setBackground(new Color(100, 149, 237));
		send.setBounds(457, 423, 125, 36);
		contentPane.add(send);
		
		
		Mesg.setText("在这里发送消息！");
		Mesg.setFont(new Font("华文中宋", Font.PLAIN, 14));
		Mesg.setBackground(new Color(220, 220, 220));
		Mesg.setBounds(36, 392, 397, 67);
		contentPane.add(Mesg);
		
		
		clear.setBackground(SystemColor.info);
		clear.setBounds(320, 335, 113, 27);
		contentPane.add(clear);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(457, 25, 136, 252);
		contentPane.add(scrollPane_1);
		
		
		userlist.setBackground(new Color(255, 250, 240));
		userlist.setFont(new Font("Monospaced", Font.PLAIN, 18));
		userlist.setText("  当前用户列表"+"\n");
//		userlist.append("暂时无法显示");
		scrollPane_1.setViewportView(userlist);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(ChatRoom.class.getResource("/img/logBj.jpg")));
		lblNewLabel.setBounds(164, 78, 475, 405);
		contentPane.add(lblNewLabel);
		setLocation((int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth() - this.getWidth()) / 2,
				(int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() - this.getHeight()) / 2);//居中显示窗体
//		//创建接收线程
//		ReceiveThread rt = new ReceiveThread(clientSocket);
//		rt.start();//启动线程
		new Thread(this).start();
		for(String name:Login.users) {
			userlist.append(name+"\n");
		}
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		if(e.getActionCommand().equals("send")) {
			String msg=Mesg.getText();
			OutputStream out;
			try {
				out = clientSocket.getOutputStream();
				PrintStream ps = new PrintStream(out);
				Date date = new Date();
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
				System.out.println(formatter.format(date));  
				 ps.println(formatter.format(date)+"\n"+Login.NAME+":"+msg); 
			} catch (IOException e1) {
				// TODO 自动生成的 catch 块
				System.out.println("发送错误！");
			}
			Mesg.setText("");     
		}
		if(e.getActionCommand().equals("clear"))
		{
			Show.setText("");
		}
	}
	public void fulsh() {
//		contentPane.setVisible(false);
//		contentPane.remove(scrollPane);
//		contentPane.add(scrollPane);
//		contentPane.setVisible(true);
//		scrollPane.setViewportView(Show);
		this.setVisible(true);
	}


	CsContent csc = new CsContent();
	@Override
	public void run() {
		// TODO 自动生成的方法存根
		while(true) {
			
			String str =csc.receiveMessage(clientSocket);
			Show.append(str+"\n");
			
			
			
			fulsh();
//			scrollPane.setViewportView(Show);
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
		if(arg0.getKeyChar()==KeyEvent.VK_ENTER) {
			String msg=Mesg.getText();
			OutputStream out;
			try {
				out = clientSocket.getOutputStream();
				PrintStream ps = new PrintStream(out);
				Date date = new Date();
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
				System.out.println(formatter.format(date));  
				 ps.println(formatter.format(date)+"\n"+Login.NAME+":"+msg); 
			} catch (IOException e1) {
				// TODO 自动生成的 catch 块
				System.out.println("发送错误！");
			}
			Mesg.setText(""); 
		}
	}
}
