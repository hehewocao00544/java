package cn.hehewocao.window;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import cn.hehewocao.pojo.Book;
import cn.hehewocao.tool.BookTools;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class WindowsUpdataBook extends JFrame {

	private JPanel contentPane;
	private JTextField infotextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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

	/**
	 * Create the frame.
	 */
	public WindowsUpdataBook() {

		setTitle("ͼ����Ϣ��ѯ���޸�");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		int width = Toolkit.getDefaultToolkit().getScreenSize().width;
		int height = Toolkit.getDefaultToolkit().getScreenSize().height;
		setBounds((width - 800) / 2, (height - 600) / 2, 800, 600);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel backgroundLabel = new JLabel(
				"----------------------------\u56FE\u4E66\u4FE1\u606F\u67E5\u8BE2\u6216\u4FEE\u6539\u56FE\u7247---------------");
		backgroundLabel.setBounds(104, 51, 651, 59);
		contentPane.add(backgroundLabel);

		JLabel label = new JLabel("\u67E5\u8BE2\u65B9\u5F0F\uFF1A");
		label.setBounds(119, 158, 89, 18);
		contentPane.add(label);

		JComboBox modecomboBox = new JComboBox();
		modecomboBox.setBounds(211, 155, 100, 24);
		contentPane.add(modecomboBox);
		modecomboBox.addItem("��׼");
		modecomboBox.addItem("ģ��");

		JLabel label_1 = new JLabel("\u67E5\u8BE2\u9009\u9879\uFF1A");
		label_1.setBounds(409, 158, 89, 18);
		contentPane.add(label_1);

		JComboBox itemcomboBox = new JComboBox();
		itemcomboBox.setBounds(512, 155, 100, 24);
		contentPane.add(itemcomboBox);
		itemcomboBox.addItem("ͼ����");
		itemcomboBox.addItem("����");
		itemcomboBox.addItem("����");

		JLabel label_2 = new JLabel("\u67E5\u8BE2\u4FE1\u606F\uFF1A");
		label_2.setBounds(119, 224, 89, 18);
		contentPane.add(label_2);

		infotextField = new JTextField();
		infotextField.setBounds(211, 221, 140, 24);
		contentPane.add(infotextField);
		infotextField.setColumns(10);

		JButton checkbutton = new JButton("\u7ACB\u5373\u67E5\u8BE2");
		checkbutton.setBounds(409, 220, 113, 27);
		contentPane.add(checkbutton);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(77, 283, 639, 160);
		contentPane.add(scrollPane);

		JButton delbutton = new JButton("\u5220\u9664\u4FE1\u606F");
		delbutton.setBounds(198, 490, 113, 27);
		contentPane.add(delbutton);

		JButton updatabutton = new JButton("\u4FEE\u6539\u4FE1\u606F");
		updatabutton.setBounds(499, 490, 113, 27);
		contentPane.add(updatabutton);

		DefaultTableModel model = new DefaultTableModel();
		JTable table = new JTable(model);
		scrollPane.setViewportView(table);
		contentPane.add(scrollPane);

		//��ѯѡ�������б���
		itemcomboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				infotextField.setText("");
			}
		});
		
		//ɾ����ť����
		delbutton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				/*
				 * 
				 * �������ͼ����Ϣɾ������
				 * 
				 */
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							WindowDelBookinfor frame = new WindowDelBookinfor();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		
		//ͼ����Ϣ�޸İ�ť����
		updatabutton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				/*
				 * 
				 * �������ͼ����Ϣ�޸Ĺ��ܴ���
				 * 
				 */
				
			}
		});
		
		// ��ѯ��ť����
		checkbutton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String info = infotextField.getText().trim();
				Vector<String> columnNames = new Vector<String>();
				columnNames.add("ͼ����");
				columnNames.add("����");
				columnNames.add("����");
				columnNames.add("ͼ������");
				columnNames.add("������");
				columnNames.add("��������");
				columnNames.add("ͼ�鵥��");
				columnNames.add("�������");

				Vector<Vector> row = new Vector<Vector>();

				if (info.length() == 0) {

					JOptionPane.showMessageDialog(contentPane, "��ѯ��Ϣ����Ϊ�գ�");

				} else if (modecomboBox.getSelectedItem().toString().equals("��׼")) {

					Book book = new Book();
					ArrayList<Book> arraybook = new ArrayList<Book>();

					if (itemcomboBox.getSelectedItem().toString().equals("ͼ����")) {

						if ((book = BookTools.checkBookId(info)) != null) {

							Vector<String> rowData = new Vector<String>();
							rowData.add(book.getId());
							rowData.add(book.getBookname());
							rowData.add(book.getWriter());
							rowData.add(book.getType());
							rowData.add(book.getPress());
							rowData.add(book.getDate());
							rowData.add(String.valueOf(book.getPrice()));
							rowData.add(String.valueOf(book.getNumber()));
							row.add(rowData);
							model.setDataVector(row, columnNames);

						} else {

							JOptionPane.showMessageDialog(contentPane, "�Բ���δ��ѯ���Ȿͼ�飡");
						}

					} else if (itemcomboBox.getSelectedItem().toString().equals("����")) {

						if ((arraybook = BookTools.checkBookName(info)) != null) {

							for (Book b : arraybook) {

								Vector<String> rowData = new Vector<String>();
								rowData.add(b.getId());
								rowData.add(b.getBookname());
								rowData.add(b.getWriter());
								rowData.add(b.getType());
								rowData.add(b.getPress());
								rowData.add(b.getDate());
								rowData.add(String.valueOf(b.getPrice()));
								rowData.add(String.valueOf(b.getNumber()));
								row.add(rowData);
								model.setDataVector(row, columnNames);
							}

						} else {

							JOptionPane.showMessageDialog(contentPane, "�Բ���δ��ѯ���Ȿͼ�飡");
						}

					} else if (itemcomboBox.getSelectedItem().toString().equals("����")) {
						
						if ((arraybook = BookTools.checkBookWriter(info)) != null) {

							for (Book b : arraybook) {

								Vector<String> rowData = new Vector<String>();
								rowData.add(b.getId());
								rowData.add(b.getBookname());
								rowData.add(b.getWriter());
								rowData.add(b.getType());
								rowData.add(b.getPress());
								rowData.add(b.getDate());
								rowData.add(String.valueOf(b.getPrice()));
								rowData.add(String.valueOf(b.getNumber()));
								row.add(rowData);
								model.setDataVector(row, columnNames);
							}

						} else {

							JOptionPane.showMessageDialog(contentPane, "�Բ���δ��ѯ���Ȿͼ�飡");
						}
						
					}
				} else {//ģ������
					
					ArrayList<Book> arraybook = new ArrayList<Book>();

					if (itemcomboBox.getSelectedItem().toString().equals("ͼ����")) {
						
						JOptionPane.showMessageDialog(contentPane, "�Բ���ͼ���Ų�����ģ������Ӵ~~");
						
					} else if (itemcomboBox.getSelectedItem().toString().equals("����")) {

						if ((arraybook = BookTools.checkBookNameFuzzy(info)) != null) {

							for (Book b : arraybook) {

								Vector<String> rowData = new Vector<String>();
								rowData.add(b.getId());
								rowData.add(b.getBookname());
								rowData.add(b.getWriter());
								rowData.add(b.getType());
								rowData.add(b.getPress());
								rowData.add(b.getDate());
								rowData.add(String.valueOf(b.getPrice()));
								rowData.add(String.valueOf(b.getNumber()));
								row.add(rowData);
								model.setDataVector(row, columnNames);
							}

						} else {

							JOptionPane.showMessageDialog(contentPane, "�Բ���δ��ѯ���Ȿͼ�飡");
						}

					} else if (itemcomboBox.getSelectedItem().toString().equals("����")) {
						
						if ((arraybook = BookTools.checkBookWriterFuzzy(info)) != null) {

							for (Book b : arraybook) {

								Vector<String> rowData = new Vector<String>();
								rowData.add(b.getId());
								rowData.add(b.getBookname());
								rowData.add(b.getWriter());
								rowData.add(b.getType());
								rowData.add(b.getPress());
								rowData.add(b.getDate());
								rowData.add(String.valueOf(b.getPrice()));
								rowData.add(String.valueOf(b.getNumber()));
								row.add(rowData);
								model.setDataVector(row, columnNames);
							}

						} else {

							JOptionPane.showMessageDialog(contentPane, "�Բ���δ��ѯ���Ȿͼ�飡");
						}
						
					}
					
				}
			}
		});
	}
}
