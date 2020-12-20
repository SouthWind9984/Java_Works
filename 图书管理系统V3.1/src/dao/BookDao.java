package dao;

import java.util.ArrayList;

import entity.BookData;

public class BookDao implements IBookDao{

	static ArrayList<BookData> bookList = new ArrayList<BookData>();
	
	private DataSaveFile datasave = new DataSaveFile();
	//数据写入
//	BookData b1 = new BookData(101, "Java", "小小怪", 88.8f, 10);
//	BookData b2 = new BookData(102, "Asp.Net", "开心超人", 99.9f, 50);
//	BookData b3 = new BookData(103, "Web开发", "大大怪", 66.6f, 15);
//	BookData b4 = new BookData(104, "SQL", "花心超人", 45.0f, 20);
//	BookData b5 = new BookData(105, "数据结构", "粗心博士", 85.0f, 10);
	public void inputBook() {
		bookList=datasave.readBook();
		
//		bookList.add(b1);bookList.add(b2);bookList.add(b3);bookList.add(b4);bookList.add(b5);
		
	}
	//数据读出
	public void outputBook() {
		datasave.writeBook(bookList);
	}
	
	@Override
	public boolean creatBook(BookData book) {
		// TODO 自动生成的方法存根
		if(findBook(book.getBookID())==null) {
			bookList.add(book);
			return true; //添加成功返回真
		}
		return false;
	}

	@Override
	public BookData findBook(int id) {
		// TODO 自动生成的方法存根
		for (BookData bookData : bookList) {
			if(bookData.getBookID()==id) {
				System.out.println(bookData.getBookname());
				return bookData;
			}
		}
		return null; //找不到返回空
	}

	@Override
	public ArrayList<BookData> readBook() {
		// TODO 自动生成的方法存根
		return BookDao.bookList;
	}

	@Override
	public BookData updataBook(BookData book) {
		// TODO 自动生成的方法存根
		for(int i=0;i<bookList.size();i++) {
			BookData book1 = bookList.get(i);
			if(book1.getBookID()==book.getBookID()) {
				bookList.set(i, book);
				return book;
			}
	}
		return null;
	}

	@Override
	public boolean dleteBook(int id) {
		// TODO 自动生成的方法存根
		for(int i=0;i<bookList.size();i++) {
			BookData book = bookList.get(i);
			if(book.getBookID()==id) {
				bookList.remove(i);
				System.out.println("删除成功！");
				return true;
			}
		}
		return false;
	}

}
