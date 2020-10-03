package java_02;

import java.util.Scanner;

public class Java_13 {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Scanner in = new Scanner(System.in);
		System.out.println("请输入一个不多于5位的正整数");
		int number = in.nextInt();
		int count = 0;
		int n = number;
		while (n > 0) {
			n /= 10;
			count++;
		}
		System.out.println("这是一个" + count + "位数");
		int arr[] = new int[count];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = number % 10;
			number /= 10;
		}
		System.out.print("逆序：");
		for (int t : arr) {
			System.out.print(t);
		}
	}
}
