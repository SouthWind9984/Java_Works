package StudentInformation;

import java.util.ArrayList;
import java.util.Scanner;

public class Create extends CRUD{
	Scanner in = new Scanner(System.in);
	@Override
	public void create(ArrayList<StudentDate> stu_list) {
		
		boolean flag = true;
		System.out.println("输入学号：");
		String number = in.nextLine();
		for(int i=0;i<stu_list.size();i++) {
			StudentDate s = new StudentDate();
			s=stu_list.get(i);
			if(s.getStu_number().equals(number))
				flag =false;
		}
		if(!flag) {
			System.out.println("---------------------");
			System.out.println("该学号已被占用，请重新确认！");
			System.out.println("---------------------");
		}
		else {
		System.out.println("输入名字：");
		String name = in.nextLine();
		System.out.println("输入地址：");
		String address = in.nextLine();
		
		StudentDate stu = new StudentDate();
		stu.setStu_number(number);
		stu.setStu_name(name);
		stu.setStu_address(address);
		stu_list.add(stu);
		System.out.println("-------------");
		System.out.println("学生信息添加成功！");
		System.out.println("-------------");
		}
	}
}
