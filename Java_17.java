package java_02;

public class Java_17 {

	public static double f1(int n) {
		double r=0;
		if(n>2) {
			r=f1(n-1)+f1(n-2);
		}
		else {
			if(n==1)
				r=2;
			else r=3;
		}
		return r;
	}
	public static double f2(int m){
		double r=0;
		if(m>1)
		 {
			r=f2(m-1)+f2(m-2);
		}
		else r=1;
		
		return r;
	}
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		double s=0;
		for(int i=1;i<=20;i++)
		{
			s=s+f1(i)/f2(i);
		}
		System.out.println(s);
	}

}
