package 数据存储;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import 图书管理.BookData;
import 用户管理.UserData;

public class DataWriteRead {
	
	File UserData = new File("src//UserData.txt");
	File BookData = new File("src//BookData.txt");
	//动态路径获取（待研究~）
	InputStream UserDatapath = this.getClass().getResourceAsStream("/src/UserData.txt");
	InputStream BookDatapath = this.getClass().getResourceAsStream("/src/BookData.txt");
	//存储
	public void write(ArrayList<BookData> book_data,ArrayList<UserData> user_data) {
		
		FileOutputStream fos =null;
		ObjectOutputStream objop = null;
		FileOutputStream fot =null;
		ObjectOutputStream objot =null;
		try {
			//存取用户
			fos = new FileOutputStream(UserData);
			objop = new ObjectOutputStream(fos);
			objop.writeObject(user_data);
			
			//存取图书
			fot = new FileOutputStream(BookData);
			objot = new ObjectOutputStream(fot);
			objot.writeObject(book_data);
			
			
		} catch (FileNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		finally {
			try {
				objop.close();
				objot.close();
				fos.close();
				fot.close();
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			
		}
	}
	
	//图书数据读入
	public ArrayList<BookData> readBook() {
//		File UserData = new File("src//UserData.txt");
//		File BookData = new File("src//BookData.txt");
		ArrayList<BookData> bookdata = new ArrayList<BookData>();
		FileInputStream fit =null;
		ObjectInputStream objit = null;
		try {
			fit = new FileInputStream(BookData);
			objit = new ObjectInputStream(fit);
			bookdata = (ArrayList<图书管理.BookData>) objit.readObject();
		} catch (FileNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		finally {
			try {
				objit.close();
				fit.close();
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
		return bookdata;
		
	}
	//用户数据读入
	public ArrayList<UserData> readUser() {
		ArrayList<UserData> userdata = new ArrayList<UserData>(); 
		FileInputStream fis = null;
		ObjectInputStream objip = null;
		try {
			fis = new FileInputStream(UserData);
			objip = new ObjectInputStream(fis);
			userdata = (ArrayList<用户管理.UserData>) objip.readObject();
		} catch (FileNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		finally {
			try {
				objip.close();
				fis.close();
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
		return userdata;
		
	}

}
