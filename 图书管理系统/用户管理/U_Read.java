package 用户管理;

import java.util.ArrayList;

public class U_Read extends User_Management{

	@Override
	public void UserRead(ArrayList<UserData> user_list, int index) {
		// TODO 自动生成的方法存根
		super.UserRead(user_list, index);
		System.out.println("----------------------------------------");
		System.out.println("用户名\t密码\t地址\t\t余额");
		UserData u = user_list.get(index);
		System.out.println(u.getName()+"\t"
				+u.getPasswd()+"\t"
				+u.getAddress()+"\t"
				+u.getMoney()+"￥");
		System.out.println("----------------------------------------");
	}
}
