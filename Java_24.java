package java_02;

public class Java_24 {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int n=0;
		int count=0;
		for(int i=1;i<=4;i++)
		{
			for(int j=1;j<=4;j++)
			{
				for(int k=1;k<=4;k++)
				{
					for(int p=1;p<=4;p++)
					{
						if(i!=j && i!=k && i!=p && j!=k && j!=p && k!=p) {
							n=i*1000+j*100+k*10+p;
							count++;
							System.out.println(count+":"+n);
						}
					}
				}
			}
		}
		System.out.println("一共有"+count+"个");
	}
}
