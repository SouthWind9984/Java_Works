package 图书管理;

import java.util.ArrayList;

public class Read extends Book_CRUD{
	
	@Override
	public void read(ArrayList<BookData> book_list) {
		// TODO 自动生成的方法存根
		super.read(book_list);
		System.out.println("-----------------------------------------------------------");
		System.out.println("ID\t书名\t\t作者\t\t价格\t\t数量 ");
		for (int i = 0; i < book_list.size(); i++) {
			BookData b = new BookData();
			b = book_list.get(i);
			System.out.println(b.getBookID()+"\t"
					+b.getBookname()+"\t\t"
					+b.getAuthor()+"\t\t"
					+b.getMoney()+"\t\t"
					+b.getNumber());
		}
		System.out.println("-----------------------------------------------------------");
	}
}
