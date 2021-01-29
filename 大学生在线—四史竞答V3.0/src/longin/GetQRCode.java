package longin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;
import java.util.HashMap;

import net.sf.json.JSONObject;
import tool.Tool;

public class GetQRCode {
	public GetQRCode() {
		// TODO 自动生成的构造函数存根
		
	}
	
	public static HashMap<Integer, String> SendRandom() throws Exception {
		HashMap<Integer, String> resMap = new HashMap<Integer, String>();
		Date date= new Date();
		int random = date.hashCode();
		String u = "https://oauth.u.hep.com.cn/oauth/wxapp/qrcode/5f582dd3683c2e0ae3aaacee?random="+random+"&useSelfWxapp=true&enableFetchPhone=false";
		URL url = null;
		HttpURLConnection connection=null;
		try {
			url = new URL(u);
			connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
		} catch (IOException e1) {
			// TODO 自动生成的 catch 块
			System.out.println("地址解析错误！");
		}
		connection.setRequestProperty("Host", "ssxx.univs.cn");
		connection.setRequestProperty("Connection", "keep-alive");
		connection.setRequestProperty("Accept", "application/json, text/plain, */*");
		connection.setRequestProperty("Accept-Language", "zh-CN,zh;q=0.9,en;q=0.8,en-GB;q=0.7,en-US;q=0.6");
		connection.setRequestProperty("User-Agent",
				"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/87.0.4280.141 Safari/537.36 Edg/87.0.664.75");
		InputStream is = connection.getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(is,"utf-8"));
		String str = "";
		JSONObject json = new JSONObject();
		JSONObject data = new JSONObject();
		while ((str = br.readLine()) != null) {
			//System.out.println(str);
			json=JSONObject.fromObject(str);
		}
		data=Tool.GetData(json);
		String Qrcode = Tool.GetQrcode(data);
		//System.out.println(Qrcode);
		//System.out.println(Tool.GetCreatAT(data));
		//System.out.println(Tool.GetDate(Tool.GetCreatAT(data)));
		//System.out.println(Tool.GetRandom(data));
		br.close();
		resMap.put(random, Qrcode);
		return resMap;
	}
}
