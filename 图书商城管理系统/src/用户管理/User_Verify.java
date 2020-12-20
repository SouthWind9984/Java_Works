package 用户管理;

import java.util.ArrayList;
import java.util.Scanner;

public class User_Verify extends User_Management{
	Scanner in = new Scanner(System.in);
	@Override
	public int userVerify(ArrayList<UserData> user_list) {
		// TODO 自动生成的方法存根
		super.userVerify(user_list);
		int index = -1;//标记
		System.out.println("请输入你的用户名：");
		String user_name = in.nextLine();
		for(int i=0; i<user_list.size();i++)
		{
			UserData u = user_list.get(i);
			if(u.getName().equals(user_name))
				index = i;
		}
		if(index==-1) {
			System.out.println("--------------");
			System.out.println("该用户名不存在！");
			System.out.println("--------------");
		}
		else {
			System.out.println("请输入你的密码：");
			String passwd= in.nextLine();
			UserData d = user_list.get(index);
			if(passwd.equals(d.getPasswd())){
				System.out.println("欢迎"+d.getName()+"进入图书商城！");
			}
			else {
				System.out.println("密码错误，脑子清醒后再登陆！");
				index = -1;
			}
		}
		return index;
	}
	//管理员验证
	public boolean adminVerify(ArrayList<UserData> user_list) {
		// TODO 自动生成的方法存根
		super.userVerify(user_list);
		boolean flag = false;
		System.out.println("请输入管理员用户名：");
		String user_name = in.nextLine();
			if(user_name.equals("SouthWind"))
			{
				flag = true;
			}
				
		if(!flag) {
			System.out.println("------------------");
			System.out.println("非管理员用户，禁止登陆！！");
			System.out.println("------------------");
		}
		else {
			System.out.println("请输入管理员密码：");
			String passwd= in.nextLine();
			if(!passwd.equals("SouthWind")){
				System.out.println("密码错误！登陆失败！");
				flag = false;
			}
			else {
				System.out.println("登陆成功！");
			}
		}
		return flag;
	}
}
