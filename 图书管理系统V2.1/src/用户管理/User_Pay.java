package 用户管理;

import java.util.ArrayList;
/**
 * 购买图书
 * @author SouthWind
 *
 */
import java.util.Scanner;

import 图书管理.BookData;

public class User_Pay extends User_Management{
	
	@Override
	public void UserPay(ArrayList<UserData> user_list,ArrayList<BookData> book_list, int index) {
		// TODO 自动生成的方法存根
		super.UserPay(user_list, book_list, index);
		Scanner in =new Scanner(System.in);
		System.out.println("请输入你要购买的图书ID：");
		int id = in.nextInt();
		int ind = -1;
		for(int i=0;i<book_list.size();i++) {
			BookData b = new BookData();
			b = book_list.get(i);
			if(b.getBookID()==id)
				ind = i;
		}
		if(ind ==-1) {
			System.out.println("---------------------");
			System.out.println("该图书ID不存在，请重新确认！");
			System.out.println("---------------------");
		}
		else {
			BookData d = book_list.get(ind);
			System.out.println("当前"+d.getBookname()+"库存"+d.getNumber()+"本，单价："+d.getMoney());
			System.out.println("请输入你要购买的本数：");
			int n = in.nextInt();
			if(n>d.getNumber()) {
				System.out.println("库存不足！已自动提醒管理员抓紧补货！");
				
			}
			else{
				float book_money=d.getMoney()*n;
				float user_money=user_list.get(index).getMoney();
				if(book_money>user_money)
					System.out.println("余额不足");
				else {
					try {
						if(user_list.get(index).getAddress().isEmpty()) {}
						else
							{
								user_money = user_money-book_money;
								user_list.get(index).setMoney(user_money);
								d.setNumber(d.getNumber()-n);
								System.out.println("-----------------------------------");
								System.out.println("购买成功，预计三天之内送达"+user_list.get(index).getAddress());
								System.out.println("-----------------------------------");
							}
					} catch (NullPointerException e) {
						// TODO: handle exception
						System.out.println("------------------------");
						System.out.println("请先去添加你的个人地址，再来购买!");
						System.out.println("------------------------");
					}
					
				}
			}
		}
		
	}
	
}
