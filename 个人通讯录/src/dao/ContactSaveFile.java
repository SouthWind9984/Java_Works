package dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import entiy.Contact;

public class ContactSaveFile {

	private	File data = new File("src//ContactData.txt");
	
	//数据写进程序

	public ArrayList<Contact> readData() {
		
		FileInputStream fis = null;
		ObjectInputStream objis = null;
		ArrayList<Contact> contacts = new ArrayList<Contact>();
		try {
			fis = new FileInputStream(data);
			objis = new ObjectInputStream(fis);
			contacts = (ArrayList<Contact>) objis.readObject();
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
				objis.close();
				fis.close();
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			
		}
		return contacts;
	}
	
	//数据读入文件
	public void writeData(ArrayList<Contact> contacts) {
		
		FileOutputStream fos = null;
		ObjectOutputStream objos= null;
		
		try {
			fos = new FileOutputStream(data);
			objos = new ObjectOutputStream(fos);
			objos.writeObject(contacts);
		} catch (FileNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		finally {
			try {
				objos.close();
				fos.close();
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
		
	}

}
