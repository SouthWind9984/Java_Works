package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class Question {
	static String race_code = "";
	static int count = 0;
	static HashMap<String, JSONArray> hashMap = new HashMap<String, JSONArray>();

	public static void main(String[] args) throws Exception {
		// TODO 自动生成的方法存根
		getAnswerMap();
		System.out.println("从题库中成功读取到" + hashMap.size() + "个答案");
		System.out.println("请输入你的token:");
		Scanner in = new Scanner(System.in);
		String token = in.nextLine();

		// 答题次数
		for (int k = 0; k < 10; k++) {
			count = 0;
			// 获取题目
			String[] question_arr = new String[20];
			question_arr = getQuestion(token);
			// 遍历所有题目
			for (int i = 0; i < question_arr.length; i++) {
				String qid = question_arr[i];
				ArrayList<Answer> answer_list = new ArrayList<Answer>();
				// 获取题目详细信息
				answer_list = getqid(qid, token, i);
				JSONArray answerID_arr = new JSONArray();
				// 获取题目答案
				getAnswer(qid, token, answer_list);
			}
			// 提交考试
			submitAnswer(race_code, token);
			System.out.println("共答对：" + count + "道题");
		}
	}

	// 获取题目列表
	public static String[] getQuestion(String token)
			throws MalformedURLException, IOException, ProtocolException, UnsupportedEncodingException {
		String url = "http://ssxx.univs.cn/cgi-bin/race/beginning/?activity_id=5f71e934bcdbf3a8c3ba5061&mode_id=5f71e934bcdbf3a8c3ba51d5&way=1";
		URL obj = new URL(url);
		HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
		connection.setRequestMethod("GET");
		connection.setRequestProperty("Host", "ssxx.univs.cn");
		connection.setRequestProperty("Connection", "keep-alive");
		connection.setRequestProperty("Accept", "application/json, text/plain, */*");
		connection.setRequestProperty("Accept-Language", "zh-CN,zh;q=0.9,en;q=0.8,en-GB;q=0.7,en-US;q=0.6");
		connection.setRequestProperty("User-Agent",
				"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/87.0.4280.141 Safari/537.36 Edg/87.0.664.75");
		connection.setRequestProperty("Authorization", "Bearer " + token);

		int responseCode = connection.getResponseCode();
		System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);

		InputStream is = connection.getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
		// 题目ID数组
		String[] question_arr = new String[20];
		int n = 0;
		// 正则匹配
		String regEx = "[A-Za-z0-9]{24}";
		Pattern pattern = Pattern.compile(regEx);
		String str = "";
		while ((str = br.readLine()) != null) {
//        	System.out.println(str);
			// 截取字符
			int start = str.indexOf("\"question_ids\"");
			int end = str.indexOf("\"answers\"");
			Matcher matcher = pattern.matcher(str.substring(start, end));
			while (matcher.find()) {
				question_arr[n++] = matcher.group();
//        		System.out.println(matcher.group());
			}
			matcher = pattern.matcher(str.subSequence(str.indexOf("race_code"), str.indexOf("prev_qid")));
			while (matcher.find()) {
//        		System.out.println("race_code:"+matcher.group());
				race_code = matcher.group();
			}
		}

		br.close();

		return question_arr;
	}

	// 获取题目详细信息
	public static ArrayList<Answer> getqid(String question_id, String token, int i) throws Exception {
		Random ran = new Random();
		int time = ran.nextInt(8) + 1;
		Thread.sleep(time * 188);
		String url = "http://ssxx.univs.cn/cgi-bin/race/question/?activity_id=5f71e934bcdbf3a8c3ba5061&question_id="
				+ question_id + "&mode_id=5f71e934bcdbf3a8c3ba51d5&way=1";

		URL obj = new URL(url);
		HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
		connection.setRequestMethod("GET");
		connection.setRequestProperty("Host", "ssxx.univs.cn");
		connection.setRequestProperty("Connection", "keep-alive");
		connection.setRequestProperty("Accept", "application/json, text/plain, */*");
		connection.setRequestProperty("Accept-Language", "zh-CN,zh;q=0.9,en;q=0.8,en-GB;q=0.7,en-US;q=0.6");
		connection.setRequestProperty("User-Agent",
				"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/87.0.4280.141 Safari/537.36 Edg/87.0.664.75");
		connection.setRequestProperty("Authorization", "Bearer " + token);

		InputStream is = connection.getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
		String str = "";
//        String title_reg="\"title\".+category";
//        String option_reg="\"code\"[^}]+";
//        String op_reg="[A-Za-z0-9]{24}";
//        Pattern title_pattern=Pattern.compile(title_reg);
//        Pattern option_pattern = Pattern.compile(option_reg);
//        Pattern op_pattern = Pattern.compile(op_reg);

		ArrayList<Answer> answer_list = new ArrayList<Answer>();

		int m = 0;
//        Properties properties = new Properties();
//		properties.load(Question.class.getClassLoader().getResourceAsStream("answer.properties"));
		while ((str = br.readLine()) != null) {
			System.out.print("第" + ++i + "题:");
//        	System.out.println("JSON："+str);
			// 字符串转JSON
			JSONObject json = JSONObject.fromObject(str);
			// 获取数据
			JSONObject Data = getData(json);

//        	String options = getoptions(Data);
			String title = getTitle(Data);
			title = title.replaceAll("<(\\w+)[^>]+?(?:display: {0,}none;).*?>.*?<\\/\\1>", "").replaceAll("<.*?>", "");
			System.out.println(title);

			JSONArray jsonArray = getoptions(Data);
			String option = "";
			String optionID = "";

			for (int j = 0; j < jsonArray.size(); j++) {
				JSONObject jsonObject = (JSONObject) jsonArray.get(j);
				optionID = getOptionID(jsonObject);

//        		System.out.println("id:"+optionID);
				option = getTitle(jsonObject);
				option = option.replaceAll("<(\\w+)[^>]+?(?:display: {0,}none;).*?>.*?<\\/\\1>", "").replaceAll("<.*?>",
						"");
				option = option.trim();
				char ch = 65;
				System.out.println((ch += j) + ":" + option);
				Answer answer = new Answer(option, optionID, title);
				answer_list.add(answer);
			}

			/*
			 * // Matcher title_mat=title_pattern.matcher(str); //
			 * System.out.println("题目："); // while(title_mat.find()) { //
			 * System.out.print(unicodeDecode((title_mat.group().
			 * replaceAll("<(\\w+)[^>]+?(?:display: {0,}none;).*?>.*?<\\/\\1>",
			 * "")).replaceAll("<.*?>", "")).replaceAll(", \"category", "")); //
			 * bw.write((unicodeDecode((title_mat.group().
			 * replaceAll("<(\\w+)[^>]+?(?:display: {0,}none;).*?>.*?<\\/\\1>",
			 * "")).replaceAll("<.*?>", "")).replaceAll(", \"category",
			 * "")).replaceAll("\"title\"", "题目")+"\n"); // }
			 * 
			 * // System.out.println(); // System.out.println("选项："); // Matcher
			 * option_mat=option_pattern.matcher(str.substring(str.indexOf("\"options\"")));
			 * // while(option_mat.find()) { // String
			 * option=unicodeDecode((option_mat.group().
			 * replaceAll("<(\\w+)[^>]+?(?:display: {0,}none;).*?>.*?<\\/\\1>",
			 * "")).replaceAll("<.*?>", "")).replaceAll(", \"weight\": [0-9]{1}.0", ""); //
			 * System.out.println(option); // bw.write((option.replaceAll("\"code\": ",
			 * "")).replaceAll(", \"title\"", "")+"\n"); // } //答案ID // Matcher
			 * op_mat=op_pattern.matcher(str.substring(str.indexOf("[{"),
			 * str.indexOf("}]"))); // while(op_mat.find()) { //
			 * System.out.println(op_mat.group()); // option_arr[m]=op_mat.group(); // m++;
			 * // }
			 */

		}
		br.close();
		return answer_list;
	}

	// 搜索答案
	public static void getAnswer(String id, String token, ArrayList<Answer> anList) throws Exception {
		Random ran = new Random();
		int time = ran.nextInt(8) + 1;
		Thread.sleep(time * 188);
		String url = "http://ssxx.univs.cn/cgi-bin/race/answer/";
		URL obj = new URL(url);
		HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
		connection.setRequestMethod("POST");
		connection.setRequestProperty("Host", "ssxx.univs.cn");
		connection.setRequestProperty("Connection", "keep-alive");
		connection.setRequestProperty("Accept", "application/json, text/plain, */*");
		connection.setRequestProperty("Accept-Language", "zh-CN,zh;q=0.9,en;q=0.8,en-GB;q=0.7,en-US;q=0.6");
		connection.setRequestProperty("User-Agent",
				"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/87.0.4280.141 Safari/537.36 Edg/87.0.664.75");
		connection.setRequestProperty("Authorization", "Bearer " + token);
		connection.setRequestProperty("Content-Type", "application/json");

//		Properties properties = new Properties();
//		properties.load(Question.class.getClassLoader().getResourceAsStream("Answers.properties"));
		String title = anList.get(0).getTitle();
		// 答案数组
		JSONArray jsonArrays = new JSONArray();
		title = md5(title);
		jsonArrays = hashMap.get(title);
		System.out.println("加密的数组：" + jsonArrays);
		// 所要提交的答案数组
		JSONArray answers = new JSONArray();
		if (jsonArrays != null) {
			for (int i = 0; i < jsonArrays.size(); i++) {
				for (Answer answer : anList) {
					if (md5(answer.getOption()).equals(jsonArrays.get(i))) {
						answers.add(answer.getOptionID());
						break;
					}
				}
			}
		}
//		if (answers.size() == 0) {
//			System.out.println("题库没有答案，蒙个A试试：");
//			answers.add(anList.get(0).getOptionID());
//		}
		// 创建JOSN
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("activity_id", "5f71e934bcdbf3a8c3ba5061");
		jsonObject.put("question_id", id);
		jsonObject.put("mode_id", "5f71e934bcdbf3a8c3ba51d5");
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
		JSONArray answer_arr = new JSONArray();
		String Right = "";
		while ((str = br.readLine()) != null) {
//        	System.out.println("提交题目后返回的结果："+str);
			JSONObject json = JSONObject.fromObject(str);
			Right = getRight(getData(json));
			answer_arr = getcorrect_ids(getData(json));
			System.out.println("作答是否正确：" + Right);

		}
		if (Right.equals("false")) {
			// 题目答案与选项匹配
			System.out.println("答案ID数组：" + answer_arr);
			HashMap<String, JSONArray> ansMap = new HashMap<String, JSONArray>();
			JSONArray option_arr = new JSONArray();
			for (int i = 0; i < answer_arr.size(); i++) {
				for (Answer answer : anList) {
					if (answer.getOptionID().equals(answer_arr.get(i))) {
						option_arr.add(md5(answer.getOption()));
						break;
					}
				}
			}
			System.out.println("加密后的数组：" + option_arr);
//        	System.out.println("提交ID数组："+answers);
			ansMap.put(anList.get(0).getTitle(), option_arr);
			saveAnswer(ansMap);
		}

		else {
			count++;
		}
		br.close();
	}

	// 提交试题，结束考试
	public static void submitAnswer(String race_code, String token) throws Exception {
		String url = "http://ssxx.univs.cn/cgi-bin/race/finish/";
		URL obj = new URL(url);
		HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
		connection.setRequestMethod("POST");
		connection.setRequestProperty("Host", "ssxx.univs.cn");
		connection.setRequestProperty("Connection", "keep-alive");
		connection.setRequestProperty("Accept", "application/json, text/plain, */*");
		connection.setRequestProperty("Accept-Language", "zh-CN,zh;q=0.9,en;q=0.8,en-GB;q=0.7,en-US;q=0.6");
		connection.setRequestProperty("User-Agent",
				"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/87.0.4280.141 Safari/537.36 Edg/87.0.664.75");
		connection.setRequestProperty("Authorization", "Bearer " + token);
		connection.setRequestProperty("Content-Type", "application/json");
		// 创建JOSN
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("race_code", race_code);
		String Parameters = jsonObject.toString();

		// 发送Post请求
		connection.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
		wr.writeBytes(Parameters);
		wr.flush();
		wr.close();
		InputStream is = connection.getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
		String str = "";
		while ((str = br.readLine()) != null) {
			System.out.println("考试结束：" + str);
		}
		br.close();
	}

	// unicode 转 UTF-8
	public static String unicodeDecode(String string) {
		Pattern pattern = Pattern.compile("(\\\\u(\\p{XDigit}{4}))");
		Matcher matcher = pattern.matcher(string);
		char ch;
		while (matcher.find()) {
			ch = (char) Integer.parseInt(matcher.group(2), 16);
			string = string.replace(matcher.group(1), ch + "");
		}
		return string;
	}

	// 获取JSON中的data
	public static JSONObject getData(Map<String, Object> map) {
		JSONObject json = new JSONObject();
		if (map.containsKey("data")) {
			return json = JSONObject.fromObject(map.get("data"));
		}
		return null;
	}

	// 获取JSON中的title
	public static String getTitle(Map<String, Object> map) {

		if (map.containsKey("title")) {
			return map.get("title").toString();
		}
		return null;
	}

	// 获取JSON的options
	public static JSONArray getoptions(Map<String, Object> map) {
		if (map.containsKey("options")) {
			return JSONArray.fromObject(map.get("options").toString());
		}
		return null;
	}

	// 获取JSON的correct_ids 答案数组
	public static JSONArray getcorrect_ids(Map<String, Object> map) {
		if (map.containsKey("correct_ids")) {
			return JSONArray.fromObject(map.get("correct_ids").toString());
		}
		return null;
	}

	// 获取JSON的optionID 答案ID
	public static String getOptionID(Map<String, Object> map) {
		if (map.containsKey("id")) {
			return map.get("id").toString();
		}
		return null;
	}

	// 获取答案是否正确
	public static String getRight(Map<String, Object> map) {
		if (map.containsKey("correct")) {
			return map.get("correct").toString();
		}
		return null;
	}

	// 存储答案
	public static void saveAnswer(HashMap<String, JSONArray> ansMap) throws Exception {
		File answers = new File("src//answers.properties");
		FileOutputStream os = new FileOutputStream(answers, true);
		BufferedWriter bweiter = new BufferedWriter(new OutputStreamWriter(os));
		for (Map.Entry<String, JSONArray> entry : ansMap.entrySet()) {
			bweiter.write(md5(entry.getKey()));
			bweiter.write("=" + entry.getValue() + "\n");
		}
		System.out.println("答案更新成功！");
		bweiter.flush();
		bweiter.close();
	}

	// 读取答案
	public static void getAnswerMap() {
		InputStream is = Question.class.getClassLoader().getResourceAsStream("answers.properties");
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		String str = "";
		try {
			while ((str = br.readLine()) != null) {
				hashMap.put(str.substring(0, str.indexOf("=")),
						JSONArray.fromObject(str.substring(str.indexOf("=") + 1)));
			}
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			System.out.println("文件读取错误！");
		}
	}

	// md5加密
	public static String md5(String data) {
		StringBuilder sb = new StringBuilder();
		try {
			MessageDigest md = MessageDigest.getInstance("md5");
			byte[] md5 = md.digest(data.getBytes(StandardCharsets.UTF_8));
			// 将字节数据转换为十六进制
			for (byte b : md5) {
				sb.append(Integer.toHexString(b & 0xff));
			}
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
//        System.out.println(sb.toString().length());
		return sb.toString();
	}

}
