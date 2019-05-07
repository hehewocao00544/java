package cn.hehewocao.window;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cn.hehewocao.pojo.User;
import cn.hehewocao.tool.UserTools;

import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class WindowRegister extends JFrame {

	private JPanel contentPane;
	private JTextField usernametextField;
	private JButton cencleButton;
	private JTextField phonetextField;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;

	public WindowRegister() {
		setTitle("注册图书信息管理系统用户");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		int width = Toolkit.getDefaultToolkit().getScreenSize().width;
		int height = Toolkit.getDefaultToolkit().getScreenSize().height;

		setBounds((width - 600) / 2, (height - 400) / 2, 700, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel usernameLabel = new JLabel("\u7528\u6237\u540D\uFF1A");
		usernameLabel.setBounds(138, 74, 72, 18);
		contentPane.add(usernameLabel);

		JLabel passwordLabel = new JLabel("\u5BC6\u7801\uFF1A");
		passwordLabel.setBounds(138, 133, 72, 18);
		contentPane.add(passwordLabel);

		usernametextField = new JTextField();
		usernametextField.setBounds(275, 71, 204, 24);
		contentPane.add(usernametextField);
		usernametextField.setColumns(10);

		JButton yesButton = new JButton("\u7ACB\u5373\u6CE8\u518C");
		yesButton.setBounds(509, 345, 113, 27);

		contentPane.add(yesButton);

		cencleButton = new JButton("\u53D6\u6D88\u6CE8\u518C");
		cencleButton.setBounds(123, 345, 113, 27);
		contentPane.add(cencleButton);

		JLabel phoneLabel = new JLabel("\u624B\u673A\u53F7\uFF1A");
		phoneLabel.setBounds(138, 255, 72, 18);
		contentPane.add(phoneLabel);

		phonetextField = new JTextField();
		phonetextField.setBounds(275, 252, 204, 24);
		contentPane.add(phonetextField);
		phonetextField.setColumns(10);

		JLabel label = new JLabel("");
		label.setBounds(151, 164, 72, 18);
		contentPane.add(label);

		JLabel label_2Label = new JLabel("\u518D\u6B21\u8F93\u5165\u5BC6\u7801\uFF1A");
		label_2Label.setBounds(123, 196, 113, 18);
		contentPane.add(label_2Label);

		passwordField = new JPasswordField();
		passwordField.setBounds(275, 130, 204, 24);
		contentPane.add(passwordField);

		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(275, 193, 204, 24);
		contentPane.add(passwordField_1);

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
				} else if (UserTools.duplicateCheckingUsername(user)) {
					JOptionPane.showMessageDialog(contentPane, "该用户名已存在！");
				} else if (UserTools.duplicateCheckingPhone(user)) {
					JOptionPane.showMessageDialog(contentPane, "该手机号已被其他用户绑定！");
				} else if (!p.equals(p2)) {
					JOptionPane.showMessageDialog(contentPane, "您输入的两次密码不一致！");
					passwordField.setText("");
					passwordField_1.setText("");
				} else if (UserTools.fileWrite("Users.txt", user)) {
					JOptionPane.showMessageDialog(contentPane, "恭喜您，用户注册成功！");
					dispose();
				}
			}
		});

		cencleButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
	}
}
