package StudentInformation;

import java.util.ArrayList;
import java.util.Scanner;

public class Update extends CRUD{
	Scanner in = new Scanner(System.in);
	@Override
	public void update(ArrayList<StudentDate> stu_list) {
		// TODO 自动生成的方法存根
		System.out.println("请输入要更新学生信息的学号：");
		String n =in.nextLine();
		int index = -1;
		for(int i=0;i<stu_list.size();i++) {
		 StudentDate s = stu_list.get(i);
			if(s.getStu_number().equals(n))
				index = i;
		}
		if(index==-1) {
			System.out.println("-------------");
			System.out.println("学号不存在！！");
			System.out.println("-------------");
			}
		else
		{
			System.out.println("输入名字：");
			String name = in.nextLine();
			System.out.println("输入地址：");
			String address = in.nextLine();
			StudentDate stu = new StudentDate();
			stu.setStu_number(n);
			stu.setStu_name(name);
			stu.setStu_address(address);
			stu_list.set(index, stu);
			System.out.println("--------------------------");
			System.out.println("学号“"+n+"”的学生信息修改成功！");
			System.out.println("--------------------------");
		}
	}
}
