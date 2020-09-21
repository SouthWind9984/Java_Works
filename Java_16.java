package java_02;

import java.util.Scanner;

public class Java_16 {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Scanner in = new Scanner(System.in);
		System.out.println("一共要多少个数");
		int n =in.nextInt();
		int [] arr = new int [n];
		System.out.println("请输入各数的值（空格隔开）：");
		for(int i=0;i<arr.length;i++) {
			arr[i]=in.nextInt();
		}
		System.out.println("移动前：");
		for(int t: arr)
		{
			System.out.print(t+" ");
		}
		System.out.println();
		System.out.println("请输入你要移动几个位置：");
//		int heand=in.nextInt(); //3
		int move=in.nextInt();	//3
		 for(int i=1;i<=move;i++){
	            int temp=arr[arr.length-1];
	            for(int j=arr.length-1;j>0;j--){
	                arr[j]=arr[j-1];
	            }
	            arr[0]=temp;
	        }
		 System.out.println("移动后：");
		 for(int t: arr)
		 System.out.print(t+" ");
	}

}
