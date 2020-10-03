package java_02;

import java.util.Scanner;

public class Java_22 {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		System.out.println("请输入需要多少行的菱形图形");
		Scanner	in =new Scanner(System.in);
		int x=in.nextInt();
		int n=x/2;
		
		for(int i=1;i<=n;i++)
		{	
			for(int j=1;j<=n-i;j++)	//前面的空格
			{
				System.out.print(" ");
			}
			for(int k=1;k<=2*i-1;k++)	//输出的*为2*i-1个
				{
					System.out.print("*");
				}
			System.out.println();
		}
		
		//倒序输出
		for(int i=n-1;i>=1;i--)			//下面的几行
		{
			for(int j=0;j<=n-1-i;j++)		
			{
				System.out.print(" ");
			}
			for(int k=1;k<=2*i-1;k++)		//输出的*为2*i-1个
			{
				System.out.print("*");
			}
			System.out.println();
		}
	}

}
