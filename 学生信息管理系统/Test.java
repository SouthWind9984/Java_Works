package StudentInformation;

import java.util.ArrayList;
import java.util.Scanner;

public class Test {

	//创建以学生为对象的单列集合，存储学生信息！
	static ArrayList<StudentDate> stu_list = new ArrayList<>();
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		
		//先往学生数据列表加入数据
		StudentDate e1 = new StudentDate("20191818112","牛雨龙","河南科技学院6#205");
		StudentDate e2 = new StudentDate("20191818115","王池","河科院Restroom");
		StudentDate e3 = new StudentDate("20201120001","杰徳","贫民窟");
		StudentDate e4 = new StudentDate("20201120002","拉辛","旧城区");
		stu_list.add(e1);stu_list.add(e2);stu_list.add(e3);stu_list.add(e4);
		
		//增删改查
		Create create = new Create();
		Read read = new Read();
		Update update = new Update();
		Delete delete = new Delete();
		Scanner in = new Scanner(System.in);
		Show.wellcome();
		System.out.println("按任意键进入");
		String s = in.nextLine();
		Go:
			while(true) {
				Show.showMenu();
				System.out.println("请选择你的操作：");
				int n = in.nextInt();
				switch (n) {
				case 1:
					factory(create);break;
				case 2:
					factory(read);break;
				case 3:
					factory(update);break;
				case 4:
					factory(delete);break;
				case 5:
					break Go;
				}
				while(true) {
					System.out.println("按“0”返回主菜单");
					s=in.next();
					if(s.equals("0"))
						break;
				}
			}
		Show.tag();
	}
	public static void factory(CRUD crud) {	//多态工厂
		crud.create(stu_list);
		crud.read(stu_list);
		crud.update(stu_list);
		crud.delete(stu_list);
	}
}
