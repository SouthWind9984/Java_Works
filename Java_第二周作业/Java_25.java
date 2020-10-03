package java_02;

import java.util.Scanner;

public class Java_25 {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Scanner in = new Scanner(System.in);
		System.out.println("请输入你要哪一位数相加，相加几次（空格隔开）：");
		int number = in.nextInt();
		int n = in.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			if (i == 0) {
				arr[i] = number;
			} else {
				arr[i] = (arr[i - 1] * 10) + number;
			}
		}
		int s = 0;
		for (int t : arr) {
			System.out.print(t + "\t");
			s = s + t;
		}
		System.out.println();
		System.out.println("它们的和为：" + s);
	}
}
