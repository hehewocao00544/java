package cn.hehewocao.window;

import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cn.hehewocao.tool.UserTools;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;

public class WindowDelAccount extends JFrame {

	private JPanel contentPane;
	private JTextField infotextField;
	
	public WindowDelAccount() {
		
		setTitle("ɾ���û���Ϣ");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		int width = Toolkit.getDefaultToolkit().getScreenSize().width;
		int height = Toolkit.getDefaultToolkit().getScreenSize().height;

		setBounds((width - 500) / 2, (height - 350) / 2, 450, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel titlelabel = new JLabel("----------\u5220\u9664\u7528\u6237\u4FE1\u606F----------");
		titlelabel.setBounds(123, 35, 257, 18);
		contentPane.add(titlelabel);
		
		JLabel tipelabel = new JLabel("\u5220\u9664\u65B9\u5F0F\uFF1A");
		tipelabel.setBounds(74, 100, 84, 18);
		contentPane.add(tipelabel);
		
		
		
		JLabel label = new JLabel("\u5220\u9664\u9879\uFF1A");
		label.setBounds(74, 164, 72, 18);
		contentPane.add(label);
		
		infotextField = new JTextField();
		infotextField.setBounds(160, 161, 150, 24);
		contentPane.add(infotextField);
		infotextField.setColumns(10);
		
		JButton cenclebutton = new JButton("\u53D6\u6D88");
		cenclebutton.setBounds(74, 227, 113, 27);
		contentPane.add(cenclebutton);
		
		JButton okbutton = new JButton("\u786E\u8BA4\u5220\u9664");
		okbutton.setBounds(267, 227, 113, 27);
		contentPane.add(okbutton);
		
		JComboBox modecomboBox = new JComboBox();
		modecomboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				infotextField.setText("");
			}
		});
		modecomboBox.addItem("�û���");
		modecomboBox.addItem("�ֻ���");
		modecomboBox.setBounds(185, 97, 84, 24);
		contentPane.add(modecomboBox);
		
		//ȡ����ť����
		cenclebutton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				dispose();
			}
		});
		
		//ɾ����ť����
		okbutton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String info = infotextField.getText().trim();
				
				if(modecomboBox.getSelectedItem().toString().equals("�û���")) {
					
					if(UserTools.delAccountUsername(info)) {
						
						JOptionPane.showMessageDialog(contentPane, "��ϲ���û�ɾ���ɹ���");
						dispose();
					}else {
						JOptionPane.showMessageDialog(contentPane, "�Բ����û�ɾ��ʧ�ܣ������������Ϣ�Ƿ�����");
					}
				}else if(modecomboBox.getSelectedItem().toString().equals("�ֻ���")) {
					
					if(UserTools.delAccountPhone(info)) {
						
						JOptionPane.showMessageDialog(contentPane, "��ϲ���û�ɾ���ɹ���");
						dispose();
						
					}else {
						JOptionPane.showMessageDialog(contentPane, "�Բ����û�ɾ��ʧ�ܣ������������Ϣ�Ƿ�����");
					}
				}
			}
		});
	}

}
