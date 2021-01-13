package tool;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WbeAddress {

	
	public WbeAddress(String url,int k) {
		// TODO 自动生成的构造函数存根
		try {
			
			URL url2 = new URL(url);
			//向链接发送请求，获取输入资源
			BufferedInputStream bis = new BufferedInputStream(url2.openStream());
			BufferedReader br = new BufferedReader(new InputStreamReader(url2.openStream(),"GBK"));
			//
			File file = new File("src\\data\\PhotoLink.properties");
			FileWriter fw = new FileWriter(file);
			
			//创建正则表达式，匹配字符进行截取
			String rgex = "desk/[0-9]{5,}";
			Pattern p = Pattern.compile(rgex);
			int n=1;
			String str =null;
			//字节流通用，但获取字符使用字符流较好
			while((str=br.readLine())!=null) {
				Matcher m= p.matcher(str);
				while(m.find()) {
					fw.write(k+"_"+n+"=http://www.netbian.com/"+m.group()+"-1920x1080.htm"+"\n");
					System.out.println(k+"_"+n+++"=http://www.netbian.com/"+m.group()+"-1920x1080.htm"+"\n");
				}
			}
			br.close();
			fw.close();
		
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			System.out.println("地址解析错误！");
		}
		
		
	}

	
}
