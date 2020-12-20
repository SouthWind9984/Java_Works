package dao;

import java.util.ArrayList;

import entity.UserData;

public class UserDao implements IUserDao{
	
	static ArrayList<UserData> userList = new ArrayList<UserData>(); //暂时存取用户信息
	private DataSaveFile datasave = new DataSaveFile();
	//数据写入
	public void inputUser() {
		userList=datasave.readUser();
	}
	//数据读出
	public void outputUser() {
		datasave.writeUser(userList);
	}
	@Override
	public boolean creatUser(UserData user) {
		// TODO 自动生成的方法存根
		if(findUser(user.getName())==null) { //为空则增加
			UserDao.userList.add(user);
			System.out.println(user.getName());
			for(UserData user1 :userList) {
				System.out.println(user1.getName());
			}
			return true;
		}
		return false;
	}
	
	@Override
	public UserData findUser(String name) {
		// TODO 自动生成的方法存根
		for(UserData user : UserDao.userList) {
			if(name.equals(user.getName())) {
				return user;  //找到返回该用户
			}
		}
		return null; //找不到返回空
	}
	
	@Override
	public ArrayList<UserData> readUser() {
		// TODO 自动生成的方法存根
		return UserDao.userList;
	}

	@Override
	public UserData updataUser(UserData user) {
		// TODO 自动生成的方法存根
		for(int i=0;i<userList.size();i++) {
			UserData user2 = userList.get(i);
			if(user.getName()==user2.getName()) {
				userList.set(i, user);
				System.out.println("修改信息成功！");
				return user;
			}
		}
		
		return null;
	}

	@Override
	public boolean deleteUser(String name) {
		// TODO 自动生成的方法存根
		for(int i=0;i<userList.size();i++) {
			UserData user = userList.get(i);
			if(user.getName().equals(name)) {
				userList.remove(i);
				System.out.println("删除成功");
				return true;
			}
		}
		return false;
	}

	

}
