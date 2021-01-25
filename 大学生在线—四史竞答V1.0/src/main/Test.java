package main;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class Test {

	public static void main(String[] args) throws Exception {
		// TODO 自动生成的方法存根
		Scanner in = new Scanner(System.in);

//		Properties properties = new Properties();
//		properties.load(Test.class.getClassLoader().getResourceAsStream("test.properties"));
//		System.out.println(properties.size());
		System.out.println();
		InputStream is = Test.class.getClassLoader().getResourceAsStream("Answers.properties");
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		String str = "";
		int n = 0;
		HashMap<String, JSONArray> hashMap = new HashMap<String, JSONArray>();
		while ((str = br.readLine()) != null) {
			n++;
//			System.out.print("md5加密："+str.substring(0, str.indexOf("=")));
//			System.out.println("="+properties.getProperty(str.substring(0, str.indexOf("="))));
//			hashMap.put(str.substring(0, str.indexOf("=")),JSONArray.fromObject(properties.getProperty(str.substring(0, str.indexOf("=")))));
			hashMap.put(str.substring(0, str.indexOf("=")), JSONArray.fromObject(str.substring(str.indexOf("=") + 1)));
		}
		br.close();
		System.out.println(n);
		System.out.println(hashMap.size());
//		for( Entry<String, JSONArray> entrySet: hashMap.entrySet()) {
//			String key=entrySet.getKey();
//			sum++;
//		}
		int sum = 0;
		InputStream iss = Test.class.getClassLoader().getResourceAsStream("Answers.properties");
		BufferedReader brr = new BufferedReader(new InputStreamReader(iss));
		while ((str = brr.readLine()) != null) {
			String title = str.substring(0, str.indexOf("="));
			System.out.println("题目：" + title);
//			System.out.println("答案："+JSONArray.fromObject(str.substring(str.indexOf("=")+1)));
			if (hashMap.get(title) != null) {
				sum++;
				System.out.println("答案：" + hashMap.get(title));
			}
		}

		System.out.println(sum);

		while (true) {
			String title = in.nextLine();
			title = md5(title);
			System.out.println(title);
			System.out.println("答案：" + hashMap.get(title));
		}

//		System.out.println(hashMap);
//		File file2 = new File("src//Answers.properties");
//		FileOutputStream fos= new FileOutputStream(file2);
//		BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(fos));
//		for(Entry<String, JSONArray> entrySet : hashMap.entrySet()) {
//			bw.write(entrySet.toString()+"\n");
//		}

//		bw.flush();
//		bw.close();
//		JSONObject jsonObject = new JSONObject();
//		ArrayList<String[]> list = new ArrayList<>();
//		HashMap<String, String[]> answer = new HashMap<String, String[]>();
//		String str="{\"code\": 0, \"data\": {\"correct\": false, \"finished\": false, \"reason\": null, \"correct_ids\": [\"df71ef46556fe02504bac335\"]}, \"status_code\": 200}";
//		jsonObject = JSONObject.fromObject(str);
//		System.out.println(getMap(jsonObject));
//		System.out.println();
	}

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

	// @Cacheable(value= "getList",key="#length",sync = true)
	public static String getMap(Map<String, Object> map) {
		String res = "";
		if (map.containsKey("data")) {
			String s2 = map.get("data").toString();
			JSONObject json = JSONObject.fromObject(s2);
			res = getMap(json);
		}
		if (map.containsKey("correct_ids")) {
			String s3 = map.get("correct_ids").toString();
			res = s3;
		}
		return res;
	}

}
