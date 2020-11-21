package StudentInformation;

import java.util.ArrayList;
import java.util.Scanner;

public class Read extends CRUD {
	Scanner in = new Scanner(System.in);
	@Override
	public void read(ArrayList<StudentDate> stu_list) {
		// TODO 自动生成的方法存根
		System.out.println("--------------------------------------------------");
		System.out.println("学号\t\t姓名\t地址");
		for (int i = 0; i < stu_list.size(); i++) {
			StudentDate s = stu_list.get(i);
			System.out.println(stu_list.get(i).getStu_number() + "\t" + stu_list.get(i).getStu_name() + "\t"
					+ stu_list.get(i).getStu_address() + "\t");	
		}
		System.out.println("--------------------------------------------------");
	/*	System.out.println("请输入你要查找的学号");
		String n = in.nextLine();
		int index = -1;
		for (int i = 0; i < stu_list.size(); i++) {
			StudentDate s = stu_list.get(i);
			if (s.getStu_number().equals(n))
				index = i;
		}
		if (index == -1)
			System.out.println("学号不存在");
		else
			System.out.println(stu_list.get(index).getStu_number() + "\t" + stu_list.get(index).getStu_name() + "\t"
					+ stu_list.get(index).getStu_address() + "\t");
	*/
	}
}
