package StudentInformation;

import java.util.ArrayList;
import java.util.Scanner;

public class Delete extends CRUD{
	Scanner in = new Scanner(System.in);
	@Override
	public void delete(ArrayList<StudentDate> stu_list) {
		// TODO 自动生成的方法存根
		System.out.println("请输入你要删除学生的学号：");
		String n =in.nextLine();
		int index = -1;
		for(int i=0;i<stu_list.size();i++) {
		 StudentDate s = stu_list.get(i);
			if(s.getStu_number().equals(n))
				index = i;
		}
		if(index==-1) {
			System.out.println("------------");
			System.out.println("学号不存在！！");
			System.out.println("------------");
		}
		
		else {
			stu_list.remove(index);
			System.out.println("----------------------------");
			System.out.println("学号“"+n+"”的学生信息删除成功！");
			System.out.println("----------------------------");
		}
	}
}
