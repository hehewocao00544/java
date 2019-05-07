package cn.hehewocao.window;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cn.hehewocao.pojo.User;
import cn.hehewocao.tool.UserTools;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class WindowUpdata extends JFrame {

	private JPanel contentPane;
	private JTextField infortextField;

	public static void main(String[] args) {
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
	}

	public WindowUpdata() {

		setTitle("查询或修改用户信息");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		int width = Toolkit.getDefaultToolkit().getScreenSize().width;
		int height = Toolkit.getDefaultToolkit().getScreenSize().height;

		setBounds((width - 800) / 2, (height - 600) / 2, 800, 600);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel titlelabel = new JLabel("----------\u67E5\u8BE2\u7528\u6237----------");
		titlelabel.setFont(new Font("楷体", Font.PLAIN, 20));
		titlelabel.setBounds(243, 41, 312, 18);
		contentPane.add(titlelabel);

		JLabel modelabel = new JLabel("\u67E5\u8BE2\u65B9\u5F0F\uFF1A");
		modelabel.setBounds(174, 98, 77, 18);
		contentPane.add(modelabel);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(70, 235, 643, 178);
		contentPane.add(scrollPane);

		JTextArea infortextArea = new JTextArea();
		scrollPane.setViewportView(infortextArea);
		infortextArea.setEditable(false);

		JLabel itemLabel = new JLabel("\u67E5\u8BE2\u9009\u9879\uFF1A");
		itemLabel.setBounds(412, 98, 77, 18);
		contentPane.add(itemLabel);

		infortextField = new JTextField();
		infortextField.setBounds(265, 158, 131, 24);
		contentPane.add(infortextField);
		infortextField.setColumns(10);
		Font x = new Font("Serif",1,18);
		infortextArea.setFont(x);

		JLabel inforlabel = new JLabel("\u67E5\u8BE2\u4FE1\u606F\uFF1A");
		inforlabel.setBounds(174, 161, 77, 18);
		contentPane.add(inforlabel);

		JButton checkbutton = new JButton("\u7ACB\u5373\u67E5\u8BE2");
		checkbutton.setBounds(486, 157, 113, 27);
		contentPane.add(checkbutton);

		JComboBox comboBoxItem = new JComboBox();
		// 查询选项下拉菜单动作：清除文本域内容
		comboBoxItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				infortextArea.setText("");
				infortextField.setText("");
				infortextField.isFocusable();

			}
		});
		comboBoxItem.setBounds(503, 95, 77, 24);
		comboBoxItem.addItem("用户名");
		comboBoxItem.addItem("手机号");
		contentPane.add(comboBoxItem);

		JComboBox comboBoxmode = new JComboBox();
		// mode下拉列表动作：清除文本域内容
		comboBoxmode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				infortextArea.setText("");
				infortextField.setText("");
				infortextField.isFocusable();
			}
		});
		comboBoxmode.setBounds(265, 95, 77, 24);
		comboBoxmode.addItem("精确");
		comboBoxmode.addItem("模糊");
		contentPane.add(comboBoxmode);

		JButton delbutton = new JButton("\u5220\u9664\u7528\u6237");
		delbutton.setBounds(245, 472, 113, 27);
		contentPane.add(delbutton);

		JButton updatabutton = new JButton("\u4FEE\u6539\u4FE1\u606F");
		updatabutton.setBounds(467, 472, 113, 27);
		contentPane.add(updatabutton);
		
		JLabel label = new JLabel("\u8D26\u53F7\u540D");
		label.setBounds(174, 214, 72, 18);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u5BC6\u7801");
		label_1.setBounds(356, 214, 72, 18);
		contentPane.add(label_1);
		
		JLabel lblNewLabel = new JLabel("\u624B\u673A\u53F7");
		lblNewLabel.setBounds(508, 214, 72, 18);
		contentPane.add(lblNewLabel);

		checkbutton.addActionListener(new ActionListener() {

			// 查询按钮动作
			public void actionPerformed(ActionEvent e) {

				infortextArea.setText("");

				String info = infortextField.getText().toString().trim();

				if (comboBoxmode.getSelectedItem().toString().equals("精确")) {

					if (comboBoxItem.getSelectedItem().toString().equals("用户名")) {

						User user = null;

						if ((user = UserTools.checkUsername(info)) != null) {

							infortextArea
									.setText(user.getUsername() + "\t" + user.getPassword() + '\t' + user.getPhone());

						} else {
							JOptionPane.showMessageDialog(contentPane, "未查询到该用户！");
						}

					} else {

						User user = null;

						if ((user = UserTools.checkPhone(info)) != null) {

							infortextArea
									.setText(user.getUsername() + "\t" + user.getPassword() + '\t' + user.getPhone());

						} else {
							JOptionPane.showMessageDialog(contentPane, "未查询到该用户！");
						}
					}
				} else {// 模糊查询

					if (comboBoxItem.getSelectedItem().toString().equals("用户名")) {

						ArrayList<User> array = UserTools.checkUsernameFuzzy(info);
						if (array != null) {

							for (User user : array) {

								infortextArea.append("                    "+
										user.getUsername() + "\t" + user.getPassword() + "\t" + user.getPhone() + '\n');
								
							}

						} else {

							JOptionPane.showMessageDialog(contentPane, "未查询到该用户！");
						}

					} else {
						JOptionPane.showMessageDialog(contentPane, "电话号码不能模糊查询哟，亲~~");
					}
				}

			}
		});

		// 删除用户按钮动作
		delbutton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (infortextArea.getText().toString().trim().length() == 0) {

					JOptionPane.showMessageDialog(contentPane, "删除前请先进行查询哟，亲~~");
				} else {

					/*
					 * 
					 * 这里调用删除窗口
					 * 
					 */
					/**
					 * Launch the application.
					 */

					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								WindowDelAccount frame = new WindowDelAccount();
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
			}
		});

		// 修改用户信息按钮动作
		updatabutton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (infortextArea.getText().toString().trim().length() == 0) {

					JOptionPane.showMessageDialog(contentPane, "修改信息前请先进行查询哟，亲~~");
				} else {

					/*
					 * 
					 * 这里调用修改用户信息窗口
					 * 
					 */
					/**
					 * Launch the application.
					 */
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
					/**
					 * Create the frame.
					 */

				}
			}
		});
	}
}
