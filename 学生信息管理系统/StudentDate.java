package StudentInformation;


public class StudentDate {
	/*
	 * 存放学生信息
	 */
	private String stu_number;
	private String stu_name;
	private String stu_address;
	//空参构造
	public StudentDate() {
		// TODO 自动生成的构造函数存根
	}
	//代参构造
	public StudentDate(String stu_number, String stu_name, String stu_address) {
		super();
		this.stu_number = stu_number;
		this.stu_name = stu_name;
		this.stu_address = stu_address;
	}
	//Set+Get方法
	public String getStu_number() {
		return stu_number;
	}

	public void setStu_number(String stu_number) {
		this.stu_number = stu_number;
	}

	public String getStu_name() {
		return stu_name;
	}

	public void setStu_name(String stu_name) {
		this.stu_name = stu_name;
	}

	public String getStu_address() {
		return stu_address;
	}

	public void setStu_address(String stu_address) {
		this.stu_address = stu_address;
	}
	
}
