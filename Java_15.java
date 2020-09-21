package java_02;

import java.util.Scanner;

public class Java_15 {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Scanner in = new Scanner(System.in);
		System.out.println("请输入一共有几个人：");
		int n = in.nextInt();
		System.out.println("请输入报到几的人出去");
		int x = in.nextInt();
		int arr[] = new int[n];
		int k = 0, m = 0;		//k 出去几个人， m 判断报的数是否为x 的倍数
		while (k < n - 1) {
			for (int i = 0; i < arr.length; i++) {
				m++;		//先计数，后判断
				if (arr[i] == 1) {
					m--;		//出去的人减去
					continue;
				}
				if (m % x == 0 && m != 0) {	
					arr[i] = 1;
					k++;
				}

			}

		}

		for (int j = 0; j < arr.length; j++) {
			if (arr[j] == 0) {
				System.out.println("留到最后的是" + (j + 1) + "号");
			}
		}
	}

}
