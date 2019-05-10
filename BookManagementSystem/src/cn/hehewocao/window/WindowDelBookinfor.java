package cn.hehewocao.window;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import cn.hehewocao.pojo.Book;
import cn.hehewocao.tool.BookTools;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Vector;

import javax.swing.JScrollPane;
import javax.swing.JTable;

public class WindowDelBookinfor extends JFrame {

	private JPanel contentPane;
	private JTextField infotextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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

	/**
	 * Create the frame.
	 */
	public WindowDelBookinfor() {
		setTitle("图书信息删除");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		int width = Toolkit.getDefaultToolkit().getScreenSize().width;
		int height = Toolkit.getDefaultToolkit().getScreenSize().height;
		setBounds((width - 500) / 2, (height - 350) / 2, 450, 350);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel backgroundlabel = new JLabel(
				"-------------------\u56FE\u4E66\u4FE1\u606F\u5220\u9664\u56FE\u7247\u4F4D\u7F6E-------------------");
		backgroundlabel.setBounds(14, 13, 416, 54);
		contentPane.add(backgroundlabel);

		JLabel label_1 = new JLabel("\u8F93\u5165\u56FE\u4E66\u7F16\u53F7\uFF1A");
		label_1.setBounds(43, 96, 105, 18);
		contentPane.add(label_1);

		infotextField = new JTextField();
		infotextField.setBounds(162, 93, 170, 24);
		contentPane.add(infotextField);
		infotextField.setColumns(10);

		JLabel infotipslabel = new JLabel("");
		infotipslabel.setBounds(335, 96, 95, 18);
		contentPane.add(infotipslabel);

		JButton canclebutton = new JButton("\u53D6\u6D88");
		canclebutton.setBounds(56, 242, 113, 27);
		contentPane.add(canclebutton);

		JButton okbutton = new JButton("\u786E\u8BA4\u5220\u9664");
		okbutton.setBounds(289, 242, 113, 27);
		contentPane.add(okbutton);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(43, 151, 359, 54);
		contentPane.add(scrollPane);

		DefaultTableModel model = new DefaultTableModel();
		JTable table = new JTable(model);
		scrollPane.setViewportView(table);
		contentPane.add(scrollPane);

		// 信息输入框键盘监听动作
		infotextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {

				infotipslabel.setText("");
				String info = infotextField.getText().trim();
				Book book = new Book();
				if ((book = BookTools.checkBookId(info)) == null) {
					infotipslabel.setText("该图书不存在！");
				} else {
					infotipslabel.setText("✔");
					Vector<String> columnNames = new Vector<String>();
					columnNames.add("书名");
					columnNames.add("作者");
					columnNames.add("图书类型");
					columnNames.add("出版社");
					Vector<Vector> row = new Vector<Vector>();
					Vector<String> rowData = new Vector<String>();
					rowData.add(book.getBookname());
					rowData.add(book.getWriter());
					rowData.add(book.getType());
					rowData.add(book.getPress());
					row.add(rowData);
					model.setDataVector(row, columnNames);
				}
			}
		});

		// 取消按钮动作
		canclebutton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				dispose();

			}
		});

		// 确认删除按钮动作
		okbutton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (infotipslabel.getText().equals("✔")) {

					String info = infotextField.getText().trim();

					if (BookTools.delBookId(info)) {
						JOptionPane.showMessageDialog(contentPane, "恭喜您，图书删除成功！");
						dispose();
					} else {
						JOptionPane.showMessageDialog(contentPane, "对不起，图书删除失败！");
					}
				} else {
					JOptionPane.showMessageDialog(contentPane, "请输入正确的图书编号！");
				}
			}
		});
	}

}
