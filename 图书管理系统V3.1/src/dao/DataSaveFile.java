package dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import entity.*;

public class DataSaveFile {

	File UserData = new File("src//Data//UserData2.txt");
	File BookData = new File("src//Data//BookData2.txt");
	//存储用户
	public void writeUser(ArrayList<entity.UserData> user_data) {
		FileOutputStream fos =null;
		ObjectOutputStream objop = null;
		try {
			//存取用户
			fos = new FileOutputStream(UserData);
			objop = new ObjectOutputStream(fos);
			objop.writeObject(user_data);
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
				fos.close();
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
		
	}
	
	//存储图书
		public void writeBook(ArrayList<entity.BookData> book_data) {
			FileOutputStream fot =null;
			ObjectOutputStream objot =null;
			try {
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
					objot.close();
					fot.close();
				} catch (IOException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
				
			}
		}
		//图书数据读入
		@SuppressWarnings("unchecked")
		public ArrayList<entity.BookData> readBook() {
//			File UserData = new File("src//UserData.txt");
//			File BookData = new File("src//BookData.txt");
			ArrayList<entity.BookData> bookdata = new ArrayList<entity.BookData>();
			FileInputStream fit =null;
			ObjectInputStream objit = null;
			try {
				fit = new FileInputStream(BookData);
				objit = new ObjectInputStream(fit);
				bookdata = (ArrayList<entity.BookData>) objit.readObject();
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
		@SuppressWarnings("unchecked")
		public ArrayList<entity.UserData> readUser() {
			ArrayList<entity.UserData> userdata = new ArrayList<entity.UserData>(); 
			FileInputStream fis = null;
			ObjectInputStream objip = null;
			try {
				fis = new FileInputStream(UserData);
				objip = new ObjectInputStream(fis);
				userdata = (ArrayList<entity.UserData>) objip.readObject();
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
