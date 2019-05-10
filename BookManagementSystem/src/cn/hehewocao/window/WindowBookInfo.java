package cn.hehewocao.window;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class WindowBookInfo extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WindowBookInfo frame = new WindowBookInfo();
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
	public WindowBookInfo() {
		
		setTitle("ͼ����Ϣ����");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		int width = Toolkit.getDefaultToolkit().getScreenSize().width;
		int height = Toolkit.getDefaultToolkit().getScreenSize().height;

		setBounds((width - 800) / 2, (height - 600) / 2, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton addinfoButton = new JButton("\u56FE\u4E66\u4FE1\u606F\u5F55\u5165");
		addinfoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		addinfoButton.setBounds(312, 214, 180, 55);
		contentPane.add(addinfoButton);
		
		JButton updataButton = new JButton("\u56FE\u4E66\u4FE1\u606F\u67E5\u8BE2\u4FEE\u6539");
		updataButton.setBounds(312, 344, 180, 55);
		contentPane.add(updataButton);
		
		//¼����Ϣ��ť����
		addinfoButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							WindowAddBook frame = new WindowAddBook();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		
		//��ѯ���޸�ͼ����Ϣ��ť����
		updataButton.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				//���ò�ѯ���޸�ͼ����Ϣ����
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							WindowsUpdataBook frame = new WindowsUpdataBook();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
	}
}
