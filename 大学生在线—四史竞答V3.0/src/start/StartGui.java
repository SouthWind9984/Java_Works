package start;

import java.awt.Font;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import gui.CollegeUI;
import gui.QrCode;
import longin.GetQRCode;
import longin.GetToken;
import longin.GetUID;
import longin.SavePhoto;

public class StartGui {

	private static String token ="";
	public String getToken() {
		return token;
	}
	public static void main(String[] args) {
		// TODO 自动生成的方法存根

		HashMap<Integer, String> qrMap = new HashMap<Integer, String>();
		try {
			qrMap=GetQRCode.SendRandom();
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		Font font = new Font("华文楷体", 0, 18);
		JLabel	mesg = new JLabel("<html><body>"
				+"大学生在线—四史竞答V3.0 更新：<br>"
				+ "1.新增GUI界面；<br>"
				+ "2.增加多板块答题方式；<br>"
				+ "3.取消Token登陆方式；<br>"
				+ "4.增加用户微信扫码登陆。<br><br>"
				+ "若登陆二维码不显示，尝试重新打开软件<br>"
				+ "ps:该程序仅供学习交流，禁止用于商业获取利益！<br>"
				+"<body></html>");
		mesg.setFont(font);
//		mesg.setBounds(10, 280, 355, 25);
		JOptionPane.showMessageDialog(null,mesg
				,"使用提示",JOptionPane.PLAIN_MESSAGE);
		int random=0;
		String photo="";
		for(Entry<Integer, String> entry : qrMap.entrySet()) {
			random=entry.getKey();
			photo=entry.getValue();
		}
//		System.out.println(random);
//		System.out.println(photo);
		try {
			//保存图片
			SavePhoto savePhoto = new SavePhoto(photo);
		} catch (IOException e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		}
		QrCode qrCode = new QrCode(photo);
		qrCode.setVisible(true);
		
		GetUID getUID = new GetUID();
		getUID.setRandom(random);
		String uid = "";
		String hard_photo="";
		Thread getuid = new Thread(getUID);
		getuid.start();
		Goto:
		while(true) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			uid=getUID.getUid();
			hard_photo=getUID.getHard_photo();
			if (uid!=null) {
				getuid.stop();
				qrCode.dispose();
				break Goto;
			}
		}
		try {
			//获取token
			token=GetToken.getToken(uid, hard_photo);
			
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		CollegeUI frame;
		try {
			frame = new CollegeUI();
			frame.setVisible(true);
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	
	}

}
