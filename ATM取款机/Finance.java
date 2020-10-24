package atm01;

import java.util.Scanner;

public class Finance extends Atm{
	/*
	 * 	完成在ATM机上相应的操作！
	 * 
	 */
	Scanner in = new Scanner(System.in);
	public Finance() {
		super();
		// TODO 自动生成的构造函数存根
	}

	//查询余额
	public void inquireMoney() {
		System.out.println("***************");
		System.out.println("卡内余额："+getCardMoney()+"元");
		System.out.println("机内金额："+getAtmMoney()+"元");
		System.out.println("***************");
	}
	
	//取钱
	public void drawMoney() {
//		System.out.println("***************");
//		System.out.println("ATM机中现有"+getAtmMoney()+"元");
//		System.out.println("***************");
		int n =0;
		while(true) {
			System.out.println("请输入取款金额（100的整倍数）：");
			n=in.nextInt();
		if(n<100&&n%100!=0)
			System.out.println("擦亮你的眼，重新输入");
		else
			break;
		}
		if(n>getAtmMoney()&&n<getCardMoney()) {
			System.out.println("对不起，机内余额不足");
		}
		else if(n>getCardMoney())
			System.out.println("对不起，卡内余额不足");
		else {
			setCardMoney(getCardMoney()-n);
			setAtmMoney(getAtmMoney()-n);
			System.out.println("***************");
			System.out.println("恭喜你！操作成功~！");
		}
	}
	
	//存钱
	public void saveMoney() {
		int n =0;
		while(true) {
			System.out.println("请输入存款金额（100的整倍数）：");
			n=in.nextInt();
			if(n<100&&n%100!=0)
				System.out.println("擦亮你的眼，重新输入");
			else 
				break;
		}
		setCardMoney(getCardMoney()+n);
		setAtmMoney(getAtmMoney()+n);
		System.out.println("***************");
		System.out.println("恭喜你！操作成功~！");
	}
	//转账
	public void transferMoney() {
		int n = 0;
		String s,a;
		while(true) {
			System.out.println("请输入你要转账的卡号");
			s=in.next();
			System.out.println("请再次确认你要转账的卡号");
			a=in.next();
			if(s.equals(a))
				{
				if(s.length()>=8)
					break;
				else
					System.out.println("账号最少8位，请重新输入！");
				}
			else
				System.out.println("两次卡号不一样，请重新输入!");
		}
		System.out.println("请输入转账金额：");
		n=in.nextInt();
		setCardMoney(getCardMoney()-n);
		System.out.println("***************");
		System.out.println("恭喜你！转账成功~");
	}
	
}
