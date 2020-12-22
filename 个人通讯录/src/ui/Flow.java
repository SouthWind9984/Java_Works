package ui;

import java.util.Scanner;

import dao.ContactDao;
import server.ContactSever;
import server.CreatContact;
import server.DeleteContact;
import server.FindContact;
import server.ShowContact;

public class Flow {
	
	
	public static void main(String[] args) {
		ContactDao contactDao = new ContactDao();
		contactDao.inputContact();
		
		Scanner in = new Scanner(System.in);
		Goto:
		while(true) {
			System.out.println("\t~欢迎使用小小怪通讯录");
			System.out.println("1----增加联系人");
			System.out.println("2----显示所有联系人");
			System.out.println("3----删除联系人");
			System.out.println("4----查找联系人");
			System.out.println("5----退出系统");
			System.out.println("请选择你的操作：");
			int n = in.nextInt();
			switch(n) {
			case 1:
				CreatContact creat = new CreatContact();
				break;
			case 2:
				ShowContact showContact = new ShowContact();
				break;
			case 3:
				DeleteContact deleteContact = new DeleteContact();
				break;
			case 4:
				FindContact findContact = new FindContact();
				break;
			case 5:break Goto;
			}
			while(true) {
				System.out.println("按“0”返回主菜单");
				String s=in.next();
				if(s.equals("0"))
					break;
			}
		}
		contactDao.outputContact();
		System.out.println("感谢你使用小小怪通讯录!");
		System.out.println("\tSee you next time！");
	}
	
}
