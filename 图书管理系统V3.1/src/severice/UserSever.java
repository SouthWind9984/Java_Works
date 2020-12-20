package severice;

import java.util.ArrayList;

import dao.UserDao;
import entity.UserData;

public class UserSever implements IUserSever{

	private UserDao userdao = new UserDao();
	
	@Override
	public boolean creatUser(UserData user) {
		// TODO 自动生成的方法存根
		return userdao.creatUser(user);
	}

	@Override
	public UserData findUser(String name) {
		// TODO 自动生成的方法存根
		return userdao.findUser(name);
	}

	@Override
	public ArrayList<UserData> readUser() {
		// TODO 自动生成的方法存根
		return userdao.readUser();
	}

	@Override
	public UserData updataUser(UserData user) {
		// TODO 自动生成的方法存根
		return userdao.updataUser(user);
	}

	@Override
	public boolean deleteUser(String name) {
		// TODO 自动生成的方法存根
		return userdao.deleteUser(name);
	}

}
