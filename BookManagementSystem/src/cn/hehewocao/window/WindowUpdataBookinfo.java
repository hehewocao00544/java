package cn.hehewocao.window;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import cn.hehewocao.pojo.Book;
import cn.hehewocao.tool.BookTools;
import cn.hehewocao.tool.OtherTools;

public class WindowUpdataBookinfo extends JFrame {

	private JPanel contentPane;
	private JTextField infotextField;
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
					WindowUpdataBookinfo frame = new WindowUpdataBookinfo();
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
	public WindowUpdataBookinfo() {
		setTitle("图书信息修改");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		int width = Toolkit.getDefaultToolkit().getScreenSize().width;
		int height = Toolkit.getDefaultToolkit().getScreenSize().height;
		setBounds((width - 800) / 2, (height - 600) / 2, 800, 600);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel backgroundlabel = new JLabel("-------------------图书信息修改图片位置-------------------");
		backgroundlabel.setBounds(239, 29, 416, 54);
		contentPane.add(backgroundlabel);

		JLabel label_0 = new JLabel("\u8F93\u5165\u56FE\u4E66\u7F16\u53F7\uFF1A");
		label_0.setBounds(205, 123, 105, 18);
		contentPane.add(label_0);

		infotextField = new JTextField();

		infotextField.setBounds(324, 120, 170, 24);
		contentPane.add(infotextField);
		infotextField.setColumns(10);

		JLabel infotipslabel = new JLabel("");
		infotipslabel.setBounds(508, 123, 95, 21);
		contentPane.add(infotipslabel);

		JButton canclebutton = new JButton("\u53D6\u6D88");
		canclebutton.setBounds(144, 497, 113, 27);
		contentPane.add(canclebutton);

		JButton okbutton = new JButton("确认修改");
		okbutton.setBounds(519, 497, 113, 27);
		contentPane.add(okbutton);

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

		JButton resetbutton = new JButton("\u91CD\u7F6E");
		resetbutton.setBounds(324, 497, 113, 27);
		contentPane.add(resetbutton);

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

		JLabel label = new JLabel("图书编号：");
		label.setBounds(62, 200, 85, 18);
		contentPane.add(label);

		idtextField = new JTextField();
		idtextField.setColumns(10);
		idtextField.setBounds(171, 197, 170, 30);
		contentPane.add(idtextField);

		JLabel label_10 = new JLabel("图书类型：");
		label_10.setBounds(438, 203, 85, 18);
		contentPane.add(label_10);

		// 信息文本框键盘监听动作
		infotextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {

				infotipslabel.setText("");
				String info = infotextField.getText().trim();
				Book book = new Book();
				if ((book = BookTools.checkBookId(info)) == null) {
					infotipslabel.setText("该图书不存在！");
					idtextField.setText("");
					nametextField.setText("");
					writertextField.setText("");
					presstextField.setText("");
					dateytextField.setText("");
					datemtextField.setText("");
					datedtextField.setText("");
					pricetextField.setText("");
					numbertextField.setText("");
				} else {
					infotipslabel.setText("✔");
					idtextField.setText(book.getId());
					nametextField.setText(book.getBookname());
					writertextField.setText(book.getWriter());
					typecomboBox.setSelectedItem(book.getType());
					presstextField.setText(book.getPress());
					String[] str = book.getDate().split("-");
					dateytextField.setText(str[0]);
					datemtextField.setText(str[1]);
					datedtextField.setText(str[2]);
					pricetextField.setText(String.valueOf(book.getPrice()));
					numbertextField.setText(String.valueOf(book.getNumber()));
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
		// 重置按钮动作
		resetbutton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				infotextField.setText("");
				infotipslabel.setText("");
				idtextField.setText("");
				nametextField.setText("");
				writertextField.setText("");
				presstextField.setText("");
				dateytextField.setText("");
				datemtextField.setText("");
				datedtextField.setText("");
				pricetextField.setText("");
				numbertextField.setText("");

			}
		});
		// 确认修改按钮动作
		okbutton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (infotipslabel.getText().trim().equals("✔")) {
					
					String id = idtextField.getText().trim();
					String name = nametextField.getText().trim();
					String writer = writertextField.getText().trim();
					String press = presstextField.getText().trim();
					String date = dateytextField.getText().trim()+"-"+datemtextField.getText().trim()+"-"+datedtextField.getText().trim();
					String type = typecomboBox.getSelectedItem().toString();
					float price = -1;
					try {
						price = Float.parseFloat(pricetextField.getText().trim());
					}catch (Exception q) {
						JOptionPane.showMessageDialog(contentPane, "非法价格!");
					}
					int number = -1;
					try {
						number = Integer.parseInt(numbertextField.getText().trim());
					}catch(Exception q) {
						JOptionPane.showMessageDialog(contentPane, "非法库存数量!");
					}
					
					if(id.length()==0) {
						JOptionPane.showMessageDialog(contentPane, "图书编号不能为空!");
					}else if(name.length()==0) {
						JOptionPane.showMessageDialog(contentPane, "图书名不能为空!");
					}else if(writer.length()==0) {
						JOptionPane.showMessageDialog(contentPane, "图书作者不能为空!");
					}else if(press.length()==0) {
						JOptionPane.showMessageDialog(contentPane, "图书出版社不能为空!");
					}else if(price < 0) {
						JOptionPane.showMessageDialog(contentPane, "图书价格非法!");
					}else if(number < 0) {
						JOptionPane.showMessageDialog(contentPane, "图书库存数量非法!");
					}else if (!OtherTools.isValidDate(date)) {
						JOptionPane.showMessageDialog(contentPane, "您输入的日期不合法！");
					}else if(!infotextField.getText().trim().equals(idtextField.getText())) {
						if(BookTools.duplicatechecking(idtextField.getText())) {
							JOptionPane.showMessageDialog(contentPane, "编号重复了，亲~~");
						}else {
							BookTools.delBookId(infotextField.getText().trim());
							Book book = new Book(id,name,writer,type,press,date,price,number);
							if(BookTools.fileWrite("bookinformation.txt", book)) {
								JOptionPane.showMessageDialog(contentPane, "恭喜您，图书信息修改成功！");
							}else {
								JOptionPane.showMessageDialog(contentPane, "对不起，图书信息修改失败！");
							}
							dispose();
						}
					}else if(infotextField.getText().trim().equals(idtextField.getText())){
						
						BookTools.delBookId(infotextField.getText().trim());
						Book book = new Book(id,name,writer,type,press,date,price,number);
						if(BookTools.fileWrite("bookinformation.txt", book)) {
							JOptionPane.showMessageDialog(contentPane, "恭喜您，图书信息修改成功！");
						}else {
							JOptionPane.showMessageDialog(contentPane, "对不起，图书信息修改失败！");
						}
						dispose();
					}
				}else {
					JOptionPane.showMessageDialog(contentPane, "请输入正确的图书编号！");
				}
				
			}
		});
}

}
