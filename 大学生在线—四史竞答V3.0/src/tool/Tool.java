package tool;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class Tool {

	/**
	 * 	该类为工具类
	 * 	用于截取字符，获取信息，加密，转字符类型等
	 */
	public Tool() {
		// TODO 自动生成的构造函数存根
	}

	// 获取JSON中的data
		public static JSONObject GetData(Map<String, Object> map) {
			JSONObject json = new JSONObject();
			if (map.containsKey("data")) {
				return json = JSONObject.fromObject(map.get("data"));
			}
			return null;
		}
		//获取Owner
		public static JSONObject GetOwner(Map<String, Object> map) {
			JSONObject json = new JSONObject();
			if (map.containsKey("owner")) {
				return json = JSONObject.fromObject(map.get("owner"));
			}
			return null;
		}
		

	// 获取JSON中的title
		public static String GetTitle(Map<String, Object> map) {

			if (map.containsKey("title")) {
				return map.get("title").toString();
			}
			return null;
		}

	// 获取JSON的options
		public static JSONArray GetOptions(Map<String, Object> map) {
			if (map.containsKey("options")) {
				return JSONArray.fromObject(map.get("options").toString());
			}
			return null;
		}

		// 获取JSON的correct_ids 答案数组
		public static JSONArray GetCorrect_ids(Map<String, Object> map) {
			if (map.containsKey("correct_ids")) {
				return JSONArray.fromObject(map.get("correct_ids").toString());
			}
			return null;
		}

		// 获取JSON的optionID 答案ID
		public static String GetOptionID(Map<String, Object> map) {
			if (map.containsKey("id")) {
				return map.get("id").toString();
			}
			return null;
		}

		// 获取答案是否正确
		public static String GetRight(Map<String, Object> map) {
			if (map.containsKey("correct")) {
				return map.get("correct").toString();
			}
			return null;
		}
		
		// 获取考试积分
		public static String GetIntegral(Map<String, Object> map) {
			if (map.containsKey("integral")) {
				return map.get("integral").toString();
			}
			return null;
		}
		
		//获取考试时间
		public static String GetTime(Map<String, Object> map) {
			if (map.containsKey("consume_time")) {
				return map.get("consume_time").toString();
			}
			return null;
		}
		//获取正确题目数量
		public static String getCount(Map<String, Object> map) {
			if (map.containsKey("correct_amount")) {
				return map.get("correct_amount").toString();
			}
			return null;
		}
		//获取二维码
		public static String GetQrcode(Map<String, Object> map) {

			if (map.containsKey("qrcode")) {
				return map.get("qrcode").toString();
			}
			return null;
		}
		//获取创造时间
		public static String GetCreatAT(Map<String, Object> map) {

			if (map.containsKey("createdAt")) {
				return map.get("createdAt").toString();
			}
			return null;
		}
		//获取随机数
		public static String GetRandom(Map<String, Object> map) {

			if (map.containsKey("random")) {
				return map.get("random").toString();
			}
			return null;
		}
		//获取Code
		public static String GetCode(Map<String, Object> map) {

			if (map.containsKey("code")) {
				return map.get("code").toString();
			}
			return null;
		}
		//获取Message
		public static String GetMessage(Map<String, Object> map) {

			if (map.containsKey("message")) {
				return map.get("message").toString();
			}
			return null;
		}
		//获取名字
		public static String GetUserIntegral(Map<String, Object> map) {

			if (map.containsKey("integral")) {
				return map.get("integral").toString();
			}
			return null;
		}
		
		//获取参赛次数
		public static String GetJointime(Map<String, Object> map) {

			if (map.containsKey("join_times")) {
				return map.get("join_times").toString();
			}
			return null;
		}
		//获取用户积分
		public static String GetName(Map<String, Object> map) {

			if (map.containsKey("name")) {
				return map.get("name").toString();
			}
			return null;
		}
		//获取头像
		public static String GetPhoto(Map<String, Object> map) {
			if (map.containsKey("photo")) {
				return map.get("photo").toString();
			}
			return null;
		}
		//获取用户UID
		public static String GetUid(Map<String, Object> map) {
			if (map.containsKey("_id")) {
				if(map.get("_id")!=null) {
					return map.get("_id").toString();
				}
			}
			return null;
		}
		//获取Token
		public static String GetToken(Map<String, Object> map) {
			if (map.containsKey("token")) {
				return map.get("token").toString();
			}
			return null;
		}
		
		// unicode 转 UTF-8
		public static String UnicodeDecode(String string) {
			Pattern pattern = Pattern.compile("(\\\\u(\\p{XDigit}{4}))");
			Matcher matcher = pattern.matcher(string);
			char ch;
			while (matcher.find()) {
				ch = (char) Integer.parseInt(matcher.group(2), 16);
				string = string.replace(matcher.group(1), ch + "");
			}
			return string;
		}
		
		// md5加密
		public static String Md5(String data) {
			StringBuilder sb = new StringBuilder();
			try {
				MessageDigest md = MessageDigest.getInstance("md5");
				byte[] md5 = md.digest(data.getBytes(StandardCharsets.UTF_8));
				// 将字节数据转换为十六进制
				for (byte b : md5) {
					sb.append(Integer.toHexString(b & 0xff));
				}
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
//	        System.out.println(sb.toString().length());
			return sb.toString();
		}
		
		//转UTC时间
		public static String GetDate(String date) {
			date = date.replace("Z", " UTC");
//			System.out.println(date);
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS Z");
			Date d=null;
			try {
				d = format.parse(date);
			} catch (ParseException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
//			System.out.println(d);
			return d.toString();
		}

}
