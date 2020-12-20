package 图书管理;

import java.util.ArrayList;
import java.util.Scanner;

public class Updata extends Book_CRUD{
	
	Scanner in = new Scanner(System.in);
	@Override
	public void updata(ArrayList<BookData> book_list) {
		// TODO 自动生成的方法存根
		super.updata(book_list);
		int index = -1; //标记
		System.out.println("请输入你要更改图书的ID:");
		int id = in.nextInt();
		for(int i=0;i<book_list.size();i++) {
			BookData b = new BookData();
			b = book_list.get(i);
			if(b.getBookID()==id)
				index = i;
		}
		if(index==-1)
		{
			System.out.println("---------------------");
			System.out.println("该图书ID不存在，请重新确认！");
			System.out.println("---------------------");
		}
		else {
			BookData d = book_list.get(index);//获取取书本信息
			System.out.println("-----------------------------------------------------------");
			System.out.println("ID\t书名\t\t作者\t\t价格\t\t数量 ");
			System.out.println(d.getBookID()+"\t"
					+d.getBookname()+"\t\t"
					+d.getAuthor()+"\t\t"
					+d.getMoney()+"￥\t\t"
					+d.getNumber());
			System.out.println("-----------------------------------------------------------");
			//存取书本信息
			String name = d.getBookname();
			String author = d.getAuthor();
			float price = d.getMoney();
			int number = d.getNumber();
			//更新书本信息
			System.out.println("1----书名");
			System.out.println("2----作者");
			System.out.println("3----价格");
			System.out.println("4----数量");
			System.out.println("5----全部");
			System.out.println("请选择你要修改的信息：");
			int m=in.nextInt();
			String s= in.nextLine();//Bug1：获取键盘的回车
			switch (m) {
			case 1:
				System.out.println("请输入将"+name+"修改为：");
				d.setBookname(in.next());
				break;
			case 2:
				System.out.println("请输入将"+author+"修改为：");
				d.setAuthor(in.next());
				break;
			case 3:
				System.out.println("请输入将"+price+"修改为：");
				d.setMoney(in.nextFloat());
				break;
			case 4:
				System.out.println("请输入将"+number+"修改为：");
				d.setNumber(in.nextInt());
				break;
			case 5:
				System.out.println("请输入将"+name+"修改为：");
				d.setBookname(in.next());
				System.out.println("请输入将"+author+"修改为：");
				d.setAuthor(in.next());
				System.out.println("请输入将"+price+"修改为：");
				d.setMoney(in.nextFloat());
				System.out.println("请输入将"+number+"修改为：");
				d.setNumber(in.nextInt());
				break;
			}
			//保存书本信息
			/*System.out.println("-----------------------------------------------------------");
			System.out.println(d.getBookID()+"\t"
					+d.getBookname()+"\t\t"
					+d.getAuthor()+"\t\t"
					+d.getMoney()+"\t\t"
					+d.getNumber());
			System.out.println("-----------------------------------------------------------");
			*/
			book_list.set(index, d);
			System.out.println("---------");
			System.out.println("修改成功！");
			System.out.println("---------");
		}
	}

}
