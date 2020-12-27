package entity;

import java.io.Serializable;

public class User implements Serializable{

	private String name;
	private String pwd;

	
	public User() {
		super();
	}
	
	public User(String name, String pwd) {
		super();
		this.name = name;
		this.pwd = pwd;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}


	
	
	
	
}
