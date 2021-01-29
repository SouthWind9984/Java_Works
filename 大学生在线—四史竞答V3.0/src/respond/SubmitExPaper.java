package respond;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import net.sf.json.JSONObject;
import tool.Tool;
import tool.UrlPackag;

public class SubmitExPaper {
	/**
	 * 	提交试卷，结束考试
	 */
	public SubmitExPaper() {
		// TODO 自动生成的构造函数存根
	}
	// 提交试题，结束考试
		public static String[] submitAnswer(String race_code, String token) throws Exception {
			String url = "https://ssxx.univs.cn/cgi-bin/race/finish/";
			URL obj = new URL(url);
			HttpURLConnection connection = UrlPackag.PostPackag(obj, token);
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
			JSONObject jsObject=null;
			while ((str = br.readLine()) != null) {
//				System.out.println(str);
				jsObject =JSONObject.fromObject(str);
			}
			JSONObject data = Tool.GetData(jsObject);
			String integral  = Tool.GetIntegral(data);
			JSONObject owner = Tool.GetOwner(data);
			String count = Tool.getCount(owner);
			String time = Tool.GetTime(owner);
			String [] arr = {count,integral,time};
			System.out.println("本次考试结束.共答对"+count+"题，得分："+integral+"分 ,耗时："+time+"s");
			br.close();
			return arr;
		}
}
