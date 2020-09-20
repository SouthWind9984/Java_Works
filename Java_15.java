package java_02;

import java.util.Scanner;

public class Java_15 {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Scanner in = new Scanner(System.in);
		int n=7;
		int arr[] =new int [n];
		int k=0,i=1;
		while(k<n)
		{	
			i++;
			if(i%3==0) {
				arr[i]=1;
			k++;
			}
		}
		for(int j=0;j<arr.length;j++)
		{
			if(arr[j]==0) {
				System.out.println(j);
			}
		}
	}

}
