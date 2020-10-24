package atm01;

public class ShowInfo {
	
	/*
	 * 	展示，输出信息
	 * 
	 */
	public static void welcome() {
		// TODO 自动生成的构造函数存根
		System.out.println("---------------------------------------------------");
		System.out.println("\t\t中国银行ATM取款机");
		System.out.println("\t欢迎使用本自助ATM系统，如有问题请拨打888888！");
		System.out.println("---------------------------------------------------");
	}
	public static void menu() {
		System.out.println("\t——主  菜  单——");
		System.out.println("\t1------查询");
		System.out.println("\t2------取款");
		System.out.println("\t3------存款");
		System.out.println("\t4------转帐");
		System.out.println("\t5------退出");
		System.out.println("请选择需要办理的业务：");
	}
	public static void tag() {
		System.out.println("感谢你使用本自助ATM系统，See you next time！");
	}

}
