package severice;

import java.util.ArrayList;

import dao.BookDao;
import entity.BookData;

public class BookSever implements IBookSever{

	private BookDao bookdao = new BookDao();
	
	@Override
	public boolean creatBook(BookData book) {
		// TODO 自动生成的方法存根
		return bookdao.creatBook(book);
	}

	@Override
	public BookData findBook(int id) {
		// TODO 自动生成的方法存根
		return bookdao.findBook(id);
	}

	@Override
	public ArrayList<BookData> readBook() {
		// TODO 自动生成的方法存根
		return bookdao.readBook();
	}
	
	@Override
	public BookData updataBook(BookData book) {
		// TODO 自动生成的方法存根
		return bookdao.updataBook(book);
	}
	

	@Override
	public boolean dleteBook(int id) {
		// TODO 自动生成的方法存根
		return bookdao.dleteBook(id);
	}

	
}
