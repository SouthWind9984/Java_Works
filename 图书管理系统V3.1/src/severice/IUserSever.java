package severice;

import java.util.ArrayList;

import entity.UserData;

public interface IUserSever {
	
	public boolean creatUser (UserData user); //增加用户
	
	public UserData findUser(String name); //依用户名查找用户
	
	public ArrayList<UserData> readUser(); //获取所有用户
	
	public UserData updataUser(UserData user); //更新用户信息
	
	public boolean deleteUser(String name); //删除用户
	
}
