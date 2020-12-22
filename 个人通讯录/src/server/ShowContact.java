package server;

import java.util.ArrayList;

import entiy.Contact;

public class ShowContact {

	private ContactSever contactSever = new ContactSever();
	public ShowContact() {
		// TODO 自动生成的构造函数存根
		ArrayList<Contact> contacts = contactSever.showContact();
		System.out.println("----------------------------------------");
		System.out.println("姓名\t手机号\t地址\t");
		for (Contact contact : contacts) {
			System.out.println(contact.getName()+"\t"+contact.getPhone()+"\t"+contact.getEmail());
		}
		System.out.println("----------------------------------------");
	}
}
