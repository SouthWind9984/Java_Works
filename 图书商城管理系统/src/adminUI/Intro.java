package adminUI;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextPane;

public class Intro extends JPanel {

	/**
	 * Create the panel.
	 */
	public Intro() {
		setSize(980,435);
		
		JLabel lblNewLabel = new JLabel("小程序简介");
		lblNewLabel.setFont(new Font("华文楷体", Font.PLAIN, 35));
		
		JTextPane textPane = new JTextPane();
		textPane.setFont(new Font("华文隶书", Font.ITALIC, 29));
		textPane.setText("加油！打工人！");
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(368)
							.addComponent(lblNewLabel))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(155)
							.addComponent(textPane, GroupLayout.PREFERRED_SIZE, 635, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(190, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(30)
					.addComponent(lblNewLabel)
					.addGap(29)
					.addComponent(textPane, GroupLayout.PREFERRED_SIZE, 225, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(105, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
	}
}
