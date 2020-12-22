package server;

import java.util.ArrayList;

import entiy.Contact;

public interface IContactSever {

public boolean creatContact(Contact con); //增加联系人
	
	public Contact findContact(String name); //根据姓名查找
	
	public ArrayList<Contact> showContact(); //显示所有联系人
	
	public boolean deleteContact(String name); //删除联系人 
}
