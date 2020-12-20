package bookShopUi;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;

import entity.UserData;
import severice.UserSever;

public class Recharge extends JPanel implements ActionListener, ItemListener {
	//创建业务对象
	private UserSever userSever = new UserSever();
	//所需组件
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField money;
	JLabel payment = new JLabel("");
	JButton pay = new JButton("支付");
	JRadioButton wx = new JRadioButton("微信支付");
	JRadioButton zfb = new JRadioButton("支付宝");
	//监听事件
	public void montior() {
		pay.addActionListener(this);
		pay.setActionCommand("pay");
		
		wx.addItemListener(this);
		zfb.addItemListener(this);
	}
	
	/**
	 * Create the panel.
	 */
	public Recharge() {
		montior();//实现监听
		
		setSize(785,450);
		
		JLabel lblNewLabel = new JLabel("充值中心");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(205, 92, 92));
		lblNewLabel.setFont(new Font("华文彩云", Font.PLAIN, 35));
		
		
		wx.setSelected(true);
		wx.setFont(new Font("方正舒体", Font.ITALIC, 25));
		buttonGroup.add(wx);
		
		
		zfb.setFont(new Font("方正舒体", Font.ITALIC, 25));
		buttonGroup.add(zfb);
		
		JLabel lblNewLabel_1 = new JLabel("充值金额：");
		lblNewLabel_1.setFont(new Font("华文行楷", Font.PLAIN, 25));
		
		money = new JTextField();
		money.setFont(new Font("微软雅黑 Light", Font.PLAIN, 20));
		money.setColumns(10);
		
		
		pay.setBackground(new Color(95, 158, 160));
		pay.setForeground(new Color(255, 99, 71));
		pay.setFont(new Font("华文楷体", Font.PLAIN, 28));
		
		
		payment.setIcon(new ImageIcon(Recharge.class.getResource("/Photo/微信.jpg")));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(payment)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 420, GroupLayout.PREFERRED_SIZE)
									.addContainerGap())
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(79)
									.addComponent(lblNewLabel_1)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(money, GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
									.addGap(50)))
							.addGroup(groupLayout.createSequentialGroup()
								.addGap(144)
								.addComponent(pay, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE)
								.addContainerGap()))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(102)
							.addComponent(wx)
							.addGroup(groupLayout.createSequentialGroup()
								.addGap(18)
								.addComponent(zfb))
							.addContainerGap())))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(16)
							.addComponent(lblNewLabel)
							.addGap(42)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(zfb)
								.addComponent(wx))
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_1)
								.addComponent(money, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(46)
							.addComponent(pay, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
							.addGap(87))
						.addComponent(payment, GroupLayout.PREFERRED_SIZE, 401, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(36, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
	}
	
	public void fulsh() {
		this.setVisible(false);
		this.setVisible(true);
	}
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO 自动生成的方法存根
		if(e.getSource()==wx) {
			payment.setIcon(new ImageIcon(Recharge.class.getResource("/Photo/微信.jpg")));
			fulsh();
		}
			
		if(e.getSource()==zfb) {
			payment.setIcon(new ImageIcon(Recharge.class.getResource("/Photo/支付宝.jpg")));
			fulsh();
		}
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		if(e.getActionCommand().equals("pay")) {
			if(Integer.parseInt(money.getText())<0) {
				JOptionPane.showMessageDialog(this,"充值金额不能小于0","提示",1);
			}
			else {
					int n=JOptionPane.showConfirmDialog(this,"是否已经付款？","充值提示",0);
				if(n==0) {
					System.out.println("充值");
					for(int i=0;i<userSever.readUser().size();i++) {
						UserData user = userSever.readUser().get(i);
						if(user.getName().equals(Login.NAME)) {
							user.setMoney(user.getMoney()+Float.parseFloat(money.getText()));
							UserData user2=userSever.updataUser(user);
//							System.out.println(user2.getMoney());
						}
					}
				}
			}
		}
	}
}
