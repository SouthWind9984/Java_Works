package 用户管理;

import java.util.ArrayList;

public class User_Read extends User_Management{

	@Override
	public void UserRead(ArrayList<UserData> user_list) {
		// TODO 自动生成的方法存根
		super.UserRead(user_list);
		System.out.println("----------------------------------------");
		System.out.println("用户名\t\t密码\t\t地址\t\t余额");
		for(int i=0;i<user_list.size();i++)
		{
			UserData u = user_list.get(i);
			System.out.println(u.getName()+"\t\t"
					+u.getPasswd()+"\t\t"
					+u.getAddress()+"\t"
					+u.getMoney()+"￥");
		}
		System.out.println("----------------------------------------");
	}
}
