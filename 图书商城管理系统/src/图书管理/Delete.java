package 图书管理;

import java.util.ArrayList;
import java.util.Scanner;

public class Delete extends Book_CRUD{
	Scanner in = new Scanner(System.in);
	@Override
	public void delete(ArrayList<BookData> book_list) {
		// TODO 自动生成的方法存根
		super.delete(book_list);
		int index =-1;
		System.out.println("请输入你要删除的图书ID");
		int id = in.nextInt();
		for(int i=0;i<book_list.size();i++) {
			BookData b = new BookData();
			b = book_list.get(i);
			if(b.getBookID()==id)
				index = i;
		}
		if(index==-1) {
			System.out.println("---------------------");
			System.out.println("该图书ID不存在，请重新确认！");
			System.out.println("---------------------");
		}
		else {
			book_list.remove(index);
			System.out.println("----------------------");
			System.out.println("图书“"+id+"”信息删除成功！");
			System.out.println("----------------------");
		}
	}
}
