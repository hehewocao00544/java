package cn.hehewocao.window;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import cn.hehewocao.pojo.User;
import cn.hehewocao.tool.UserTools;
import javax.swing.JComboBox;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class WindowUpdataAccount extends JFrame {

	private JPanel contentPane;
	private JTextField usernametextField;
	private JTextField passwordField;
	private JTextField passwordField_1;
	private JTextField phonetextField;
	private JTextField infotextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WindowUpdataAccount frame = new WindowUpdataAccount();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public WindowUpdataAccount() {

		setTitle("用户信息修改");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		int width = Toolkit.getDefaultToolkit().getScreenSize().width;
		int height = Toolkit.getDefaultToolkit().getScreenSize().height;

		setBounds((width - 900) / 2, (height - 700) / 2, 900, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel infotiplabel = new JLabel("");
		infotiplabel.setBounds(616, 167, 153, 18);
		contentPane.add(infotiplabel);
		
		JComboBox itemcomboBox = new JComboBox();
		itemcomboBox.setBounds(431, 101, 84, 24);
		contentPane.add(itemcomboBox);
		itemcomboBox.addItem("用户名");
		itemcomboBox.addItem("手机号");

		JLabel usernameLabel = new JLabel("\u7528\u6237\u540D\uFF1A");
		usernameLabel.setBounds(267, 235, 72, 18);
		contentPane.add(usernameLabel);

		JLabel passwordLabel = new JLabel("\u5BC6\u7801\uFF1A");
		passwordLabel.setBounds(267, 302, 72, 18);
		contentPane.add(passwordLabel);

		JButton yesButton = new JButton("\u7ACB\u5373\u4FEE\u6539");
		yesButton.setBounds(656, 537, 113, 27);

		contentPane.add(yesButton);

		JLabel phoneLabel = new JLabel("\u624B\u673A\u53F7\uFF1A");
		phoneLabel.setBounds(267, 438, 72, 18);
		contentPane.add(phoneLabel);

		JLabel label = new JLabel("");
		label.setBounds(151, 164, 72, 18);
		contentPane.add(label);

		JLabel label_2Label = new JLabel("\u518D\u6B21\u8F93\u5165\u5BC6\u7801\uFF1A");
		label_2Label.setBounds(261, 368, 113, 18);
		contentPane.add(label_2Label);

		usernametextField = new JTextField();
		usernametextField.setBounds(388, 232, 198, 24);
		contentPane.add(usernametextField);
		usernametextField.setColumns(10);

		passwordField = new JTextField();
		passwordField.setBounds(388, 299, 198, 24);
		contentPane.add(passwordField);
		passwordField.setColumns(10);

		passwordField_1 = new JTextField();
		passwordField_1.setBounds(388, 365, 198, 24);
		contentPane.add(passwordField_1);
		passwordField_1.setColumns(10);

		phonetextField = new JTextField();
		phonetextField.setBounds(388, 435, 198, 24);
		contentPane.add(phonetextField);
		phonetextField.setColumns(10);

		JButton cenclebutton = new JButton("\u53D6\u6D88");
		cenclebutton.setBounds(214, 537, 113, 27);
		contentPane.add(cenclebutton);

		JButton resetbutton = new JButton("\u91CD\u7F6E");
		resetbutton.setBounds(431, 537, 113, 27);
		contentPane.add(resetbutton);
		
		JLabel label_1 = new JLabel("------------------------------\u7528\u6237\u4FE1\u606F\u4FEE\u6539------------------------------");
		label_1.setBounds(287, 27, 593, 18);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("\u4FEE\u6539\u9879\uFF1A");
		label_2.setBounds(267, 104, 72, 18);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("\u4FEE\u6539\u4FE1\u606F\uFF1A");
		label_3.setBounds(267, 164, 90, 18);
		contentPane.add(label_3);
		
		infotextField = new JTextField();
		infotextField.addKeyListener(new KeyAdapter() {
			@Override
			//信息文本框动作
			public void keyPressed(KeyEvent arg0) {
				
				infotiplabel.setText("");
				
				String info = infotextField.getText().trim();
				
				if(itemcomboBox.getSelectedItem().toString().equals("用户名")) {
					//未找到此用户
					if(UserTools.checkUsername(info)==null) {
						infotiplabel.setText("该用户不存在！");
					}else {
						infotiplabel.setText("");
					}
					
				}else if(itemcomboBox.getSelectedItem().toString().equals("手机号")) {
					
				}
			}
		});
		infotextField.setBounds(388, 164, 198, 24);
		contentPane.add(infotextField);
		infotextField.setColumns(10);
		
		

		itemcomboBox.addActionListener(new ActionListener() {
			//下拉标签动作
			public void actionPerformed(ActionEvent e) {
				usernametextField.setText("");
				passwordField.setText("");
				passwordField_1.setText("");
				phonetextField.setText("");
				infotextField.setText("");
			}
		});

		// 确认修改动作
		yesButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String n = usernametextField.getText().toString().trim();
				String p = passwordField.getText().toString().trim();
				String p2 = passwordField_1.getText().toString().trim();
				String t = phonetextField.getText().toString().trim();
				User user = new User(n, p, t);

				if (n.length() == 0) {
					
					JOptionPane.showMessageDialog(contentPane, "用户名不能为空！");

				} else if (n.equals("admin")) {
					JOptionPane.showMessageDialog(contentPane, "该用户名已存在！");
				} else if (p.length() == 0 || p2.length() == 0) {

					JOptionPane.showMessageDialog(contentPane, "密码不能为空！");
				} else if (t.length() == 0) {

					JOptionPane.showMessageDialog(contentPane, "手机号不能为空！");
				} else if (!p.equals(p2)) {
					JOptionPane.showMessageDialog(contentPane, "您输入的两次密码不一致！");
					passwordField.setText("");
					passwordField_1.setText("");
				} else {
					
					
					
					
				}
				
				
				
				
				
				/*else if (UserTools.updataAccount(user)) {
					JOptionPane.showMessageDialog(contentPane, "恭喜您，用户修改成功！");
					dispose();
				} else {
					JOptionPane.showMessageDialog(contentPane, "对不起，用户修改失败！");
				}*/
			}
		});

		// 取消修改动作
		cenclebutton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				dispose();
			}
		});
		
		//重置按钮动作
		resetbutton.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				
				usernametextField.setText("");
				passwordField.setText("");
				passwordField_1.setText("");
				phonetextField.setText("");
				infotextField.setText("");
			}
		});
	}
}
