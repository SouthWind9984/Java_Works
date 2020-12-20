package 用户管理;

import java.util.ArrayList;
import java.util.Scanner;

public class User_Updata extends User_Management{
	@Override
	public void UserUpdata(ArrayList<UserData> user_list,int index) {
		// TODO 自动生成的方法存根
		
		super.UserUpdata(user_list,index);
		UserData user = user_list.get(index);
		Scanner in = new Scanner(System.in);
		G:
			while(true) {
				System.out.println("------------------------------------------------------------");
				System.out.println("\t\t用户修改页");
				System.out.println("当前用户信息：");
				System.out.println("用户名\t密码\t地址\t\t余额");
				System.out.println(user.getName()+"\t"
						+user.getPasswd()+"\t"
						+user.getAddress()+"\t"
						+user.getMoney()+"￥");
				System.out.println();
				System.out.println("1----用户名");
				System.out.println("2----密码");
				System.out.println("3----地址");
				System.out.println("4----注销账户");
				System.out.println("5----退出用户修改页");
				System.out.println("选择你要进行的操作：");
				int n = in.nextInt();
				String ss= in.nextLine();
				switch (n) {
				case 1:
					System.out.println("请输入你要将"+user.getName()+"更改为：");
					String name = in.nextLine();
					if(name.isEmpty()) {
							System.out.println("用户名不能为空！");
					}
					else {
						boolean flag =true;
						for(int i=0; i<user_list.size();i++)
						{
							UserData u = user_list.get(i);
							if(u.getName().equals(name))
								flag = false;
						}
						if(!flag) {
							System.out.println("该用户名已经存在！");
						}
						else {
						user.setName(name);
						user_list.set(index, user);
						System.out.println("用户名更改成功！");
						}
					}
					break;
				case 2:
					int count =0;
					boolean falg = false;
					while(count<2) {
						System.out.println("请输入你要将"+user.getPasswd()+"更改为：");
						String pwd1 = in.nextLine();
						if(pwd1.length()<6||pwd1.equals(user.getPasswd())) {
							System.out.println("密码不能少于6位！重新输入");
							count++;
						}
						else {
							System.out.println("再次确认你的密码：");
							String pwd2 = in.nextLine();
							if(pwd1.equals(pwd2)) {
								user.setPasswd(pwd1);
								user_list.set(index, user);
								System.out.println("密码更改成功！");
								falg = true;
								break;
							}
							else{
								count++;
								System.out.println("两次密码不一样，请确认后输入");
							}
						}
					}
					if(!falg)
						System.out.println("今日更改密码次数错误两次，稍后再试！");
					break;
				case 3:
					System.out.println("请输入你要将"+user.getAddress()+"更改为：");
					String add = in.nextLine();
					if(add.isEmpty()) {
						System.out.println("地址不能为空！");
					}
					else {
					user.setAddress(add);
					user_list.set(index, user);
					System.out.println("地址更改成功！");}
					break;
				case 4:
					System.out.println("注销账户，个人信息及余额将消除！");
					System.out.println(user.getName()+"你是否要注销账户（Y\\N)");
					String s = in.next();
					if(s.equals("Y")||s.equals("y")) {
						System.out.println("请输入你的密码！");
						String pwd3= in.nextLine();
						if(pwd3.equals(user.getPasswd()))
						{
							user_list.remove(index);
							System.out.println("账户注销成功！");
						}
						else 
							System.out.println("密码错误，注销失败！");
					}
					else if(s.equals("N")||s.equals("n")) {
						System.out.println("注销账户操作被取消！");
					}
					else {
						System.out.println("~擦亮眼睛，再来操作！");
					}
					break;
				case 5:
					break G;
			}
		}
	}
	//管理员修改用户信息
	public void UserUpdata(ArrayList<UserData> user_list) {
		Scanner in = new Scanner(System.in);
		int index = -1;
		System.out.println("请输入你要修改的用户：");
		String name = in.nextLine();
		for(int i=0; i<user_list.size();i++)
		{
			UserData u = user_list.get(i);
			if(u.getName().equals(name))
				index = i;
		}
		if(index==-1) {
			System.out.println("暂无此用户！");
		}
		else {
			UserData user = user_list.get(index);
			G:
			while(true) {
				
				System.out.println("-----------------------------------------------");
				System.out.println("\t\t用户修改页");
				System.out.println("当前用户信息：");
				System.out.println("用户名\t密码\t地址\t\t余额");
				System.out.println(user.getName()+"\t"
						+user.getPasswd()+"\t"
						+user.getAddress()+"\t"
						+user.getMoney()+"￥");
				System.out.println();
				System.out.println("1----用户名");
				System.out.println("2----密码");
				System.out.println("3----地址");
				System.out.println("4----余额");
				System.out.println("5----注销账户");
				System.out.println("6----退出用户修改页");
				System.out.println("请选择你要修改的信息：");
				System.out.println("-----------------------------------------------");
				int n = in.nextInt();
				String ss = in.nextLine();
				switch(n) {
				case 1:
					System.out.println("请输入你要将“"+user.getName()+"”更改为：");
					String name2 = in.nextLine();
					if(name2.isEmpty())
					{
						System.out.println("用户名不能为空！");
					}
					else {
						boolean flag =true;
						for(int i=0; i<user_list.size();i++)
						{
							UserData u = user_list.get(i);
							if(u.getName().equals(name))
								flag = false;
						}
						if(!flag) {
							System.out.println("该用户名已经存在！");
						}
						else {
							user.setName(name2);
							user_list.set(index, user);
							System.out.println("用户名更改成功！");
						}
					}
					
					break;
				case 2:
					while(true) {
						System.out.println("请输入你要将旧密码“"+user.getPasswd()+"”更改为：");
						String pwd1 = in.nextLine();
						if(pwd1.length()<6) {
							System.out.println("密码不能少于6位！重新输入");
						}
						else {
							System.out.println("再次确认密码：");
							String pwd2 = in.nextLine();
							if(pwd1.equals(pwd2)) {
								user.setPasswd(pwd1);
								user_list.set(index, user);
								System.out.println("密码更改成功！");
								break;
							}
							else{
								System.out.println("两次密码不一样，请重新输入");
							}
						}
					}
					break;
				case 3:
					System.out.println("请输入你要将“"+user.getAddress()+"”更改为：");
					String add = in.nextLine();
					if(add.isEmpty()) {
						System.out.println("地址不能为空！");
					}else {
					user.setAddress(add);
					user_list.set(index, user);
					System.out.println("地址更改成功！");}
					break;
				case 4:
					System.out.println("------------------------------------------------------");
					System.out.println("当前“"+user.getName()+"”的余额为“"+user.getMoney()+"”￥");
					System.out.println("------------------------------------------------------");
					System.out.println("请输入你将修改的金额：");
					float money = in.nextFloat();
					user.setMoney(money);
					System.out.println("余额修改成功！");
					System.out.println("------------------------------------------------------");
					System.out.println("当前“"+user.getName()+"”的余额为“"+user.getMoney()+"”￥");
					System.out.println("------------------------------------------------------");
					user_list.set(index, user);
					break;
				case 5:
					System.out.println("注销账户，个人信息及余额将消除！");
					System.out.println("是否要注销"+user.getName()+"的账户（Y\\N)");
					String s = in.next();
					if(s.equals("Y")||s.equals("y")) {
						user_list.remove(index);
						System.out.println(user.getName()+"已注销！");
					}
					else if(s.equals("N")||s.equals("n")) {
						System.out.println("注销账户操作被取消！");
					}
					else {
						System.out.println("~擦亮眼睛，再操作！");
					}
					break;
				case 6:
					break G;
				}
				/*while(true) {
					System.out.println("按“0”返回主菜单");
					String sss=in.next();
					if(sss.equals("0"))
						break;
				}
				*/
			}
		}
	}
}
