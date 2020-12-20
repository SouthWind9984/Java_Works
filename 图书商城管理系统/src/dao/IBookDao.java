package dao;
/**
 * 
 * 	 图书的增删查找CRUD
 * @author SouthWind
 *
 */

import java.util.ArrayList;

import entity.BookData;

public interface IBookDao {
	
	 
	public boolean creatBook(BookData book); //增加书籍
	
	public BookData findBook(int id); //查找书籍
	
	public ArrayList<BookData> readBook(); //获取所有书籍
	
	public BookData updataBook(BookData book); //更新书本
	
	public boolean dleteBook(int id); //删除书籍
	
	
	
	
}
