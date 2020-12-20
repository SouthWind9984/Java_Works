package 用户管理;

import java.io.Serializable;

public class UserData implements Serializable{
	
	//成员变量
	private String name;
	private String passwd;
	private String address;
	private float money;
	
	//构造函数
	public UserData() {
		// TODO 自动生成的构造函数存根
	}
	public UserData(String name, String passwd, String address,float money) {
		super();
		this.name = name;
		this.passwd = passwd;
		this.address = address;
		this.money = money;
	}
	
	//Get Set
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public float getMoney() {
		return money;
	}
	public void setMoney(float money) {
		this.money = money;
	}
	
	

}
