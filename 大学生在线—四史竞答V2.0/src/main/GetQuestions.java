package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import tool.UrlPackag;

public class GetQuestions {

	/**
	 * 	获取本次考试信息，及考试所有题目ID
	 */
	public GetQuestions() {
		// TODO 自动生成的构造函数存根
	}
	// 获取题目列表
		public static HashMap<String, String[]> GetQuestionPaper(String token,String mode_id)
				throws MalformedURLException, IOException, ProtocolException, UnsupportedEncodingException {
			//存储考试码和所有题目ID
			HashMap<String, String[]> paperMap = new HashMap<String, String[]>();
			String[] question_arr = new String[20];
			String race_code= "";
			String url = "http://ssxx.univs.cn/cgi-bin/race/beginning/?activity_id=5f71e934bcdbf3a8c3ba5061&mode_id="+mode_id+"&way=1";
			URL obj = new URL(url);
			HttpURLConnection connection = UrlPackag.GetPackag(obj, token);

			int responseCode = connection.getResponseCode();
//			System.out.println("Response Code : " + responseCode);
			if(responseCode==200) {
				System.out.println("已成功获取试卷，考试即将开始！");
			}
			else {
				System.out.println("获取试卷失败，请查看Token是否正确");
			}
			InputStream is = connection.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
			// 题目ID数组
			
			int n = 0;
			// 正则匹配
			String regEx = "[A-Za-z0-9]{24}";
			Pattern pattern = Pattern.compile(regEx);
			String str = "";
			while ((str = br.readLine()) != null) {
//	        	System.out.println(str);
				// 截取字符
				int start = str.indexOf("\"question_ids\"");
				int end = str.indexOf("\"answers\"");
				Matcher matcher = pattern.matcher(str.substring(start, end));
				while (matcher.find()) {
					question_arr[n++] = matcher.group();
//	        		System.out.println(matcher.group());
				}
				matcher = pattern.matcher(str.subSequence(str.indexOf("race_code"), str.indexOf("prev_qid")));
				while (matcher.find()) {
//	        		System.out.println("race_code:"+matcher.group());
					race_code = matcher.group();
				}
			}
			br.close();
			paperMap.put(race_code, question_arr);
			
			return paperMap;
		}
	
}
