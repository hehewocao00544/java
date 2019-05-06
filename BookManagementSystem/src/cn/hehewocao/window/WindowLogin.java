package cn.hehewocao.window;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cn.hehewocao.pojo.User;
import cn.hehewocao.tool.AdminTools;
import cn.hehewocao.tool.UserTools;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class WindowLogin extends JFrame {

	private JPanel contentPane;
	private JTextField usernameField;
	private JPasswordField passwordField;

	public WindowLogin() {
		setTitle("��¼ͼ����Ϣ����ϵͳ");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		int width = Toolkit.getDefaultToolkit().getScreenSize().width;
		int height = Toolkit.getDefaultToolkit().getScreenSize().height;

		setBounds((width - 450) / 2, (height - 300) / 2, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		getContentPane().setLayout(null);

		JLabel username = new JLabel("\u7528\u6237\u540D\uFF1A");
		username.setBounds(74, 62, 72, 18);
		contentPane.add(username);

		JLabel password = new JLabel("\u5BC6\u7801\uFF1A");
		password.setBounds(74, 119, 72, 18);
		contentPane.add(password);

		usernameField = new JTextField();
		usernameField.setBounds(149, 59, 190, 24);
		contentPane.add(usernameField);
		usernameField.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setBounds(149, 116, 190, 24);
		contentPane.add(passwordField);

		JButton login = new JButton("\u767B\u5F55");
		login.setBounds(246, 187, 113, 27);
		contentPane.add(login);

		JButton register = new JButton("\u9A6C\u4E0A\u6CE8\u518C");
		register.setBounds(93, 187, 113, 27);
		contentPane.add(register);

		// ��¼��ť����
		login.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				String username = usernameField.getText().toString().trim();
				String password = passwordField.getText().toString().trim();

				if (username.equals("admin")
						&& password.equals(AdminTools.fileReader("admin.txt").getPassword())) {

					JOptionPane.showMessageDialog(null, "�װ��Ĺ���Ա,��ӭʹ��ͼ�����ϵͳ��");
					dispose();
					/*
					 * 
					 * ������ù���Ա����
					 * 
					 */
					/**
					 * Launch the application.
					 */
						EventQueue.invokeLater(new Runnable() {
							public void run() {
								try {
									WindowAdministrator frame = new WindowAdministrator();
									frame.setVisible(true);
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
						});
					/**
					 * Create the frame.
					 */
				} else {

					ArrayList<User> array = UserTools.fileReader("Users.txt");
					int flag = 0;
					for (User user : array) {

						if (user.getUsername().equals(username) && user.getPassword().endsWith(password)) {
							flag = 1;
							break;
						}
					}
					if (flag == 0) {
						JOptionPane.showMessageDialog(null, "��������û�������������");
						passwordField.setText("");
						passwordField.isFocusable();
					} else {
						JOptionPane.showMessageDialog(null, "�װ���" + username + ",��ӭʹ��ͼ�����ϵͳ��");
						dispose();

						/*
						 *
						 * ������û����棡
						 *
						 **/
					}
				}
			}
		});

		// ע�ᰴť����
		register.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				/**
				 * Launch the application.
				 */
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							WindowRegister frame = new WindowRegister();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});

				/**
				 * Create the frame.
				 */
			}
		});
	}
}
