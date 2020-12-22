package server;

import java.util.Scanner;

import entiy.Contact;

public class FindContact {
	private ContactSever contactSever = new ContactSever();
	Scanner in = new Scanner(System.in);
	public FindContact() {
		// TODO 自动生成的构造函数存根
		System.out.println("请输入你要查找联系人的姓名：");
		String name =in.nextLine();
		Contact contact =contactSever.findContact(name);
		if(contact==null) {
			System.out.println("查无此人！");
		}
		else {
			System.out.println("----------------------------------------");
			System.out.println(contact.getName()+"\t"+contact.getPhone()+"\t"+contact.getEmail());
			System.out.println("----------------------------------------");
		}
	}

}
