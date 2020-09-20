package java_02;

public class Java_5 {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int a,sum;     //表示100~999

		int i,j,k;//分别表示百位、十位、各位

		for(a=100;a<=999;a++){

		i=a/100;

		j=(a%100)/10;
//		j=(a/10)%10;

		k=a%10;

		sum=i*i*i+j*j*j+k*k*k;

		//java的运算符，立方要这样写，写成i^3这样，竟然运算不出来

		//如果遇到高次的话可以使用循环算出来

		if(sum==a)

		{ System.out.println(sum);
	}

}
}
}
