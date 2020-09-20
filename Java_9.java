package java_02;

import java.util.Scanner;

public class Java_9 {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Scanner in = new Scanner(System.in);
		System.out.println("请输入一个五位正整数");
		int number = in.nextInt();
		int [] arr = new int [5];
		 int count=0;
		int  n=number;
		while(number > 0)
		{
			arr[count]=number%10;
			number/=10;
			count ++;
		}
		if(arr[0]==arr[4] && arr[1]==arr[3])
		{
			System.out.println(n+"是回文数");
		}
		else {
			System.out.println(n+"不是回文数");
		}
	}

}
