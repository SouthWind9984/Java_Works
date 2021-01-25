package main;

public class Answer {

	private String option = "";
	private String optionID = "";
	private String Title = "";

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public Answer() {
		// TODO 自动生成的构造函数存根
	}

	public Answer(String option, String optionID, String title) {
		super();
		this.option = option;
		this.optionID = optionID;
		Title = title;
	}

	public String getOption() {
		return option;
	}

	public void setOption(String option) {
		this.option = option;
	}

	public String getOptionID() {
		return optionID;
	}

	public void setOptionID(String optionID) {
		this.optionID = optionID;
	}

}
