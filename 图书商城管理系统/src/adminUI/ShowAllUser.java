package adminUI;

import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import entity.UserData;
import severice.UserSever;

public class ShowAllUser extends JPanel {
	private UserSever userSever = new UserSever();

	private JTable table;

	/**
	 * Create the panel.
	 */
	public ShowAllUser() {
		setSize(980,435);

		JLabel lblNewLabel = new JLabel("所有用户信息");
		lblNewLabel.setFont(new Font("华文行楷", Font.PLAIN, 30));
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(363)
							.addComponent(lblNewLabel))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 952, Short.MAX_VALUE)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(27)
					.addComponent(lblNewLabel)
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE)
					.addContainerGap())
		);
		int size = userSever.readUser().size();
		
		Object [] [] data = new Object[size][4];
		for(int i=0;i<size;i++) {
			UserData user = userSever.readUser().get(i);
				data[i][0]=user.getName();
				data[i][1]=user.getPasswd();
				data[i][2]=user.getAddress();
				data[i][3]=user.getMoney();
				
			}
		table = new JTable();
		table.setModel(new DefaultTableModel(
			data,
			new String[] {
				"\u7528\u6237\u540D", "\u5BC6\u7801", "\u5730\u5740", "\u4F59\u989D"
			}
		));
		scrollPane.setViewportView(table);
		setLayout(groupLayout);
		
	}

}
