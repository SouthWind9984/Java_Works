package java_02;

import java.util.Scanner;

public class Java_19 {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int [] arr = {100,54,41,22,11};
		int f=0;
		if(arr[0]<arr[1]) f=1;		//f=1 为升序   -1降序
		else f=-1;
		
		Scanner in = new Scanner(System.in);
		int number =in.nextInt();
		if(f==1) {				//升序
		int count=0;
		for(int t:arr)
		{	
			if(t>number) {
				break;			//找到第一个大于number的count值，跳出
			}
			count++;
		}
//		System.out.println(count);
		int arra [] =new int [arr.length+1];
		for(int i=0;i<arra.length;i++)		//创建一个加一新的数组 遍历旧数组
		{
			if(i==count) {
				arra[count]=number;		//用number 代替找到count的位置替代
			}
			else if(i>count) {
				arra[i]=arr[i-1];		//大于count 让i-1
			}
			else
				arra[i]=arr[i];
		}
		
		for(int t: arra) {
			System.out.print(t+"\t");
		}
		}
		
		if(f==-1) {			//降序
			int count=0;
			for(int t:arr)
			{	
				if(t<number) {
					break;
				}
				count++;
			}
//			System.out.println(count);
			int arra [] =new int [arr.length+1];
			for(int i=0;i<arra.length;i++)		//创建一个加一新的数组 遍历旧数组
			{
				if(i==count) {
					arra[count]=number;			//用number 代替找到count的位置替代
				}
				else if(i>count) {
					arra[i]=arr[i-1];		//大于count 让i-1
				}
				else
					arra[i]=arr[i];
			}
			
			for(int t: arra) {
				System.out.print(t+"\t");
			}
		}
	}

}
