package tool;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONArray;

public class SaveAnswer {

	public SaveAnswer() {
		// TODO 自动生成的构造函数存根
	}
	// 存储答案
	public static void saveAnswer(HashMap<String, JSONArray> ansMap) throws Exception {
		File answers = new File("src//answers.properties");
		FileOutputStream os = new FileOutputStream(answers, true);
		BufferedWriter bweiter = new BufferedWriter(new OutputStreamWriter(os));
		for (Map.Entry<String, JSONArray> entry : ansMap.entrySet()) {
			bweiter.write(Tool.Md5(entry.getKey()));
			bweiter.write("=" + entry.getValue() + "\n");
		}
		System.out.println("答案更新成功！");
		bweiter.flush();
		bweiter.close();
	}
	
	// 读取答案
	public static HashMap<String, JSONArray> getAnswerMap() {
		HashMap<String, JSONArray> answerMap = new HashMap<String, JSONArray>();
		InputStream is = SaveAnswer.class.getClassLoader().getResourceAsStream("answers.properties");
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		String str = "";
		try {
			while ((str = br.readLine()) != null) {
				answerMap.put(str.substring(0, str.indexOf("=")),
						JSONArray.fromObject(str.substring(str.indexOf("=") + 1)));
			}
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			System.out.println("文件读取错误！");
		}
		return answerMap;
	}

	
}
