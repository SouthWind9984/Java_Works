package 图书管理;

import java.util.ArrayList;
import java.util.Scanner;

public class Add extends Book_CRUD{

	Scanner in = new Scanner(System.in);
	
	@Override
	public void add(ArrayList<BookData> book_list) {
		// TODO 自动生成的方法存根
		super.add(book_list);
		boolean flag = true;
		System.out.println("请输入编号ID:");
		int id = in.nextInt();
		for(int i=0;i<book_list.size();i++) {
			BookData b = new BookData();
			b = book_list.get(i);
			if(b.getBookID()==id)
				flag = false;
		}
		if(!flag)
		{
			System.out.println("---------------------");
			System.out.println("该图书ID已被占用，请重新确认！");
			System.out.println("---------------------");
		}
		else {
			System.out.println("请输入书名：");
			String name = in.nextLine();
			System.out.println("请输入作者：");
			String author = in.nextLine();
			System.out.println("请输入价格：");
			float price = in.nextFloat();
			System.out.println("请输入添加的数量：");
			int number = in.nextInt();
			//创建对象
			BookData d= new BookData();
			d.setBookID(id);
			d.setBookname(name);
			d.setAuthor(author);
			d.setMoney(price);
			d.setNumber(number);
			book_list.add(d);
			System.out.println("-------------");
			System.out.println("图书信息添加成功！");
			System.out.println("-------------");
			
		}
	}
	

}
