package java_02;

import java.util.Random;
import java.util.Scanner;

public class Java_8 {
	public static String f(int m) {
		String F="";
		switch (m)
		{
		case 1:
			F="石头";
			break;
		case 2:
			F="剪刀";
			break;
		case 3:
			F="布";
			break;
		}
		
		return F;
	}
	public static void main(String asgs[]){
		Random rnd = new Random();
		Scanner in = new Scanner(System.in);
		int n =rnd.nextInt(3)+1;
		System.out.println("请输入你的猜拳1石头2剪刀3布");
		int m =in.nextInt();
		switch (n)
		{
		case 1:
			switch (m) {
			case 1:System.out.println("你出的"+f(m)+"与电脑出的"+f(n)+"打成平手");break;
			case 2:System.out.println("你出的"+f(m)+"输给电脑出的"+f(n));break;
			case 3:System.out.println("你出的"+f(m)+"战胜电脑出的"+f(n));break;
			}break;
		case 2:
			switch (m) {
			case 2:System.out.println("你出的"+f(m)+"与电脑出的"+f(n)+"打成平手");break;
			case 3:System.out.println("你出的"+f(m)+"输给电脑出的"+f(n));break;
			case 1:System.out.println("你出的"+f(m)+"战胜电脑出的"+f(n));break;
			}break;
		case 3:
			switch (m) {
			case 3:System.out.println("你出的"+f(m)+"与电脑出的"+f(n)+"打成平手");break;
			case 1:System.out.println("你出的"+f(m)+"输给电脑出的"+f(n));break;
			case 2:System.out.println("你出的"+f(m)+"战胜电脑出的"+f(n));break;
			}break;
		}
	}
}
