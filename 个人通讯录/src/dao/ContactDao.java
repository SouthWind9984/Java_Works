package dao;

import java.util.ArrayList;

import entiy.Contact;

public class ContactDao implements IContactDao {

	static ArrayList<Contact> conList = new ArrayList<Contact>(); //暂时存取联系人信息
	
	ContactSaveFile savefile = new ContactSaveFile();
	
	//读入
	public void inputContact() {
		conList=savefile.readData();
//		savefile.readData();
	}
	//存取
	public void outputContact() {
		savefile.writeData(conList);
	}
	
	@Override
	public boolean creatContact(Contact con) {
		// TODO 自动生成的方法存根
		if(findContact(con.getName())==null) {
			conList.add(con);
			return true; //添加返回真
		}
		return false;
	}

	@Override
	public Contact findContact(String name) {
		// TODO 自动生成的方法存根
		for(Contact con : conList) {
			if(con.getName().equals(name)) {
				return con;
			}
		}
		return null; //找不到返回空
	}

	@Override
	public ArrayList<Contact> showContact() {
		// TODO 自动生成的方法存根
		return conList;
	}

	@Override
	public boolean deleteContact(String name) {
		// TODO 自动生成的方法存根
		for(int i=0;i<conList.size();i++) {
			Contact con =conList.get(i);
			if(con.getName().equals(name)) {
				conList.remove(i);
				return true;
			}
		}
		return false;
	}

}
