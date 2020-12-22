package server;

import java.util.Scanner;

import entiy.Contact;

public class CreatContact {
	
	private ContactSever contactSever = new ContactSever();
	
	Scanner in = new Scanner(System.in);
	public CreatContact() {
		// TODO 自动生成的构造函数存根
		System.out.println("请输入添加的联系人姓名：");
		String name = in.nextLine();
		System.out.println("请输入手机号：");
		String phone = in.nextLine();
		System.out.println("请输入E-mail：");
		String email = in.nextLine();
		
		Contact contact = new Contact(name,phone,email);
		contactSever.creatContact(contact);
	}

}
