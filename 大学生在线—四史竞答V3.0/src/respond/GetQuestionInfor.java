package respond;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;

import entity.Answer;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import tool.Tool;
import tool.UrlPackag;

public class GetQuestionInfor {
	/**
	 * 	//存取题目,选项,ID
	 */
//	public static void main(String[] args) {
//		try {
//			GetQuestionInformation("", "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE2MTE5MjMwNDksImlhdCI6MTYxMTkxMjI0OSwiaXNzIjoiSEVQRTM6QVVUSCIsIm5iZiI6MTYxMTkxMjI0OSwidWlkIjoiNjAwN2RlNzFhMjNhOGNjMGZiMzBkZDQwIiwibmFtZSI6Ilx1NWYwMFx1NWZjM1x1OGQ4NVx1NGViYSIsImNvZGUiOiI2MDA3ZGU3MWEyM2E4Y2MwZmIzMGRkNDAiLCJpc19wZXJmZWN0Ijp0cnVlfQ.ByoilpYJAP-jfpanNgQV8gDIKJ6VFky5LzhtvR8Yguw", "", 0);
//		} catch (IOException e) {
//			// TODO 自动生成的 catch 块
//			e.printStackTrace();
//		} catch (Exception e) {
//			// TODO 自动生成的 catch 块
//			e.printStackTrace();
//		}
//	}
	public GetQuestionInfor() {
		// TODO 自动生成的构造函数存根
	}
	//获取题目详细信息
	public static ArrayList<Answer>  GetQuestionInformation(String question_id, String token,String mode_id,int count) throws IOException, Exception {
		// TODO 自动生成的构造函数存根
		//延时随机
		Random ran = new Random();
		int time = ran.nextInt(8) + 1;
		Thread.sleep(time * 188);
		//向链接发送请求
		ArrayList<Answer> answer_list = new ArrayList<Answer>();
		String url = "https://ssxx.univs.cn/cgi-bin/race/question/?activity_id=5f71e934bcdbf3a8c3ba5061&question_id="+question_id+"&mode_id="+mode_id+"&way=1";

		URL obj = new URL(url);
		HttpURLConnection connection =UrlPackag.GetPackag(obj, token);

		InputStream is = connection.getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
		String str = "";
		int m = 0;
		while ((str = br.readLine()) != null) {
			System.out.print("第" + ++count + "题:");
//        	System.out.println("JSON："+str);
			// 字符串转JSON
			JSONObject json = JSONObject.fromObject(str);
			// 获取数据
			JSONObject Data = Tool.GetData(json);
			//获取题目
			String title = Tool.GetTitle(Data);
			title = title.replaceAll("<(\\w+)[^>]+?(?:display: {0,}none;).*?>.*?<\\/\\1>", "").replaceAll("<.*?>", "");
			System.out.println(title);

			JSONArray jsonArray = Tool.GetOptions(Data);
			String option = "";
			String optionID = "";

			for (int i = 0; i < jsonArray.size(); i++) {
				JSONObject jsonObject = (JSONObject) jsonArray.get(i);
				optionID = Tool.GetOptionID(jsonObject);
//        		System.out.println("id:"+optionID);
				option = Tool.GetTitle(jsonObject);
				option = option.replaceAll("<(\\w+)[^>]+?(?:display: {0,}none;).*?>.*?<\\/\\1>", "").replaceAll("<.*?>",
						"");
				option = option.trim();
				char ch = 65;
				System.out.println((ch += i) + ":" + option);
				Answer answer = new Answer(option, optionID, title);
				answer_list.add(answer);
			}
		}
		br.close();
		return answer_list;
	}

}
