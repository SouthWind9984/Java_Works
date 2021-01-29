package longin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import net.sf.json.JSONObject;
import tool.Tool;

public class GetToken {

	public GetToken() {
		// TODO 自动生成的构造函数存根
	}
	
	public static String getToken(String uid,String photo) throws IOException {
		
		String u ="https://ssxx.univs.cn/cgi-bin/authorize/token/?uid="+uid+"&avatar="+photo+"&activity_id=5f71e934bcdbf3a8c3ba5061";
		
		URL url = new URL(u);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("GET");
		connection.setRequestProperty("Host", "ssxx.univs.cn");
		connection.setRequestProperty("Connection", "keep-alive");
		connection.setRequestProperty("Accept", "application/json, text/plain, */*");
		connection.setRequestProperty("Accept-Language", "zh-CN,zh;q=0.9,en;q=0.8,en-GB;q=0.7,en-US;q=0.6");
		connection.setRequestProperty("User-Agent",
				"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/87.0.4280.141 Safari/537.36 Edg/87.0.664.75");
		InputStream is =connection.getInputStream();
		BufferedReader bReader = new BufferedReader(new InputStreamReader(is));
		String str = "";
		JSONObject jsonObject = new JSONObject();
		while((str=bReader.readLine())!=null) {
//			System.out.println(str);
			jsonObject=JSONObject.fromObject(str);
		}
		String token=Tool.GetToken(jsonObject);
//		System.out.println(token);
		return token;
	}
}
