package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class Login {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根

		String u = "http://ssxx.univs.cn/client/detail/5f71e934bcdbf3a8c3ba5061";

		try {
			URL url = new URL(u);
			InputStream is = url.openStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));

			String str = "";
			while ((str = br.readLine()) != null) {
				System.out.println(str);
			}
		} catch (MalformedURLException e) {
			// TODO 自动生成的 catch 块
			System.out.println("链接解析错误！");
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}

	}

}
