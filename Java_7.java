package java_02;

import java.util.Scanner;

public class Java_7 {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Scanner	in = new Scanner(System.in);
		int number = in.nextInt();
		int [] arr = new int [4];
		int count=3;
		while(number>0)
		{
			arr[count]=number%10;
			count--;
			number/=10;
		}
		for(int i = 0; i<arr.length;i++)
		{
			arr[i]=(arr[i]+5)%10;
		}
		int tmp =0;
		tmp=arr[0];
		arr[0]=arr[3];
		arr[3]=tmp;
		tmp=arr[1];
		arr[1]=arr[2];
		arr[2]=tmp;
		for(int t: arr)
			System.out.print(t);
	}

}
