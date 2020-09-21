package java_02;

public class Java_23 {
	public static int factorial(int n) {
		int result=0;
		if(n==1)
		{
			result=1;
		}
		else {
			result=n*factorial(n-1);
		}
		return result;
	}
	public static void main(String [] args) {
		int sum=0;
		for(int i=1;i<=10;i++) {
			sum=sum+factorial(i);
		}
		System.out.println(sum);
	}
}
