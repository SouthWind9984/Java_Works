package tool;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class SaveImg {

	public SaveImg() {
		// TODO 自动生成的构造函数存根
		
//		Properties properties = new Properties();
//		properties.load(SaveImg.class.getClassLoader().getResourceAsStream("ImgLink.properties"));
		HashMap<String, String> imgMap = new HashMap<String, String>();
		imgMap=visitSQL();
		//存取图片
		for(Map.Entry<String, String> entry:imgMap.entrySet()) {
			String url =entry.getKey();
			String pathName = entry.getValue();
			URL link;
			try {
				link = new URL(url);
//				BufferedReader bReader = new BufferedReader(new InputStreamReader(link.openStream(),"GBK"));
				//文件存储，使用字节流
				BufferedInputStream bis = new BufferedInputStream(link.openStream());
				File img = new File("F:\\彼岸图网\\美女高清壁纸\\"+pathName+".jpg");
				OutputStream fis = new FileOutputStream(img);
				BufferedOutputStream bos = new BufferedOutputStream(fis);
				byte [] bytes = new byte[10240];
				int len =0;
				while((len=bis.read(bytes))!=-1) {
//					System.out.println(len);
					bos.write(bytes, 0, len);
					}
				//关流
				bis.close();
				bos.flush();
				bos.close(); 
				}
			 catch (Exception e) {
				// TODO 自动生成的 catch 块
				System.out.println("图片写入错误！");
				e.printStackTrace();
			}
			System.out.println(pathName+"保存成功");
		}
		
	}
	
	public HashMap<String, String> visitSQL() {
		
		HashMap<String, String> imgMap = new HashMap<String, String>();
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
		String sql="select * from meinv ";
		try {
			res=stat.executeQuery(sql);
			while(res.next()) {
				imgMap.put(res.getString("url"), res.getNString("name"));
			}
			System.out.println("数据库导入成功！");
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			System.out.println("sql语句执行错误！");
			e.printStackTrace();
		}
		//关闭数据链接
		ConntenSQL.close(res, stat, conn);
		
		return imgMap;
	}
	
}
