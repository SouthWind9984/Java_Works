package dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;

import entity.User;

public class Userdao implements IUserdao{
	File file = new File("src//data//user.txt");
	ArrayList<User> userList = new ArrayList<User>();
	
	@Override
	public boolean creatUser(User user) {
		// TODO 自动生成的方法存根
		
		if(findUser(user.getName())==null) {
			userList.add(user);
			return true;
		}
		return false;
	}

	@Override
	public User findUser(String name) {
		// TODO 自动生成的方法存根
		for(User user :userList) {
			if(user.getName().equals(name)) {
				return user;
			}
		}
		return null;
	}
	
	
	//用户读入
	public void inputUser() {
		FileInputStream fis = null;
		ObjectInputStream objis =null;
		try {
			fis = new FileInputStream(file);
			objis = new ObjectInputStream(fis);
			userList =(ArrayList<User>) objis.readObject();
		} catch (FileNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO 自动生成的 catch 块
			System.out.println("格式错误");
		} finally {
			try {
				objis.close();
				fis.close();
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			
		}
		
	}
	//存取用户
	public void writeUser() {
		OutputStream os=null;
		ObjectOutputStream objos= null;
		try {
			
			os=new FileOutputStream(file);
			objos = new ObjectOutputStream(os);
			objos.writeObject(userList);
		} catch (FileNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally {
			try {
				objos.close();
				os.close();
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
	}

	@Override
	public ArrayList<User> showUser() {
		// TODO 自动生成的方法存根
		return userList;
	}

}
