package atm01;


public class User {
	/*
	 * 	存放和获取用户的信息
	 * 	
	 */
	
	private String name="小飞机";					//姓名
	private String cardNumber="123456789";		//卡号
	private String passWord="66668888";		//密码
	private float cardMoney=10000;		//卡内余额

	public String getCardNumber() {
		return cardNumber;
	}

	public String getPassWord() {
		return passWord;
	}

	public float getCardMoney() {
		return cardMoney;
	}
	
	public String getName() {
		return name;
	}

	public void setCardMoney(float cardMoney) {
		this.cardMoney = cardMoney;
	}
}
