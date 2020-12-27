package dao;

import java.util.ArrayList;

import entity.User;

public interface IUserdao {
	
	public boolean creatUser (User user); //增加用户
	
	public User findUser(String name); //查找用户
	
	public ArrayList<User> showUser(); //返回所有用户
}
