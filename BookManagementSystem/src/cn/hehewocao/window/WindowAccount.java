package cn.hehewocao.window;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

public class WindowAccount extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WindowAccount frame = new WindowAccount();
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
	public WindowAccount() {
		setTitle("账号管理界面");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		int width = Toolkit.getDefaultToolkit().getScreenSize().width;
		int height = Toolkit.getDefaultToolkit().getScreenSize().height;

		setBounds((width - 1250) / 2, (height - 800) / 2, 1250, 800);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton addButton = new JButton("\u6DFB\u52A0\u7528\u6237");
		addButton.setBounds(542, 260, 167, 50);
		contentPane.add(addButton);

		JButton updataButton = new JButton("\u67E5\u8BE2\u6216\u4FEE\u6539\u7528\u6237\u4FE1\u606F");
		updataButton.setBounds(542, 408, 167, 50);
		contentPane.add(updataButton);

		JButton changepasswordButton = new JButton("\u4FEE\u6539\u7BA1\u7406\u5458\u5BC6\u7801");
		changepasswordButton.setBounds(542, 551, 167, 50);
		contentPane.add(changepasswordButton);

		// 添加用户按钮动作
		addButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				// 调用注册窗口
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
			}
		});

		// 修改用户信息按钮动作
		updataButton.addActionListener(new ActionListener() {

			
			@Override
			public void actionPerformed(ActionEvent e) {
				/*
				 * 
				 * 调用修改用户信息窗口
				 * 
				 */
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								WindowUpdata frame = new WindowUpdata();
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

		// 修改管理员密码按钮动作
		changepasswordButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				/*
				 * 
				 * 调用修改管理员密码窗口
				 * 
				 */

				/**
				 * Launch the application.
				 */

				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							WindowChangePassword frame = new WindowChangePassword();
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
