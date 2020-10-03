package java_02;

import java.util.Scanner;

public class Java_18 {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Scanner in = new Scanner(System.in);
		int n = 0;
		while (n < 7) {
			System.out.println("请输入1-50的一个整数值");
			int number = in.nextInt();
			if (number < 1 || number > 50)
				break;
			for (int i = 0; i < number; i++) {
				System.out.print("*");
			}

			System.out.println();
			n++;
		}
	}

}
