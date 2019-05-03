package cn.hehewocao.window;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
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

public class WindowAdministrator extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
	}

	/**
	 * Create the frame.
	 */
	public WindowAdministrator() {
		setTitle("图书信息管理系统");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		int width = Toolkit.getDefaultToolkit().getScreenSize().width;
		int height = Toolkit.getDefaultToolkit().getScreenSize().height;

		setBounds((width - 1250) / 2, (height - 800) / 2, 1250, 800);
		
		
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton accountButton = new JButton("\u8D26\u53F7\u7BA1\u7406");
		accountButton.setBounds(129, 0, 129, 27);
		contentPane.add(accountButton);
		
		JButton bookButton = new JButton("\u56FE\u4E66\u4FE1\u606F\u7BA1\u7406");
		bookButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		bookButton.setBounds(258, 0, 129, 27);
		contentPane.add(bookButton);
		
		JButton readerButton = new JButton("\u8BFB\u8005\u4FE1\u606F\u7BA1\u7406");
		readerButton.setBounds(387, 0, 129, 27);
		contentPane.add(readerButton);
		
		JButton borrowingButton = new JButton("\u56FE\u4E66\u501F\u9605\u7BA1\u7406");
		borrowingButton.setBounds(516, 0, 129, 27);
		contentPane.add(borrowingButton);
		
		JButton baseButton = new JButton("\u57FA\u7840\u4FE1\u606F\u7EF4\u62A4");
		baseButton.setBounds(645, 0, 129, 27);
		contentPane.add(baseButton);
		
		JButton btnNewButton = new JButton("\u6B22\u8FCE");
		btnNewButton.setBounds(0, 0, 129, 27);
		contentPane.add(btnNewButton);
	}
}
