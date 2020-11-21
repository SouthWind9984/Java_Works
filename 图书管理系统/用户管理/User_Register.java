package 用户管理;

import java.util.ArrayList;
import java.util.Scanner;

public class User_Register extends User_Management{
//注册
	@Override
	public void UserRegister(ArrayList<UserData> user_list) {
		// TODO 自动生成的方法存根
		super.UserRegister(user_list);
		Scanner in = new Scanner(System.in);
		Register:
		while(true) {
			boolean flag = true;
			System.out.println("请输入用户名：");
			String user_name = in.nextLine();
			for(int i=0; i<user_list.size();i++)
			{
				UserData u = user_list.get(i);
				if(u.getName().equals(user_name))
					flag = false;
			}
			if(!flag) {
				System.out.println("------------------------------");
				System.out.println("该用户名已经存在，擦亮眼后重新输入！");
				System.out.println("------------------------------");
			}
			else {
				while(true) {
					System.out.println("请输入密码：");
					String passwd1 = in.nextLine();
					if(passwd1.length()<6)
						System.out.println("密码少于6位，重新输入！");
					else {
						System.out.println("请再次确认你的密码：");
						String passwd2 = in.nextLine();
						if(passwd1.equals(passwd2))
						{
							UserData d = new UserData();
							d.setName(user_name);
							d.setPasswd(passwd1);
							user_list.add(d);
							System.out.println("------------------------");
							System.out.println("用户“"+user_name+"”注册成功~请保存好密码！");
							System.out.println("------------------------");
							System.out.println("~任意键返回登陆界面");
							String s = in.nextLine();
							break Register;
						}
						else {
							System.out.println("------------------------------");
							System.out.println("两次密码不一样，请擦亮眼睛后重新输入！");
							System.out.println("------------------------------");
						}
					}
				}
			}
		}
	}
}
