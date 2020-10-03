package java_02;

public class Java_1 {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int i,j,n,m,x;      //n是用来存储余数的；m是用来统计具体一个数的因子；

		n=0;m=0;x=0;        //x是用来统计101~200之前素数的个数

		for(i=101;i<=200;i++){             //两重循环

		   	for(j=1;j<=i;j++){

		n=i%j;                    //去余数，如果余数为零，就是该数的因子

		if(n==0)  { m=m+1; }      //统计某数有多少个因子

		}

		if (m == 2) {			
			System.out.print(i + " ");
			x = x + 1;
		} 						// 如果某数的因子只有两个，那它就一定是素数，那这个数就应该输出

		m=0; 					// 一定要清零，不然会继续累加

	}

		System.out.println();

		System.out.println("在101~200之間一共有素數："+x+"個");
	}

}
