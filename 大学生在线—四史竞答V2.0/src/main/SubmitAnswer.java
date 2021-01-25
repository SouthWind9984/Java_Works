package main;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import tool.Tool;
import tool.UrlPackag;

public class SubmitAnswer {

	/**
	 * 
	 * 	将获取到题目正确答案再次提交，正确率100%
	 * @throws IOException 
	 * @throws InterruptedException 
	 */
	public SubmitAnswer() {
		// TODO 自动生成的构造函数存根
	}
	
	public static void SubmitAnswers(String questionID,JSONArray answer,String mode_id,String token) throws IOException, InterruptedException {
		// TODO 自动生成的构造函数存根
		//延时随机
		Random ran = new Random();
		int time = ran.nextInt(8) + 1;
		Thread.sleep(time * 188);
		//向链接发送请求
		String url = "http://ssxx.univs.cn/cgi-bin/race/answer/";
		URL obj = new URL(url);
		HttpURLConnection connection = UrlPackag.PostPackag(obj, token);
		// 创建JOSN
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("activity_id", "5f71e934bcdbf3a8c3ba5061");
		jsonObject.put("question_id", questionID);
		jsonObject.put("mode_id", mode_id);
		jsonObject.put("way", "1");
		jsonObject.put("answer", answer);
		String Parameters = jsonObject.toString();
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
			System.out.println("作答是否正确：" + Right);
		}
	}
	
}
