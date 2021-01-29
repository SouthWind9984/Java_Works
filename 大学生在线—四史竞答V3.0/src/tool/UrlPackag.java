package tool;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class UrlPackag {
	/**
	 * 	链接Harder package
	 * @param url
	 * @return
	 */
	public static HttpURLConnection GetPackag(URL url,String token) {
		// TODO 自动生成的构造函数存根
		HttpURLConnection connection=null;
		try {
			connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			System.out.println("链接解析异常！");
		}
		connection.setRequestProperty("Host", "ssxx.univs.cn");
		connection.setRequestProperty("Connection", "keep-alive");
		connection.setRequestProperty("Accept", "application/json, text/plain, */*");
		connection.setRequestProperty("Accept-Language", "zh-CN,zh;q=0.9,en;q=0.8,en-GB;q=0.7,en-US;q=0.6");
		connection.setRequestProperty("User-Agent",
				"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/87.0.4280.141 Safari/537.36 Edg/87.0.664.75");
		connection.setRequestProperty("Authorization", "Bearer " + token);
		//将封装好的链接返回
		return connection;
	}
	public static HttpURLConnection PostPackag(URL url,String token) {
		HttpURLConnection connection=null;
		
		try {
			connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("POST");
			
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			System.out.println("链接解析异常！");
		}
		connection.setRequestProperty("Host", "ssxx.univs.cn");
		connection.setRequestProperty("Connection", "keep-alive");
		connection.setRequestProperty("Accept", "application/json, text/plain, */*");
		connection.setRequestProperty("Accept-Language", "zh-CN,zh;q=0.9,en;q=0.8,en-GB;q=0.7,en-US;q=0.6");
		connection.setRequestProperty("User-Agent",
				"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/87.0.4280.141 Safari/537.36 Edg/87.0.664.75");
		connection.setRequestProperty("Authorization", "Bearer " + token);
		connection.setRequestProperty("Content-Type", "application/json");
		
		return 	connection;
	}
	
	
}
