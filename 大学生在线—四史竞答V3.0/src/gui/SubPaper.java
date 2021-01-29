package gui;

import java.io.IOException;

public class SubPaper implements Runnable{
	
	public SubPaper() {
		// TODO 自动生成的构造函数存根
	}
	
	@Override
	public void run() {
		// TODO 自动生成的方法存根
		String [] modes= {"5f71e934bcdbf3a8c3ba51d5","5f71e934bcdbf3a8c3ba51d6",
				"5f71e934bcdbf3a8c3ba51d7","5f71e934bcdbf3a8c3ba51d8"};
		String mode_id = modes[CollegeUI.answerBox.getSelectedIndex()];
		int count = (int) CollegeUI.Count.getValue();
		
		try {
			 CollegeUI.submitAnswer(CollegeUI.token, mode_id, count);
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (Throwable e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}

}
