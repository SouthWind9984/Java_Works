package atm01;

public class Atm extends User{

	/*
	 * 	存放ATM及客户信息
	 */
	public Atm() {
		super();
		// TODO 自动生成的构造函数存根
	}

	private int atmMoney=100000;
	
	public int getAtmMoney() {
		return atmMoney;
	}

	public void setAtmMoney(int atmMoney) {
		this.atmMoney = atmMoney;
	}
	
}
