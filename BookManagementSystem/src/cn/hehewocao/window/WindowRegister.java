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
import cn.hehewocao.tool.StudentTools;

import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class WindowRegister extends JFrame {

	private JPanel contentPane;
	private JTextField username;
	private JTextField password;
	private JButton cencle;

	public WindowRegister() {
		setTitle("注册图书信息管理系统用户");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		int width = Toolkit.getDefaultToolkit().getScreenSize().width;
		int height = Toolkit.getDefaultToolkit().getScreenSize().height;

		setBounds((width - 450) / 2, (height - 300) / 2, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel label = new JLabel("\u7528\u6237\u540D\uFF1A");
		label.setBounds(41, 56, 72, 18);
		contentPane.add(label);

		JLabel label_1 = new JLabel("\u5BC6\u7801\uFF1A");
		label_1.setBounds(41, 132, 72, 18);
		contentPane.add(label_1);

		username = new JTextField();
		username.setBounds(117, 53, 204, 24);
		contentPane.add(username);
		username.setColumns(10);

		JButton button = new JButton("\u7ACB\u5373\u6CE8\u518C");
		button.setBounds(89, 188, 113, 27);

		contentPane.add(button);

		password = new JTextField();
		password.setBounds(119, 129, 202, 24);
		contentPane.add(password);
		password.setColumns(10);

		cencle = new JButton("\u53D6\u6D88\u6CE8\u518C");
		cencle.setBounds(252, 188, 113, 27);
		contentPane.add(cencle);

		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String n = username.getText().toString();
				String p = password.getText().toString();
				User user = new User(n, p);

				if (StudentTools.fileWrite("Users.txt", user)) {
					JOptionPane.showMessageDialog(null, "恭喜您，用户注册成功！");
				}
				dispose();
			}
		});

		cencle.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
	}
}
