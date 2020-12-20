package 用户管理;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * @author SouthWind
 *	用户余额充值
 */
public class User_Recharge extends User_Management{
	Scanner in = new Scanner(System.in);
	
	@Override
	public void UserRecharge(ArrayList<UserData> user_list,int index) {
		// TODO 自动生成的方法存根
		super.UserRecharge(user_list, index);
		/*
		 * 是否可以获取当前登陆用户名
		 * 不用再手动输入
		 */
		/*int index =-1;
		System.out.println("请输入你要充值的账户（用户名）：");
		String name = in.nextLine();
		for (int i=0;i<user_list.size();i++) {
			UserData u = user_list.get(i);
			if(u.getName().equals(name))
				index = i;
		}
		if(index==-1)
		{
			System.out.println("用户不存在");
		}*/
		float money =user_list.get(index).getMoney();
		System.out.println("------------------------------");
		System.out.println(user_list.get(index).getName()+"的账户余额："+money+"￥");
		System.out.println("请选择充值方式：");
		System.out.println("1---支付宝");
		System.out.println("2---微信");
		System.out.println("------------------------------");
		int n = in.nextInt();
		float m=0;
		switch(n) {
		case 1:
			System.out.println("请输入你要充值的金额（日限5000）:");
			m = in.nextFloat();
			break;
		case 2:
			System.out.println("请输入你要充值的金额（日限3000）:");
			m = in.nextFloat();
			break;
		default:
			System.out.println("敬请期待！");
		}
		System.out.println("------------------------------");
		//System.out.println("警告：二维码显示异常！");
		System.out.println("~充值成功！");
		user_list.get(index).setMoney(money+=m);
		System.out.println("当前账户余额："+user_list.get(index).getMoney()+"￥");
		System.out.println("------------------------------");
	}
}
