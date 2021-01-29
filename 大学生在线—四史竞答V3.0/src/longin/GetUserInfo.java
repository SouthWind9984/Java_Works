package longin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

import net.sf.json.JSONObject;
import tool.Tool;
import tool.UrlPackag;

public class GetUserInfo {

	public GetUserInfo() {
		// TODO 自动生成的构造函数存根
		
	}

	public static HashMap<String, Integer[]> getUserInfo(String token) throws IOException {
		HashMap<String, Integer[]> userMap = new HashMap<String, Integer[]>();
		String u = "https://ssxx.univs.cn/cgi-bin/race/grade/?activity_id=5f71e934bcdbf3a8c3ba5061";
		
		URL url = new URL(u);
		
		HttpURLConnection connection = UrlPackag.GetPackag(url, token);
		
		InputStream is = connection.getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
		String str ="";
		JSONObject jsonObject = new JSONObject();
		while((str=br.readLine())!=null) {
//			System.out.println(str);
			jsonObject = JSONObject.fromObject(str);
//			System.out.println(jsonObject);
		}
		JSONObject data = Tool.GetData(jsonObject);
		String name = Tool.GetName(data);
//		System.out.println(name);
		int integeral = Integer.parseInt(Tool.GetUserIntegral(data));
		//System.out.println(integeral);
		int joinTime = Integer.parseInt(Tool.GetJointime(data));
		//System.out.println(joinTime);
		Integer [] info = {integeral,joinTime};
		userMap.put(name, info);
		br.close();
		return userMap;
	}
}
