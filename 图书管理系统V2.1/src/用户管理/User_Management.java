package 用户管理;

import java.util.ArrayList;

import 图书管理.BookData;

public abstract class User_Management {
	//登陆验证
		public int userVerify(ArrayList<UserData> user_list) {
			return 0;
		}
	//注册
	public void UserRegister(ArrayList<UserData> user_list) {
		
	}
	//修改个人信息
	public void UserUpdata(ArrayList<UserData> user_list,int index) {
		
	}
	//充值
	public void UserRecharge(ArrayList<UserData> user_list,int index) {
		
	}
	//图书购买
	public void UserPay(ArrayList<UserData> user_list,ArrayList<BookData> book_list,int index) {
		
	}
	//查看个人信息
	public void UserRead(ArrayList<UserData> user_list,int index) {
		
	}
	//查看所有用户
	public void UserRead(ArrayList<UserData> user_list) {
		
	}

}
