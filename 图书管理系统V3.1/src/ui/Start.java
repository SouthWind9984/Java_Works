package ui;

import bookShopUi.Login;
import dao.BookDao;
import dao.UserDao;
import entity.UserData;

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
