package server;

import java.util.ArrayList;

import dao.ContactDao;
import entiy.Contact;

public class ContactSever implements IContactSever{
	
	private ContactDao contactDao = new ContactDao();
	
	@Override
	public boolean creatContact(Contact con) {
		// TODO 自动生成的方法存根
		return contactDao.creatContact(con);
	}

	@Override
	public Contact findContact(String name) {
		// TODO 自动生成的方法存根
		return contactDao.findContact(name);
	}

	@Override
	public ArrayList<Contact> showContact() {
		// TODO 自动生成的方法存根
		return contactDao.showContact();
	}

	@Override
	public boolean deleteContact(String name) {
		// TODO 自动生成的方法存根
		return contactDao.deleteContact(name);
	}

}
