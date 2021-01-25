package main;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import entity.Answer;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import tool.Tool;
import tool.UrlPackag;

public class GetAnswer {

	public GetAnswer() {
		// TODO 自动生成的构造函数存根
	}
	// 搜索答案
	public static JSONArray getAnswer(String question_id, String token, ArrayList<Answer> anList,String mode_id) throws Exception {
		Random ran = new Random();
		int time = ran.nextInt(8) + 1;
		Thread.sleep(time * 188);
		//提交的答案数组
		JSONArray answers = new JSONArray();
		//正确的答案数组
		JSONArray answer_arr = new JSONArray();
		//向链接发送请求
		String url = "http://ssxx.univs.cn/cgi-bin/race/answer/";
		URL obj = new URL(url);
		HttpURLConnection connection = UrlPackag.PostPackag(obj, token);
		//随便提交一个答案
		answers.add(anList.get(ran.nextInt(anList.size())).getOptionID());
		// 创建JOSN
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("activity_id", "5f71e934bcdbf3a8c3ba5061");
		jsonObject.put("question_id", question_id);
		jsonObject.put("mode_id", mode_id);
		jsonObject.put("way", "1");
		jsonObject.put("answer", answers);
		String Parameters = jsonObject.toString();
//		System.out.println(jsonObject);
		// 发送Post请求
		connection.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
		wr.writeBytes(Parameters);
		wr.flush();
		wr.close();
		InputStream is = connection.getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
		String str = "";
		
		String Right = "";
		while ((str = br.readLine()) != null) {
//        	System.out.println("提交题目后返回的结果："+str);
			JSONObject json = JSONObject.fromObject(str);
			Right = Tool.GetRight(Tool.GetData(json));
			answer_arr = Tool.GetCorrect_ids(Tool.GetData(json));
//			System.out.println("作答是否正确：" + Right);
		}
		System.out.print("成功获取到答案：");
		for(Object object:answer_arr) {
			for(Answer answer: anList) {
				if(object.equals(answer.getOptionID())) {
					System.out.print(answer.getOption()+"; ");
				}
			}
		}
		System.out.println();
		//如果蒙对可以返回提交数组
		if(Right.equals("true")) {
			return answers;
		}
		br.close();
		return answer_arr;
	}
}
