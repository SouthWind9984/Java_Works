package ui;

import dao.BookDao;
import dao.UserDao;
import entity.UserData;
import windowsBuilder.Login;

public class Start {
	 
	public static void main(String[] args) {
		UserDao userDao = new UserDao();
		 BookDao bookDao = new BookDao();
		//数据读入
		 bookDao.inputBook();
		 userDao.inputUser();
		 Login login = new Login(); //登陆窗口
			login.setVisible(true);
	
	}
}
