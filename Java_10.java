package java_02;

import java.util.Scanner;

public class Java_10 {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Scanner in =new Scanner(System.in);
		System.out.println("请输入10个整数（空格隔开）：");
		
		int [] arr = new int [10];
		for (int i=0;i<arr.length;i++)
		{
			arr[i]=in.nextInt();
		}

		int max=0;
		int min=0;
		for(int i=0;i<arr.length;i++)
		{
			if(arr[max]<arr[i]) {		//找到最大的位置
				max=i;
			}
			if(arr[min]>arr[i])			//找最小的位置
			{	
				min=i;
			}
		}
		int tmp = arr[0];
		arr[0]=arr[max];
		arr[max]=tmp;
		
		/*
		 * arr[max]=arr[0]+arr[max]; //最大的换到首位 arr[0]=arr[max]-arr[0];
		 * arr[max]=arr[max]-arr[0];
		 */
		tmp = arr[9];
		arr[9]=arr[min];
		arr[min]=tmp;
		
		
		/*
		 * arr[9]=arr[9]-arr[min]; //最小的换到最后 arr[min]=arr[9]+arr[min];
		 * arr[9]=arr[min]-arr[9];
		 */

		for(int t:arr)
			System.out.print(t+"  ");
	}

}
