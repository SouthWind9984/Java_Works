package entity;

import java.io.Serializable;
import java.util.ArrayList;

public class BookData implements Serializable{
	//成员变量
	private int bookID;
	private String bookname;
	private String author;
	private float price;
	private int number;
	//构造函数
	public BookData() {
		// TODO 自动生成的构造函数存根
	}
	
	public BookData(int bookID, String bookname, String author, float money, int number) {
		super();
		this.bookID = bookID;
		this.bookname = bookname;
		this.author = author;
		this.price = money;
		this.number = number;
	}
	//Get和Set方法
	public int getBookID() {
		return bookID;
	}
	public void setBookID(int bookID) {
		this.bookID = bookID;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public float getMoney() {
		return price;
	}
	public void setMoney(float money) {
		this.price = money;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	

}
