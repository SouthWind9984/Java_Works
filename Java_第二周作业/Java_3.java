package java_02;

public class Java_3 {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		//i是表示月份的，这里计算了36个月，也就是三年，兔子的数量

		int i;

		int [] arr =new int [36];   //这个数组时用来计算每月有兔子的对数

		arr[0]=arr[1]=1;

		System.out.println("第1个月有兔子1对"+", "+"总数是"+2);

		System.out.println("第2个月有兔子1对"+", "+"总数是"+2);

		for(i=2;i<=35;i++){

		arr[i]=arr[i-1]+arr[i-2];

		System.out.println("第"+(i+1)+"个月有兔子"+arr[i]+"对"+", "+"总数是"+2*arr[i]);

		//规律是 每个数字都是前面两个数字之和

		}
	}

}
