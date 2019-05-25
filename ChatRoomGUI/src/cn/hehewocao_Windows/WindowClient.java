package cn.hehewocao_Windows;

import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class WindowClient extends JFrame {

	private JPanel contentPane;
	private JTextField usernametextField;
	private JButton cencleButton;
	private JTextField IPtextField;
	private JTextField PORTtextField_1;
	public static String name;
	public static String sex;
	public static Socket s;

	public static void main(String[] args) {
		/**
		 * Launch the application.
		 */
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WindowClient frame = new WindowClient();
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

	public WindowClient() {
		setTitle("加入聊天室");
		setResizable(false);
		int width = Toolkit.getDefaultToolkit().getScreenSize().width;
		int height = Toolkit.getDefaultToolkit().getScreenSize().height;

		setBounds((width - 570) / 2, (height - 400) / 2, 570, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel usernameLabel = new JLabel("昵称：");
		usernameLabel.setBounds(138, 54, 72, 18);
		contentPane.add(usernameLabel);

		JLabel sexLabel = new JLabel("性别：");
		sexLabel.setBounds(138, 100, 72, 18);
		contentPane.add(sexLabel);

		usernametextField = new JTextField();
		usernametextField.setBounds(224, 51, 204, 24);
		contentPane.add(usernametextField);
		usernametextField.setColumns(10);

		JButton yesButton = new JButton("加入聊天");
		yesButton.setBounds(377, 283, 113, 27);

		contentPane.add(yesButton);

		cencleButton = new JButton("退出");
		cencleButton.setBounds(97, 283, 113, 27);
		contentPane.add(cencleButton);

		JLabel lblip = new JLabel("服务器IP：");
		lblip.setBounds(122, 155, 88, 18);
		contentPane.add(lblip);

		IPtextField = new JTextField();
		IPtextField.setColumns(10);
		IPtextField.setBounds(224, 152, 204, 24);
		contentPane.add(IPtextField);

		JLabel label_1 = new JLabel("端口号：");
		label_1.setBounds(126, 211, 72, 21);
		contentPane.add(label_1);

		PORTtextField_1 = new JTextField();
		PORTtextField_1.setBounds(224, 209, 204, 24);
		contentPane.add(PORTtextField_1);
		PORTtextField_1.setColumns(10);

		JComboBox sexcomboBox = new JComboBox();
		sexcomboBox.setBounds(224, 97, 98, 24);
		contentPane.add(sexcomboBox);
		sexcomboBox.addItem("男");
		sexcomboBox.addItem("女");

		addWindowListener(new WindowAdapter() {
			
			public void windowClosing(WindowEvent e) {
				super.windowClosing(e);
				
				
			}
		});
		
		
		// 加入聊天室按钮动作
		yesButton.addActionListener(new ActionListener() {

			// 如果连接成功，打开聊天室窗口界面！
			@Override
			public void actionPerformed(ActionEvent e) {

				name = usernametextField.getText().trim();
				sex = sexcomboBox.getSelectedItem().toString();
				String IP = IPtextField.getText().trim();
				String port = PORTtextField_1.getText().trim();
				int PORT = -1;
				try {
					PORT = Integer.parseInt(port);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(contentPane, "端口号输入不合法！");
				}

				if (name.length() == 0) {
					JOptionPane.showMessageDialog(contentPane, "昵称不能为空！");
				} else if (IP.length() == 0) {
					JOptionPane.showMessageDialog(contentPane, "服务器IP不能为空！");
				} else if (port.length() == 0 || PORT == -1) {
					JOptionPane.showMessageDialog(contentPane, "端口号不能为空！");
				} else {

					try {
						//创建与服务器的连接
						s = new Socket(IP, PORT);
						
						
						dispose();
						JOptionPane.showMessageDialog(contentPane, "登陆成功！");
						// 这里调用客户端聊天室窗口

						/**
						 * Launch the application.
						 */
						EventQueue.invokeLater(new Runnable() {
							public void run() {
								try {
									WindowClientChatRoom frame = new WindowClientChatRoom();
									frame.setVisible(true);
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
						});

						/**
						 * Create the frame.
						 */

					} catch (Exception e1) {
						JOptionPane.showMessageDialog(contentPane, "连接服务器超时！");
					}

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
