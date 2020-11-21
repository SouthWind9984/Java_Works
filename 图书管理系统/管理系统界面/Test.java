package 管理系统界面;

import java.util.ArrayList;
import java.util.Scanner;

import 图书管理.Add;
import 图书管理.BookData;
import 图书管理.Delete;
import 图书管理.Read;
import 图书管理.Updata;
import 用户管理.U_Read;
import 用户管理.UserData;
import 用户管理.User_Pay;
import 用户管理.User_Read;
import 用户管理.User_Recharge;
import 用户管理.User_Register;
import 用户管理.User_Updata;
import 用户管理.User_Verify;

public class Test {
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		//创建存储图书列表
		ArrayList<BookData> book_data = new ArrayList<>();
		//添加图书
		BookData b1 = new BookData(101, "Java", "小小怪", 88.8f, 10);
		BookData b2 = new BookData(102, "Asp.Net", "小小小怪", 99.9f, 50);
		BookData b3 = new BookData(103, "Web开发", "大大怪", 66.6f, 15);
		BookData b4 = new BookData(104, "SQL", "大大大怪", 45.0f, 20);
		BookData b5 = new BookData(105, "数据结构", "大大小小怪", 85.0f, 10);
		book_data.add(b1);book_data.add(b2);book_data.add(b3);book_data.add(b4);book_data.add(b5);
		//创建存储用户列表
		ArrayList<UserData> user_data = new ArrayList<>();
		//添加用户
		UserData u1 = new UserData("海绵宝宝", "123456", "贝壳街菠萝屋",188f);
		UserData u2 = new UserData("派大星", "123456", "贝壳街石头屋",288f);
		UserData u3 = new UserData("章鱼哥", "Admin", "贝克街#11号",388f);
		UserData u4 = new UserData("蟹老板", "666666", "蟹堡王餐厅屋", 488f);
		user_data.add(u1);user_data.add(u2);user_data.add(u3);user_data.add(u4);
		
		
		Add a = new Add();
		Read r = new Read();
		Updata u = new Updata();
		Delete d= new Delete();
		
		User_Verify ver = new User_Verify();//验证
		User_Register reg = new User_Register();//注册
		User_Read read = new User_Read();//查看所有用户
		U_Read rea = new U_Read();//查看个人信息
		User_Recharge rec = new User_Recharge();//金额充值
		User_Updata up = new User_Updata();//更新用户信息
		User_Pay pay = new User_Pay();//购买图书
		//显示欢迎信息
		UI.wellcome();
		Scanner in = new Scanner(System.in);
		System.out.println("~按任意键进入");
		String s = in.nextLine();
		Login:
		while(true) {
			UI.LogIn(); //登陆界面
			int k = in.nextInt();
			int rank = 0;
			boolean flag= false;
			int index = -1;
			switch(k) {
			case 1:
				index = ver.userVerify(user_data);//用户登陆验证
				if(index!=-1) rank =1;
				break;
			case 2:
				reg.UserRegister(user_data);//注册
				break;
			case 3:
				flag =ver.adminVerify(user_data);//管理员登陆验证
				if(flag) rank =2;
				break;
			case 4:
				rank =3;
				break;
			default:
				System.out.println("擦亮眼睛，再选择！");
			}
			
			//用户界面
			switch(rank) {
			case 1:
				User:
				while(true) {
					UI.User_Menu();
					System.out.println("请选择你要进行的操作");
					int n = in.nextInt();
					switch (n) {
					case 1: //查看图书
						r.read(book_data);
						break;
					case 2://查看个人信息
						rea.UserRead(user_data, index);
						break;
					case 3://修改信息
						up.UserUpdata(user_data, index);
						break;
					case 4://购买图书
						pay.UserPay(user_data,book_data,index);
						break;
					case 5://余额充值
						rec.UserRecharge(user_data, index);
						break;
					case 6:
						break User;
					}
					while(true) {
						System.out.println("按“0”返回主菜单");
						s=in.next();
						if(s.equals("0"))
							break;
					}
				}
			break;
			
			//管理员界面
			case 2:
				Admin:
				while(true) {
					UI.Admin_Menu();
					System.out.println("请选择你要进行的操作");
					int n = in.nextInt();
					switch (n) {
					case 1:
						a.add(book_data);//添加
						break;
					case 2:
						r.read(book_data);//查看
						break;
					case 3:
						u.updata(book_data);//更新
						break;
					case 4:
						d.delete(book_data);//删除
						break;
					case 5:
						read.UserRead(user_data);//查看用户
						break;
					case 6:
						up.UserUpdata(user_data);//修改用户
						break;
					case 7:
						break Admin;
					}
					while(true) {
						System.out.println("按“0”返回主菜单");
						s=in.next();
						if(s.equals("0"))
							break;
					}
				}
				break;
				case 3:
					break Login; //退出系统
			 }
		}	
		UI.Tag();//结束语
	}
}
