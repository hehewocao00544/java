package cn.hehewocao.window;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JToolBar;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import java.awt.Panel;
import java.awt.Label;
import java.awt.ComponentOrientation;

public class WindowAdministrator extends JFrame {

	private JPanel contentPane;
	public WindowAdministrator() {
		setResizable(false);
		setTitle("图书信息管理系统");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		int width = Toolkit.getDefaultToolkit().getScreenSize().width;
		int height = Toolkit.getDefaultToolkit().getScreenSize().height;
		
		ImageIcon bimg = new ImageIcon("background.jpg");
		JLabel bg = new JLabel(bimg);
		bg.setBounds(0, 0, bimg.getIconWidth(), bimg.getIconHeight());
		JPanel imagePanel = (JPanel) this.getContentPane();
		this.getLayeredPane().add(bg, new Integer(Integer.MIN_VALUE)); // 把背景图片添加到分层窗格的最底层作为背景
		
		
		setBounds((width - 1250) / 2, (height - 800) / 2, 1250, 800);

		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton accountButton = new JButton("\u8D26\u53F7\u7BA1\u7406");
		accountButton.setBounds(530, 216, 180, 50);
		contentPane.add(accountButton);

		JButton bookButton = new JButton("\u56FE\u4E66\u4FE1\u606F\u7BA1\u7406");
		bookButton.setBounds(530, 328, 180, 50);
		contentPane.add(bookButton);

		JButton readerButton = new JButton("\u8BFB\u8005\u4FE1\u606F\u7BA1\u7406");
		readerButton.setBounds(530, 432, 180, 50);
		contentPane.add(readerButton);

		JButton borrowingButton = new JButton("\u56FE\u4E66\u501F\u9605\u7BA1\u7406");
		borrowingButton.setBounds(530, 542, 180, 50);
		contentPane.add(borrowingButton);

		JButton baseButton = new JButton("\u57FA\u7840\u4FE1\u606F\u7EF4\u62A4");
		baseButton.setBounds(530, 646, 180, 50);
		contentPane.add(baseButton);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("background.jpg"));
		lblNewLabel.setBounds(0, 0, 1244, 765);
		contentPane.add(lblNewLabel);
		
		
		// 账号管理按钮
		accountButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});

		// 图书管理按钮
		bookButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});

		// 读者管理按钮
		readerButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});

		// 借阅管理按钮
		borrowingButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});

		// 基础维护管理按钮
		baseButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});
	}
}
