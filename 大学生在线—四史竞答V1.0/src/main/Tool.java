package main;

import java.io.File;
import java.net.URL;

public class Tool {
	public static void main(String[] args) {
		
		URL url = Tool.class.getClassLoader().getResource("answers.properties");
		String arr[] = url.toString().split("/");
		String filepath="";
		for(String s : arr) {
			System.out.println(s);
			if(s.equals("file:")){
				continue;
			}
			
			if(s.equals("bin")) {
				filepath+="src/";
				continue;
			}
			filepath+=s+"/";
		}
		System.out.println(url);
		filepath=filepath.substring(0, filepath.length()-2);
		System.out.println(filepath);
		File file = new File(filepath);
		File file2 = new File("D:\\Eclipse\\大学生在线_四史竞答\\src\\answers.properties");
		System.out.println(file.exists());
		System.out.println(file2.exists());
	}
}
