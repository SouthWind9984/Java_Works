package server;

import java.util.Scanner;

public class DeleteContact {

	private ContactSever contactSever = new ContactSever();
	
	Scanner in = new Scanner(System.in);
	public DeleteContact() {
		// TODO 自动生成的构造函数存根
		System.out.println("请输入你要删除联系人的姓名：");
		String name =in.nextLine();
		if(contactSever.deleteContact(name)) {
			System.out.println("删除成功！");
		}
		else {
			System.out.println("查无此人！");
		}
	}
}
