package start;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import entity.Answer;

import java.util.Scanner;

import net.sf.json.JSONArray;
import respond.GetAnswer;
import respond.GetQuestionInfor;
import respond.GetQuestions;
import respond.SubmitAnswer;
import respond.SubmitExPaper;

public class Main {
	
		static String token="";
	public static void main(String[] args) throws Exception, ProtocolException, UnsupportedEncodingException, IOException {
		System.out.println("请输入你的token（浏览器登陆大学生在线——F12——打开控制台（部分浏览器为Console）输入:localStorage.token(回车，复制引号中所有内容)：");
		Scanner in = new Scanner(System.in);
		token = in.nextLine();
		String [] modes= {"5f71e934bcdbf3a8c3ba51d5","5f71e934bcdbf3a8c3ba51d6",
				"5f71e934bcdbf3a8c3ba51d7","5f71e934bcdbf3a8c3ba51d8"};
		System.out.println("——答题板块——");
		System.out.println("1----英雄篇");
		System.out.println("2----复兴篇");
		System.out.println("3----创新篇");
		System.out.println("4----信念篇");
		String mode_id="";
		Goto:
		while(true) {
			System.out.println("请选择答题板块：");
			int  id=in.nextInt();
			switch(id) {
				case 1:
					mode_id=modes[0];break Goto;
				case 2:
					mode_id = modes[1];break Goto;
				case 3:
					mode_id = modes[2];break Goto;
				case 4:
					mode_id = modes[3];break Goto;
					default:
						System.out.println("抱歉，选择错误！重新输入");break;
					
			}
		}
		System.out.println("请输入答题次数（一次为20道题）:");
		int count=in.nextInt();
//		int count =1;
		for(int i=0;i<count;i++) {
			//获取题目,考试码
			HashMap<String, String[]> paperMap = new HashMap<String, String[]>();
			String[] question_arr = new String[20];
			String race_code = "";
			paperMap=GetQuestions.GetQuestionPaper(token, mode_id);
			for(Entry<String, String[]> entrySet : paperMap.entrySet()) {
				race_code=entrySet.getKey();
				question_arr=entrySet.getValue();
			}
			//遍历所有题目
			for (int j = 0; j < question_arr.length; j++) {
				//获取题目详细信息
				String question_id = question_arr[j];
				ArrayList<Answer> title_list = new ArrayList<Answer>();
				title_list=GetQuestionInfor.GetQuestionInformation(question_id, token, mode_id, j);
				//获取答案
				JSONArray answer = new JSONArray();
				answer=GetAnswer.getAnswer(question_id, token, title_list, mode_id);
				//提交答案
				SubmitAnswer.SubmitAnswers(question_id, answer, mode_id, token);
			}
			//提交试卷
			SubmitExPaper.submitAnswer(race_code, token);
		}
	}
}
