package java_work;

import java.util.Random;

public class suiijishu {

	public static int [] sort(int [] arr) {
		

			boolean swap=true;
			for(int i=0;i<arr.length;i++)
			{
				if(swap==false)
					break;
				swap =false;
				for(int j=i+1;j<arr.length;j++) {
					if(arr[i]>arr[j]) {
						arr[i]=arr[i]+arr[j];
						arr[j]=arr[i]-arr[j];
						arr[i]=arr[i]-arr[j];
						swap =true;
					}
				}
			}
	
			
			
//			boolean swap = true;          //初始为真，否则无法交换
			for (int i = 0; i < arr.length - 1; i++) {
			     if (swap == false)         //若没有发生交换，则说明后面顺序已经排好。  
			       	break;
			     swap = false;
			     for (int j = 0; j < arr.length - 1 - i; j++) {
			        if (arr[j] > arr[j + 1]) {
			          arr[j + 1] = arr[j + 1] + arr[j];       // 先加后减
			          arr[j] = arr[j + 1] - arr[j];
			          arr[j + 1] = arr[j + 1] - arr[j];
			          swap =true;            //表示发生了交换
			        }
			      }
			
			}
			
		
		
//			for(int i=0;i<arr.length-1;i++)      //冒泡排序
//		    {
//		      for(int j=0;j<arr.length-1-i;j++)
//		      {
//		        if(arr[j]>arr[j+1])
//		        {   // 如果左边的数大于右边的数，则交换，保证右边的数字最大
//		          int sw =0;         //调用第三个变量 进行交换
//		          sw =arr[j+1];
//		          arr[j+1]=arr[j];
//		          arr[j]=sw;
//		        }
//		      }
//		    }
			
		return arr;
		
	}
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		
		Random ran= new Random();
		int n=0;
		int [] arr= new int [500];
		boolean f=true;
		long time4 =System.currentTimeMillis();
		for(int i=0;i<500;i++) {
		 n = ran.nextInt(500)+1;
		 f=true;
			 for(int t:arr)
			 {
				 if(t==n) {
					 f=false;
					 break;
				 }
			 }
		if(f) {
			arr[i]=n;
		}
		else i--;
		}
		
		long time5=System.currentTimeMillis();
		long time6=time5-time4;

		
		
		int count=0;
		System.out.print("排序前：");
		for(int t: arr) {
			if(count%100==0)
			System.out.println();
			System.out.print(t+"\t");
			count++;
			}
		count=0;
		long time1 =System.currentTimeMillis();
		sort(arr);
		System.out.println();
		System.out.print("排序后：");
		for(int t: arr) {
			if(count%100==0)
				System.out.println();
			System.out.print(t+"\t");
			count++;}
		System.out.println();
		long time2=System.currentTimeMillis();
		long time3=time2-time1;
		System.out.println("生成随机数用时"+time6+"毫秒");
		System.out.println("排序用时"+time3+"毫秒");
		System.out.println("总用时"+(time3+time6)+"毫秒");
	}

}
