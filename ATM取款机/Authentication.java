package atm01;

import java.util.Scanner;

public class Authentication extends User{
	/**
	 * 	验证用户信息
	 */
	public Authentication() {
		super();
		// TODO 自动生成的构造函数存根
	}

	public boolean check() {
		Scanner in = new Scanner(System.in);
		boolean flag=false;
		int count =0;
		String passwd="";
		String number="";
		while(count<=2) {
			System.out.println("请输入你的银行卡号：");
			number= in.nextLine();
			System.out.println("请输入你的密码：");
			passwd =in.nextLine();
			if(getCardNumber().equals(number)&&getPassWord().equals(passwd)){
				System.out.println("****************************");
				System.out.println("欢迎尊敬的“"+getName()+"”客户使用该ATM系统");
				System.out.println("****************************");
				flag = true;
				break;
			}
			else {
				count++;
				if(count<=2) {
					System.out.println("验证失败，请重新输入");
				}
				else
					System.out.println("今日已经错误三次，明天再试");
			}
		}
		return flag;
	}

}
