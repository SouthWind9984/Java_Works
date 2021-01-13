package tool;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ImgLink {

	public ImgLink() {
		// TODO 自动生成的构造函数存根
		
		Properties properties = new Properties();
		try {
			properties.load(ImgLink.class.getClassLoader().getResourceAsStream("data//PhotoLink.properties"));
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			System.out.println("图片链接文件未找到！");
		}
		
		//地址链接保存
		ArrayList<String> imgLingList = new ArrayList<String>();
		try {
			for(int i=1;i<=100;i++) {
				for(int j=1;j<=19;j++) {
					imgLingList.add(properties.getProperty(i+"_"+j));
				}
			}
		}
		catch (NullPointerException e) {
			System.out.println("下标溢出！");
		}
		int n=1;
		int cg=1;
		for(String s:imgLingList) {
			try {
				System.out.println(s);
				URL url =new URL(s);
				BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream(),"GBK"));
				
				File file = new File("src\\data\\美女高清壁纸.txt");
				FileWriter fw = new FileWriter(file,true);
				
//				Properties pro = new Properties();
//				pro.load(ImgLink.class.getClassLoader().getResourceAsStream("ImgLink.properties"));
				
				//创建正则表达式
				String rgex = "<a href=\"http://img.netbian.com/file/[0-9]{4}/[0-9]{4}/[A-Za-z0-9]{20,}.jpg";
				String rx="alt=\"[A-Za-z\\u4e00-\\u9fa5\s]{6,}";
				Pattern p = Pattern.compile(rgex);
				Pattern p2=Pattern.compile(rx);
				String str =null;
				
				while((str=br.readLine())!=null){
					String imglink="";
					String pathName="";
					//图片链接
					Matcher m =p.matcher(str);
					while(m.find()) {
						imglink =m.group().substring(9);
						System.out.println(imglink);
					}
//					//图片名字
					Matcher m2 =p2.matcher(str);
					while(m2.find()) {
						pathName=m2.group().substring(5);
						System.out.println(pathName);
					}
					
					if(pathName.length()!=0&&imglink.length()!=0) {
						fw.write("url="+imglink+"\t\t"+pathName+"\n");
						cg++;
						saveDataSQL(imglink, pathName);
					}
				}
				//关流
				br.close();
				fw.close();
				System.out.println("第"+n+++"张爬取成功！");
			} 
			catch ( IOException e) {
				// TODO: handle exception
			}
		}
		System.out.println("一共爬取"+n+"张图");
		System.out.println("链接完整的有"+cg+"张！");
	}
	
	
	public void saveDataSQL(String url,String name) {
		//获取数据库连接
		Connection conn = ConntenSQL.getConnection();
		Statement stat =null; 
		ResultSet res =null;
		//创建SQL 执行平台
		try {
			stat=conn.createStatement();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			System.out.println("SQl平台执行错误");
		}
		String sql="insert into meinv (name,url) values ('"+name+"','"+url+"')";
		try {
			stat.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			System.out.println("sql语句执行错误！");
			e.printStackTrace();
		}
		//关闭数据链接
		ConntenSQL.close(res, stat, conn);
	}
}
