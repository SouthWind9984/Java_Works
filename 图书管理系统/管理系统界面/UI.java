package 管理系统界面;

public class UI {
	
	public static void wellcome() {
		System.out.println("\t————欢迎光临By丶SouthWind图书管理系统");
		System.out.println("\t\t有问题联系：QQ:728097735");
	}
	public static void LogIn() {
		
		System.out.println("* * * * * * * * * *");
		System.out.println("*  --登陆界面--   *");
		System.out.println("* 1----用户登陆   *");
		System.out.println("* 2----用户注册   *");
		System.out.println("* 3----管理员     *");
		System.out.println("* 4----退出系统   *");
		System.out.println("* * * * * * * * * *");
		System.out.println("请选择你要进行的操作：");
		
	}
	public static void User_Menu() {
		System.out.println("* * * * * * * * * * * *");
		System.out.println("*   --商城主页--      *");
		System.out.println("*  1----查看所有图书  *");
		System.out.println("*  2----查看个人信息  *");
		System.out.println("*  3----修改个人信息  *");
		System.out.println("*  4----购买图书      *");
		System.out.println("*  5----余额充值      *");
		System.out.println("*  6----退出登陆      *");
		System.out.println("* * * * * * * * * * * * ");
	}
	public static void Admin_Menu() {
		System.out.println("* * * * * * * * * * * *");
		System.out.println("*     --后台主页--    *");
		System.out.println("*  1----增加图书信息  *");
		System.out.println("*  2----查看图书信息  *");
		System.out.println("*  3----修改图书信息  *");
		System.out.println("*  4----删除图书信息  *");
		System.out.println("*  5----查看所有用户  *");
		System.out.println("*  6----修改用户信息  *");
		System.out.println("*  7----退出登陆      *");
		System.out.println("* * * * * * * * * * * *");
	}
	public static void Tag() {
		System.out.println("------------------------------------------------------");
		System.out.println("感谢你使用By丶SouthWind图书管理系统!");
		System.out.println("\tSee you next time！");
		System.out.println("------------------------------------------------------");
	}
	

}
