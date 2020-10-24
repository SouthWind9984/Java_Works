package atm01;

import java.util.Scanner;

public class Main {

	/**
	 * ATM取款机
	 * 	功能：查询余额，取款，存款，转账.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Scanner in = new Scanner(System.in);
		Finance money = new Finance();
		
		Go:
			while(true) {
			//显示欢迎信息
			ShowInfo.welcome();
			System.out.println("~~回车进入该自助ATM系统");
			String a = in.nextLine();
			
			//验证用户信息
			Authentication au = new Authentication();
			boolean flag = au.check();
//			boolean flag =true;
			if(!flag)	
				break Go;	//验证失败程序结束
			
			//打印主菜单
			String s="0";
			while(s.equals("0")) {
				ShowInfo.menu();
				int n = in.nextInt();
				switch (n) {
				case 1:
					money.inquireMoney();break;//查询余额
				case 2:
					money.drawMoney();		//取钱
					money.inquireMoney();break;
				case 3:
					money.saveMoney();		//存钱
					money.inquireMoney();break;
				case 4:
					money.transferMoney();	//转账
					money.inquireMoney();break;
				case 5:
					break Go;
				}
				while(true) {
					System.out.println("按“0”返回主菜单");
					s=in.next();
					if(s.equals("0"))
						break;
				}
			}
		}
		ShowInfo.tag();
	}
}
