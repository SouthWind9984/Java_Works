package main;

public class Topic {

	String Title = "";
	String[] answer = null;

	public Topic() {
		// TODO 自动生成的构造函数存根
	}

	public Topic(String title, String[] answer) {
		super();
		Title = title;
		this.answer = answer;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String[] getAnswer() {
		return answer;
	}

	public void setAnswer(String[] answer) {
		this.answer = answer;
	}

}
