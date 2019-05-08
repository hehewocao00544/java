package cn.hehewocao.window;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cn.hehewocao.pojo.Book;
import cn.hehewocao.tool.BookTools;
import cn.hehewocao.tool.OtherTools;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class WindowAddBook extends JFrame {

	private JPanel contentPane;
	private JTextField idtextField;
	private JTextField writertextField;
	private JTextField nametextField;
	private JTextField presstextField;
	private JTextField dateytextField;
	private JTextField pricetextField;
	private JTextField numbertextField;
	private JTextField datemtextField;
	private JTextField datedtextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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

	/**
	 * Create the frame.
	 */
	public WindowAddBook() {
		setTitle("图书信息录入");
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
				"---------------------------------------------------------------------\u56FE\u4E66\u4FE1\u606F\u6DFB\u52A0\u56FE\u7247\u6446\u653E------");
		backgroundLabel.setBounds(14, 13, 766, 134);
		contentPane.add(backgroundLabel);

		JLabel idlabel = new JLabel("\u56FE\u4E66\u7F16\u53F7\uFF1A");
		idlabel.setBounds(62, 196, 95, 26);
		contentPane.add(idlabel);

		idtextField = new JTextField();
		idtextField.setBounds(171, 194, 170, 30);
		contentPane.add(idtextField);
		idtextField.setColumns(10);

		JLabel label = new JLabel("\u56FE\u4E66\u7C7B\u522B\uFF1A");
		label.setBounds(438, 200, 75, 22);
		contentPane.add(label);

		JComboBox typecomboBox = new JComboBox();
		typecomboBox.setBounds(548, 197, 126, 24);
		contentPane.add(typecomboBox);
		typecomboBox.addItem("小说");
		typecomboBox.addItem("文学");
		typecomboBox.addItem("传记");
		typecomboBox.addItem("文化教育");
		typecomboBox.addItem("计算机/网络");
		typecomboBox.addItem("医学");
		typecomboBox.addItem("科学技术");
		typecomboBox.addItem("艺术");
		typecomboBox.addItem("动漫/幽默");
		typecomboBox.addItem("娱乐时尚");
		typecomboBox.addItem("旅游");
		typecomboBox.addItem("地图/地理");
		typecomboBox.addItem("生活");
		typecomboBox.addItem("育儿/成长");
		typecomboBox.addItem("体育");
		typecomboBox.addItem("管理");
		typecomboBox.addItem("经济");
		typecomboBox.addItem("法律");
		typecomboBox.addItem("政治/军事");
		typecomboBox.addItem("哲学/宗教");
		typecomboBox.addItem("社会科学");
		typecomboBox.addItem("古籍");
		typecomboBox.addItem("文化");
		typecomboBox.addItem("历史");
		typecomboBox.addItem("其他");

		JLabel label_1 = new JLabel("\u56FE\u4E66\u4F5C\u8005\uFF1A");
		label_1.setBounds(438, 275, 85, 18);
		contentPane.add(label_1);

		writertextField = new JTextField();
		writertextField.setColumns(10);
		writertextField.setBounds(536, 269, 170, 30);
		contentPane.add(writertextField);

		JLabel label_2 = new JLabel("\u56FE\u4E66\u540D\u79F0\uFF1A");
		label_2.setBounds(62, 275, 85, 18);
		contentPane.add(label_2);

		nametextField = new JTextField();
		nametextField.setColumns(10);
		nametextField.setBounds(171, 269, 170, 30);
		contentPane.add(nametextField);

		JLabel label_3 = new JLabel("\u51FA\u7248\u793E\uFF1A");
		label_3.setBounds(62, 351, 85, 18);
		contentPane.add(label_3);

		presstextField = new JTextField();
		presstextField.setColumns(10);
		presstextField.setBounds(171, 348, 170, 30);
		contentPane.add(presstextField);

		JLabel label_4 = new JLabel("\u51FA\u7248\u65E5\u671F\uFF1A");
		label_4.setBounds(438, 348, 85, 18);
		contentPane.add(label_4);

		dateytextField = new JTextField();
		dateytextField.setColumns(10);
		dateytextField.setBounds(536, 339, 67, 30);
		contentPane.add(dateytextField);

		JLabel label_5 = new JLabel("\u56FE\u4E66\u5355\u4EF7\uFF1A");
		label_5.setBounds(62, 429, 85, 18);
		contentPane.add(label_5);

		pricetextField = new JTextField();
		pricetextField.setColumns(10);
		pricetextField.setBounds(171, 417, 170, 30);
		contentPane.add(pricetextField);

		JLabel label_6 = new JLabel("\u5E93\u5B58\u6570\u91CF\uFF1A");
		label_6.setBounds(438, 423, 85, 18);
		contentPane.add(label_6);

		numbertextField = new JTextField();
		numbertextField.setColumns(10);
		numbertextField.setBounds(536, 417, 170, 30);
		contentPane.add(numbertextField);

		JButton cenclebutton = new JButton("结束录入");
		cenclebutton.setBounds(138, 497, 113, 27);
		contentPane.add(cenclebutton);

		JButton resetbutton = new JButton("\u91CD\u7F6E");
		resetbutton.setBounds(318, 497, 113, 27);
		contentPane.add(resetbutton);

		JButton addbutton = new JButton("\u6DFB\u52A0");
		addbutton.setBounds(520, 497, 113, 27);
		contentPane.add(addbutton);

		JLabel label_7 = new JLabel("\u5E74");
		label_7.setBounds(604, 341, 15, 27);
		contentPane.add(label_7);

		datemtextField = new JTextField();
		datemtextField.setBounds(620, 339, 43, 30);
		contentPane.add(datemtextField);
		datemtextField.setColumns(10);

		JLabel label_8 = new JLabel("\u6708");
		label_8.setBounds(665, 341, 15, 27);
		contentPane.add(label_8);

		datedtextField = new JTextField();
		datedtextField.setColumns(10);
		datedtextField.setBounds(682, 339, 43, 30);
		contentPane.add(datedtextField);

		JLabel label_9 = new JLabel("\u65E5");
		label_9.setBounds(728, 341, 15, 27);
		contentPane.add(label_9);
		
		JLabel idtipelabel = new JLabel("");
		idtipelabel.setBounds(346, 196, 85, 26);
		contentPane.add(idtipelabel);

		//id查重
		
		idtextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				idtipelabel.setText("");
				
				if(BookTools.duplicatechecking(idtextField.getText().trim())) {
					idtipelabel.setText("编号重复");
				}else {
					idtipelabel.setText("✔");
				}
			}
		});
		
		// 取消按钮动作
		cenclebutton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				dispose();
			}
		});

		// 重置按钮动作
		resetbutton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				idtextField.setText("");
				nametextField.setText("");
				writertextField.setText("");
				presstextField.setText("");
				dateytextField.setText("");
				datemtextField.setText("");
				datedtextField.setText("");
				pricetextField.setText("");
				numbertextField.setText("");
				idtipelabel.setText("");
			}
		});

		// 添加按钮动作
		addbutton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (idtextField.getText().trim().length() == 0) {
					JOptionPane.showMessageDialog(contentPane, "图书编号不能为空！");
				} else if (nametextField.getText().trim().length() == 0) {
					JOptionPane.showMessageDialog(contentPane, "图书名不能为空！");
				} else if (writertextField.getText().trim().length() == 0) {
					JOptionPane.showMessageDialog(contentPane, "图书作者不能为空！");
				} else if (presstextField.getText().trim().length() == 0) {
					JOptionPane.showMessageDialog(contentPane, "图书出版社不能为空！");
				} else if (dateytextField.getText().trim().length() == 0
						|| datemtextField.getText().trim().length() == 0
						|| datedtextField.getText().trim().length() == 0) {
					JOptionPane.showMessageDialog(contentPane, "图书出版日期不能为空！");
				} else if (pricetextField.getText().trim().length() == 0) {
					JOptionPane.showMessageDialog(contentPane, "图书单价不能为空！");
				} else if (numbertextField.getText().trim().length() == 0) {
					JOptionPane.showMessageDialog(contentPane, "图书库存数量不能为空！");
				} else if(idtipelabel.getText().trim().equals("✔")){
					String id = idtextField.getText().trim();
					String name = nametextField.getText().trim();
					String writer = writertextField.getText().trim();
					String press = presstextField.getText().trim();
					String type = typecomboBox.getSelectedItem().toString().trim();
					int datey = Integer.parseInt(dateytextField.getText().trim());

					String date = dateytextField.getText().trim() + '-' + datemtextField.getText().trim() + '-'
							+ datedtextField.getText().trim();
					float price = Float.parseFloat(pricetextField.getText().trim());
					int number = Integer.parseInt(numbertextField.getText().trim());

					Date datenow = new Date();
					SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
					String now = format.format(datenow);
					String[] str = now.split("-");

					if (!OtherTools.isValidDate(date) || datey > Integer.parseInt(str[0])) {
						JOptionPane.showMessageDialog(contentPane, "您输入的日期不合法！");
					} else if (price < 0) {
						JOptionPane.showMessageDialog(contentPane, "您输入的图书价格不合法！");
					} else if (number < 0) {
						JOptionPane.showMessageDialog(contentPane, "您输入的图书库存数量不合法！");
					}else {
						Book book = new Book(id,name,writer,type,press,date,price,number);
						if(BookTools.fileWrite("bookinformation.txt", book)) {
							JOptionPane.showMessageDialog(contentPane, "恭喜您，图书添加成功！");
							
							idtextField.setText("");
							nametextField.setText("");
							writertextField.setText("");
							presstextField.setText("");
							dateytextField.setText("");
							datemtextField.setText("");
							datedtextField.setText("");
							pricetextField.setText("");
							numbertextField.setText("");
							idtipelabel.setText("");
						}else {
							JOptionPane.showMessageDialog(contentPane, "对不起，图书添加失败！");
						}
					}
				}else {
					JOptionPane.showMessageDialog(contentPane, "编号重复，无法添加！");
				}
			}
		});
	}
}
