package longin;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLDecoder;

public class SavePhoto {

	public SavePhoto(String u) throws IOException {
		// TODO 自动生成的构造函数存根
		String filename=u.replaceAll("https://node2d-public.hep.com.cn/wxapp/qrcode/", "");
		String filepath = SavePhoto.class.getClassLoader().getResource("").getPath();
		filepath = URLDecoder.decode(filepath, "UTF-8");
		//System.out.println(filepath);
		URL url =new URL(u);
		//文件输出
		File qrcode = new File(filepath.replaceAll("file:/", "")+"Qrcode");
		if (!qrcode.exists()) {
			qrcode.mkdir();
			//System.out.println("创建文件夹路径为："+qrcode.toString());
		}
		filepath=filepath.replaceAll("file:/", "")+"Qrcode//"+filename;
		File file = new File(filepath);
		FileOutputStream fos = new FileOutputStream(file);
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		//数据输入
		BufferedInputStream bis = new BufferedInputStream(url.openStream());
		byte [] bytes = new byte[10240];
		int len =0;
		while((len=bis.read(bytes))>0) {
//			System.out.println(len);
			bos.write(bytes, 0, len);
		}
		bis.close();
		bos.flush();
		bos.close();
		System.out.println("图片保存成功！");
	}
	
}
