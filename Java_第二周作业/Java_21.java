package java_02;

import java.util.Scanner;

public class Java_21 {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Scanner in = new Scanner(System.in);
		System.out.println("请输入你本月的利润（单位/万元）：");
		int money = in.nextInt(); // 利润
		double bonus = 0;
		if (money <= 10) {
			bonus = money * 0.1;
		} else if (money > 10 && money <= 20) {
			bonus = (money - 10) * 0.075 + 10 * 0.01;
		} else if (money > 20 && money <= 40) {
			bonus = (money - 20) * 0.05 + 10 * 0.075 + 10 * 0.01;
		} else if (money > 40 && money <= 60) {
			bonus = (money - 40) * 0.03 + 20 * 0.05 + 10 * 0.075 + 10 * 0.01;
		} else if (money > 60 && money <= 100) {
			bonus = (money - 60) * 0.015 + 20 * 0.03 + 20 * 0.05 + 10 * 0.075 + 10 * 0.01;
		} else
			bonus = (money - 100) * 0.01 + 40 * 0.015 + 20 * 0.03 + 20 * 0.05 + 10 * 0.075 + 10 * 0.01;
		System.out.printf("这月的奖金为%.2f万元", bonus);
	}

}
