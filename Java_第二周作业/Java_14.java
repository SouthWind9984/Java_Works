package java_02;

import java.util.Arrays;
import java.util.Scanner;

public class Java_14 {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Scanner in =new Scanner(System.in);
		int arr [] =new int [10];
		System.out.println("请输入十个整数（空格隔开）：");
		for(int i=0;i<arr.length;i++)
		{
			arr[i]=in.nextInt();
		}
		Arrays.sort(arr);  //调用函数排序
		System.out.print("从小到大依次为：");
		for(int t: arr)
			System.out.print(t+"\t");
		System.out.println();
		boolean swapp =true;
	    int Last = arr.length-1;    //记录上次发生交换的位置
	    int  swappedIndex = -1;    //记录交换的位置
	    while(swapp)
	    {
	      swapp = false;
	      for (int i=0; i<Last; i++)    //走到上次最后一个没有交换的元素位置
	      {
	        if (arr[i]< arr[i+1])		
	        {
	          int temp =arr[i];
	          arr[i]= arr[i+1];
	          arr[i+1] =temp;
	          // 表示发生了交换
	          swapp = true;
	          swappedIndex =i;
	            // 更新交换的位置
	        }
	      }
	      Last = swappedIndex;
	}	
	    System.out.print("从大到小依次为：");
	    for(int t: arr)
	    	System.out.print(t+"\t");
}
}
