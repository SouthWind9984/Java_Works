package java_02;

import java.util.Scanner;

public class Java_20 {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Scanner in = new Scanner(System.in);
		for (int n = 1; n < 1000; n++) 				// 1-1000的范围
		{
			int sum = 0;
			for (int i = 2; i <= n / 2; i++) 			// 最小的质数为2
			{
				for (int j = 1; j <= i; j++) {
					if (i * j == n) { 			// 将所有的因数相加
						sum = sum + i + j;
					}
				}

			}
			if (sum + 1 == n && n != 1) { 		// 因数之和再加上1是否等于本身
				System.out.println(n);
			}
		}
	}

}
