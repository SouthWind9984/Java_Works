package java_02;

public class Java_6 {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		gcdlcm a = new gcdlcm();
		System.out.println("兩數的最大公約數是：" + a.gcd(10, 16));
		System.out.println("兩數的最小公倍數是：" + a.lcm(16, 10));
	}
}

class gcdlcm {
	int gcd(int m, int n) {
		if (m < n) { // 這個判斷是爲了將大數放在前面
			int temp = n;
			n = m;
			m = temp;
		}
		if (m % n == 0) {
			return n;
		} else {
			m%=n;
			while(n!=0) {		//辗转相除法
			int r=m%n;
				m=n;
				n=r;}
			return m;
			// 這裡也可以寫成gcd(n,m)，就省掉了前面的判斷了，會快一點
		}
	}

	int lcm(int m, int n) {
		int i = 1;
		if (m < n) { // 這個判斷是爲了將大數放在前面
			int temp = n;
			n = m;
			m = temp;
		}
		int lcm = m;
		while (lcm % n != 0) {
			lcm = m * i;
			i++;
		}
		return lcm;
	}

}
