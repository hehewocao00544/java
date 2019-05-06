package cn.hehewocao.window;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cn.hehewocao.pojo.Admin;
import cn.hehewocao.tool.AdminTools;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class WindowChangePassword extends JFrame {

	private JPanel contentPane;
	private JPasswordField oldpasswordField;
	private JPasswordField newpasswordField;
	private JPasswordField newpasswordField_1;
	private JButton okButton;
	private JButton cencleButton;
	
	public WindowChangePassword() {
		setTitle("�޸Ĺ���Ա����");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		int width = Toolkit.getDefaultToolkit().getScreenSize().width;
		int height = Toolkit.getDefaultToolkit().getScreenSize().height;

		setBounds((width - 500) / 2, (height - 350) / 2,500, 350);
		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel titlelabel = new JLabel("----------\u4FEE\u6539\u7BA1\u7406\u5458\u5BC6\u7801---------");
		titlelabel.setBounds(182, 13, 184, 18);
		contentPane.add(titlelabel);
		
		JLabel oldpasswordlabel = new JLabel("\u65E7\u5BC6\u7801\uFF1A");
		oldpasswordlabel.setBounds(85, 82, 72, 18);
		contentPane.add(oldpasswordlabel);
		
		JLabel newpasswordlabel = new JLabel("\u65B0\u5BC6\u7801\uFF1A");
		newpasswordlabel.setBounds(85, 135, 72, 18);
		contentPane.add(newpasswordlabel);
		
		JLabel newpasswordlabel_1 = new JLabel("\u518D\u6B21\u8F93\u5165\u65B0\u5BC6\u7801\uFF1A");
		newpasswordlabel_1.setBounds(58, 187, 126, 18);
		contentPane.add(newpasswordlabel_1);
		
		oldpasswordField = new JPasswordField();
		oldpasswordField.setBounds(194, 79, 170, 24);
		contentPane.add(oldpasswordField);
		
		newpasswordField = new JPasswordField();
		newpasswordField.setBounds(194, 132, 170, 24);
		contentPane.add(newpasswordField);
		
		newpasswordField_1 = new JPasswordField();
		newpasswordField_1.setBounds(194, 184, 170, 24);
		contentPane.add(newpasswordField_1);
		
		okButton = new JButton("\u786E\u8BA4\u4FEE\u6539");
		okButton.setBounds(302, 247, 113, 27);
		contentPane.add(okButton);
		
		cencleButton = new JButton("\u53D6\u6D88");
		cencleButton.setBounds(98, 247, 113, 27);
		contentPane.add(cencleButton);
		
		//ȷ���޸İ�ť����
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String oldpassworld1 = oldpasswordField.getText().toString().trim();
				String password1 = newpasswordField.getText().toString().trim();
				String password2 = newpasswordField_1.getText().toString().trim();
				
				String oldpassworld2 = AdminTools.fileReader("Admin.txt").getPassword();
				
			
				if(password1.length()==0 || password2.length()==0) {
					
					JOptionPane.showMessageDialog(contentPane, "������������벻��Ϊ�գ�");
					oldpasswordField.setText("");
					newpasswordField.setText("");
					newpasswordField_1.setText("");
					
				}else if(!oldpassworld1.equals(oldpassworld2)){
					
					JOptionPane.showMessageDialog(contentPane, "����������벻��ȷ��");
					oldpasswordField.setText("");
					newpasswordField.setText("");
					newpasswordField_1.setText("");
				}
				
				
				else if(!password1.equals(password2)) {
					JOptionPane.showMessageDialog(contentPane, "��������������벻һ�£�");
					oldpasswordField.setText("");
					newpasswordField.setText("");
					newpasswordField_1.setText("");
				}else {
					Admin admin = new Admin("admin",password1);
					if(AdminTools.fileWriter("Admin.txt", admin)) {
						JOptionPane.showMessageDialog(contentPane, "��ϲ,����Ա�����޸ĳɹ���");
						dispose();
						
						/*
						 * 
						 * �޸�����ɹ������ص�¼���棡
						 * 
						 * */
						/*EventQueue.invokeLater(new Runnable() {
							public void run() {
								try {
									WindowLogin frame = new WindowLogin();
									frame.setVisible(true);
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
						});*/
						
					}else {
						JOptionPane.showMessageDialog(null, "�Բ���,����Ա�����޸�ʧ�ܣ�");
						dispose();
					}
					
				}
				
			}
		});
		
		//ȡ����ť����
		cencleButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {	
				dispose();
			}
		});
	}
}
