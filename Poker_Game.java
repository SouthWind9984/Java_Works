package java_03;

import java.util.Random;
import java.util.Scanner;

public class Game {
	/**
	 * 设计一个扑克牌游戏，52张扑克牌，
	 * 让计算机随机抽取 一张，用户输入一个数，
	 * 即要抽取的第几张牌
	（因为计算机先抽，所以用户一定不能抽计算机抽过牌），
	然后比较计算机和用户抽取 的牌的大小（数值2、3、4、5、6、7、8、9、10、11、12、13、A 相同，比较花色，黑红梅方），
	输出结果（输出牌面值 黑桃A、黑桃J、黑桃Q、黑桃K）。
	 * 
	 * 
	 * 思路：
	 * 数组存放的53张牌是随机的还是有序的？？
	 * 
	 * 随机的更有效
	 * 
	 * 创建一个数组存放53张扑克牌
	 * 电脑随机抽取一个数，用户无法抽到这张牌
	 * @return
	 */
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Scanner in = new Scanner(System.in);
		System.out.println("\t\t欢迎来到扑克牌大战");
		System.out.println("游戏规则：A最大，依次2-10,J,Q,K.若数值相同比较花色，依次是黑红梅方，\n\t\t~~回车开始游戏");
		String s = in.nextLine();
		//获取电脑抽到的牌面
		int c_size =computer();
//		System.out.println("电脑抽到的是"+mark(c_size));
		System.out.println("--------------------");
		System.out.println("我已经抽取一张牌，轮到你了");
		System.out.println("--------------------");
		System.out.println();
		//获取用户抽到的牌面
		int u_size = User();
		//判断
		if(c_size>u_size) {
			System.out.print("**********************\n");
			System.out.println("            哈哈哈~ 你好菜");
			System.out.println("我的“"+mark(c_size)+"”战胜“你的"+mark(u_size)+"”");
			System.out.print("**********************\n");
		}
		else if(c_size<u_size){
			System.out.print("**************************\n");
			System.out.println("  啊~ 碰见高手了");
			System.out.println("你的“"+mark(u_size)+"”战胜我的“"+mark(c_size)+"”");
			System.out.print("**************************\n");
		}
		else {
			System.out.print("**************************\n");
			System.out.println("  少年，算你运气好");
			System.out.println("你的“"+mark(u_size)+"”与我的“"+mark(c_size)+"”打成平手");
			System.out.print("**************************\n");
		}
	}
	
	//创建一个数组存放52张扑克牌
	public static int[] playCardArr() {
		/*
		 * 
		 *花色： 黑桃----4 红心----3 梅花----2 方片----1
		 * 
		 * 数值为：1-13 令13为A
		 * 
		 * 将随机数数组 读入到该数组
		 * 打乱存储顺序，做到随机
		 */
		int[] numberArr = randomArr();
		int arr[] = new int [52];
		int k=0;
		for(int i=1;i<=4;i++) 
		{
			for(int j=1;j<=13;j++)	
			{
				arr[numberArr[k]]=j*10+i;       //十位为数值，个位为花色
				k++;
			}
		}
//		System.out.println(k);
		return arr;   //得到一个随机存放扑克牌的数组
	}
	
	
	//随机数数组0-51
	public static int[] randomArr() {
		Random ran =new Random();
		int numberArr[] = new int [52];
		int number =0;
		for(int i=1;i<numberArr.length;i++) {
			boolean f =true;
				number= ran.nextInt(52);
				for(int t:numberArr)
				{
					if(t==number) {
						f=false;
						break;
					}
				}
			if(f)
			{
				numberArr[i]=number;
			}
			else 
				i--;
		}
		return numberArr;
	}
	
	//电脑从52张随机抽取一张
	public static int computer() {
		Random ran = new Random();
		int c_numbere=ran.nextInt(52);
		int arr [] =new int [52];
		arr = playCardArr();
		int c_size = arr[c_numbere];
		return c_size;  //获取电脑牌色大小
	}
	
	//用户在剩下的51张抽取
	public static int User() {

		Scanner  in = new Scanner(System.in);
		//创建一个51张牌的数组，去掉电脑抽到的那张
		int array[] = new int [51];
		int arr [] = new int [52];
		arr = playCardArr();
		int c_size = computer(); //电脑牌面
		int n1=0,n2=0;
		for(int t:arr) {
			if(t!=c_size) {
				array[n1]=arr[n2];
				n1++;
				n2++;
			}
			else n2++;
		}
		System.out.println("请确认你要抽第几张牌(还剩51张牌)：");
		int n =in.nextInt();
		int u_size = array[n-1];
		return u_size;
	}
	
	//输出牌面
	public static String mark(int n) {
		int color = n%10;
		String huase="";
		switch (color) {
		case 1:huase = "方片";break;
		case 2:huase = "梅花";break;
		case 3:huase = "红桃";break;
		case 4:huase = "黑桃";break;
		}
		int number = n/10;
		String vale="";
		switch(number) {
		case 1:vale="2";break;
		case 2:vale="3";break;
		case 3:vale="4";break;
		case 4:vale="5";break;
		case 5:vale="6";break;
		case 6:vale="7";break;
		case 7:vale="8";break;
		case 8:vale="9";break;
		case 9:vale="10";break;
		case 10:vale="J";break;
		case 11:vale="Q";break;
		case 12:vale="K";break;
		case 13:vale="A";break;
		}
		String mark=huase+vale;
		return mark;
	}
	
}
