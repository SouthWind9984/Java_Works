package java_02;

import java.util.Scanner;

/*实现会员注册，要求用户名长度不小于3，
 * 密码长度不小于6，注册时两次输入密码必须相同（字符串）*/

public class Java_11 {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Scanner in = new Scanner(System.in);
		boolean f = false;
		String user = "null";
		String posswd = "null";
		System.out.println("请输入用户名：");
		while (!f) {

			user = in.nextLine();
			if (user.length() < 3) {
				System.out.println("用戶名長度小于3位\n請重新輸入：");
			} else
				f = true;
		}
		f = false;
		System.out.println("请输入密码：");
		while (!f) {

			posswd = in.nextLine();
			if (posswd.length() < 6) {
				System.out.println("密碼長度小於6位，请重新输入：");
				continue;
			}
			System.out.println("请再次确认你的密码：");
			String posswdd = in.nextLine();
			if (!posswdd.equals(posswd)) {
				System.out.println("两次密码输入不一样，请重新输入：");
				continue;
			} else
				f = true;
		}
		System.out.println("请保存好你的账户和密码！\n" + "用户名：" + user + " " + "密码：" + posswd);
	}

}
