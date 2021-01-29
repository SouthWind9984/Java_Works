package longin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import net.sf.json.JSONObject;
import tool.Tool;

public class GetUID implements Runnable{

	public GetUID() {
		// TODO 自动生成的构造函数存根
	}
	int random = 0;
	private String uid = null;
	private String hard_photo=null;


	@Override
	public void run() {
		// TODO 自动生成的方法存根
		while(true) {
			String u= "https://oauth.u.hep.com.cn/oauth/wxapp/confirm/qr?random="+random+"&useSelfWxapp=true";
			URL url;
			try {
				Thread.sleep(1000);
				url = new URL(u);
				HttpURLConnection connection = (HttpURLConnection) url.openConnection();
				connection.setRequestMethod("POST");
				connection.setRequestProperty("Host", "ssxx.univs.cn");
				connection.setRequestProperty("Connection", "keep-alive");
				connection.setRequestProperty("Accept", "application/json, text/plain, */*");
				connection.setRequestProperty("Accept-Language", "zh-CN,zh;q=0.9,en;q=0.8,en-GB;q=0.7,en-US;q=0.6");
				connection.setRequestProperty("User-Agent",
						"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/87.0.4280.141 Safari/537.36 Edg/87.0.664.75");
				connection.setRequestProperty("Content-Type", "application/json");
				//读入
				InputStream is = connection.getInputStream();
				BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
				String str = "";
				JSONObject json = new JSONObject();
				JSONObject data = new JSONObject();
				while ((str = br.readLine()) != null) {
					//System.out.println(str);
					json = JSONObject.fromObject(str);
				}
				data=Tool.GetData(Tool.GetData(json));
				uid = Tool.GetUid(data);
				hard_photo = Tool.GetPhoto(data);
				br.close();
			} catch (IOException | InterruptedException e1) {
				// TODO 自动生成的 catch 块
				e1.printStackTrace();
			}
		}
	}
	//get set
	public void setRandom(int random) {
		this.random = random;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getHard_photo() {
		return hard_photo;
	}

	public void setHard_photo(String hard_photo) {
		this.hard_photo = hard_photo;
	}
			
}
