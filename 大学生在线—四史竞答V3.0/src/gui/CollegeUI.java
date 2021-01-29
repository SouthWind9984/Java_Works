package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import entity.Answer;
import longin.GetUserInfo;
import net.sf.json.JSONArray;
import respond.GetAnswer;
import respond.GetQuestionInfor;
import respond.GetQuestions;
import respond.SubmitAnswer;
import respond.SubmitExPaper;
import start.StartGui;

public class CollegeUI extends JFrame implements ActionListener, WindowListener {

	private static JPanel contentPane;
	static JScrollPane scrollPane = new JScrollPane();
	static JTextArea txtrqq = new JTextArea();
	private JLabel name = new JLabel();
	private JLabel integral = new JLabel();
	private JLabel join = new JLabel();
	private static JButton submParper = new JButton("开始考试");
	private JButton flush = new JButton("刷新");
	
	//答题板块及次数
	static String token="";
	 static JComboBox answerBox = new JComboBox();
	static JSpinner Count = new JSpinner();
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					CollegeUI frame = new CollegeUI();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	public void jianting() {
		
		submParper.setIcon(null);
		submParper.addActionListener(this);
		submParper.setActionCommand("sub");
		flush.addActionListener(this);
		flush.setActionCommand("flush");
	}
	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	public CollegeUI() throws IOException {
		StartGui startGui = new StartGui();
		token=startGui.getToken();
		jianting();
		setIconImage(Toolkit.getDefaultToolkit().getImage(CollegeUI.class.getResource("/img/微信图片_20200608191955.jpg")));
		setTitle("大学生在线—四史竞答V3.0  By_小小怪");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 330);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("Button.background"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("姓名：");
		lblNewLabel.setFont(new Font("华文楷体", Font.PLAIN, 20));
		lblNewLabel.setBounds(15, 26, 65, 27);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("积分：");
		lblNewLabel_1.setFont(new Font("华文楷体", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(15, 66, 54, 15);
		contentPane.add(lblNewLabel_1);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setEnabled(false);
		scrollPane.setBounds(227, 39, 591, 231);
		contentPane.add(scrollPane);
		txtrqq.setLineWrap(true);
		txtrqq.setEditable(false);
		
		
		txtrqq.setText("本程序开源，仅供学习交流，严禁用于商业！\r\n[提示]若提交考试无反应，请重新登陆！如有其它问题，联系QQ728097735.\n");
		txtrqq.setFont(new Font("华文楷体", Font.PLAIN, 17));
		txtrqq.setBackground(new Color(240, 248, 255));
		scrollPane.setViewportView(txtrqq);
		

		answerBox.setBackground(new Color(240, 248, 255));
		answerBox.setFont(new Font("华文楷体", Font.PLAIN, 15));
		answerBox.setModel(new DefaultComboBoxModel(new String[] {"英雄篇", "复兴篇", "创新篇", "信念篇"}));
		answerBox.setBounds(116, 160, 80, 21);
		contentPane.add(answerBox);
		
		JLabel lblNewLabel_2 = new JLabel("答题板块：");
		lblNewLabel_2.setFont(new Font("华文楷体", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(15, 157, 108, 24);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("答题次数：");
		lblNewLabel_3.setFont(new Font("华文楷体", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(15, 194, 108, 27);
		contentPane.add(lblNewLabel_3);
		
		
		submParper.setForeground(new Color(255, 127, 80));
		submParper.setBackground(new Color(220, 220, 220));
		submParper.setFont(new Font("华文行楷", Font.PLAIN, 18));
		submParper.setBounds(53, 234, 109, 36);
		contentPane.add(submParper);

		
		flush.setForeground(new Color(0, 0, 0));
		flush.setBackground(new Color(220, 220, 220));
		flush.setFont(new Font("华文新魏", Font.PLAIN, 14));
		flush.setBounds(124, 64, 65, 23);
		contentPane.add(flush);
		
	
		Count.setModel(new SpinnerNumberModel(1, 1, 100, 1));
		Count.setFont(new Font("华文楷体", Font.BOLD, 15));
		Count.setBounds(116, 197, 46, 22);
		contentPane.add(Count);
		
		JLabel lblNewLabel_6 = new JLabel("----------------------------信息区------------------------------");
		lblNewLabel_6.setEnabled(false);
		lblNewLabel_6.setFont(new Font("华文行楷", Font.PLAIN, 16));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_6.setBounds(239, 13, 516, 15);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_4 = new JLabel("参赛：");
		lblNewLabel_4.setFont(new Font("华文楷体", Font.PLAIN, 18));
		lblNewLabel_4.setBounds(15, 95, 54, 15);
		contentPane.add(lblNewLabel_4);
		
		getUserinfo();
		
	}
	
	public void getUserinfo() throws IOException {
		//获取个人信息
		HashMap<String, Integer[]> userMap = new HashMap<String, Integer[]>();
		userMap = GetUserInfo.getUserInfo(token);
		Integer  [] userInfo  = null;
		String Name = "";
		for(Entry<String, Integer[]> entry : userMap.entrySet()) {
			Name =entry.getKey();
			userInfo = entry.getValue();
		}
		
		int Intlerage = userInfo[0];
		int joinTime = userInfo[1];
		
		contentPane.remove(name);
		contentPane.remove(integral);
		contentPane.remove(join);
		
		name = new JLabel(Name);
		integral = new JLabel(""+Intlerage);
		join = new JLabel(""+joinTime);
		
		name.setFont(new Font("华文楷体", Font.BOLD, 18));
		name.setBounds(70, 26, 85, 27);
		contentPane.add(name);
		
		integral.setFont(new Font("华文楷体", Font.BOLD, 18));
		integral.setBounds(63, 66, 54, 15);
		contentPane.add(integral);
		
		join.setFont(new Font("华文楷体", Font.BOLD, 18));
		join.setBounds(66, 94, 41, 15);
		contentPane.add(join);
		
		JLabel lblNewLabel_7 = new JLabel("--------个人信息--------");
		lblNewLabel_7.setFont(new Font("华文行楷", Font.PLAIN, 15));
		lblNewLabel_7.setEnabled(false);
		lblNewLabel_7.setBounds(15, 10, 197, 18);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_7_1 = new JLabel("---------答题区---------");
		lblNewLabel_7_1.setFont(new Font("华文行楷", Font.PLAIN, 15));
		lblNewLabel_7_1.setEnabled(false);
		lblNewLabel_7_1.setBounds(16, 123, 197, 18);
		contentPane.add(lblNewLabel_7_1);
		setLocation((int)(Toolkit.getDefaultToolkit().getScreenSize().getWidth()-this.getWidth())/2,
				(int)(Toolkit.getDefaultToolkit().getScreenSize().getHeight()-this.getHeight())/2 );
		this.addWindowListener(this);
	}
	public static void submitAnswer(String token,String mode_id , int count) throws IOException, Throwable {
		for(int i=0;i<count;i++) {
			//获取题目,考试码
			HashMap<String, String[]> paperMap = new HashMap<String, String[]>();
			String[] question_arr = new String[20];
			String race_code = "";
			paperMap=GetQuestions.GetQuestionPaper(token, mode_id);
			txtrqq.append("已成功获取试卷，第"+ ++i+"次考试即将开始！"+"\n");
			txtrqq.setVisible(true);
			for(Entry<String, String[]> entrySet : paperMap.entrySet()) {
				race_code=entrySet.getKey();
				question_arr=entrySet.getValue();
			}
			//遍历所有题目
			for (int j = 0; j < question_arr.length; j++) {
				//获取题目详细信息
				txtrqq.append(("第" + (j+1) + "题:"));
				String question_id = question_arr[j];
				ArrayList<Answer> title_list = new ArrayList<Answer>();
				title_list=GetQuestionInfor.GetQuestionInformation(question_id, token, mode_id, j);
				txtrqq.append(title_list.get(0).getTitle()+"\n");
				txtrqq.setCaretPosition(txtrqq.getText().length());
				char ch = 65;
				int k=1;
				for(Answer answer :title_list) {
					txtrqq.append((ch += k++) + ":" +answer.getOption()+"\n");
					txtrqq.setCaretPosition(txtrqq.getText().length());
					
				}
				//获取答案
				txtrqq.append("答案：");
				JSONArray answer_arr = new JSONArray();
				answer_arr=GetAnswer.getAnswer(question_id, token, title_list, mode_id);
				for(Object object:answer_arr) {
					for(Answer answer: title_list) {
						if(object.equals(answer.getOptionID())) {
							txtrqq.append(answer.getOption()+"; ");
						}
					}
				}
				txtrqq.append("\n");
				txtrqq.setCaretPosition(txtrqq.getText().length());
				//提交答案
				SubmitAnswer.SubmitAnswers(question_id, answer_arr, mode_id, token);
			}
			//提交试卷
			String [] arr = new String [3];
			arr= SubmitExPaper.submitAnswer(race_code, token);
			txtrqq.append("本次考试结束.共答对"+arr[0]+"题，得分，"+arr[1]+"分，耗时："+arr[2]+"s\n");
			txtrqq.setCaretPosition(txtrqq.getText().length());
		}
		submParper.setEnabled(true);
	}
	
	SubPaper paper = new SubPaper();
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO 自动生成的方法存根
		if(arg0.getActionCommand().equals("sub")) {
			new Thread(paper).start();
			submParper.setEnabled(false);
		}
		if(arg0.getActionCommand().equals("stop")) {
			submParper.setEnabled(true);
		}
		if(arg0.getActionCommand().equals("flush")) {
			try {
				getUserinfo();
				JOptionPane.showMessageDialog(this,"若刷新间隔较短，结果会无反应！","提示",1);
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			contentPane.setVisible(false);
			contentPane.setVisible(true);
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
	public void windowClosing(WindowEvent arg0) {
		// TODO 自动生成的方法存根
		Font font = new Font("楷体", 0, 16);
		JLabel	mesg = new JLabel("<html><body>"
				+"感谢您的使用，程序即将退出！<br>"
				+"<body></html>");
		mesg.setFont(font);
//		mesg.setBounds(10, 280, 355, 25);
		JOptionPane.showMessageDialog(null,mesg
				,"退出提示",1);
		System.exit(0);
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
