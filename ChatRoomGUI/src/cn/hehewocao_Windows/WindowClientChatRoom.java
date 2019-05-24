package cn.hehewocao_Windows;

import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import cn.hehewocao_Client.ClientReciveThread;
import cn.hehewocao_Client.ClientSendThread;

public class WindowClientChatRoom extends JFrame {

	private JPanel contentPane;
	private JTable friendtable;
	private String presendmessage;
	public static JTextArea infotextArea;
	public static JTextArea inputtextArea;
	public static BufferedWriter bw;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WindowClientChatRoom frame = new WindowClientChatRoom();
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
	public WindowClientChatRoom() {

		setTitle("聊天室");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		int width = Toolkit.getDefaultToolkit().getScreenSize().width;
		int height = Toolkit.getDefaultToolkit().getScreenSize().height;
		setBounds((width - 830) / 2, (height - 600) / 2, 830, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		infotextArea = new JTextArea();
		infotextArea.setBounds(45, 71, 524, 283);
		contentPane.add(infotextArea);

		JLabel label = new JLabel("消息记录：");
		label.setBounds(45, 27, 85, 18);
		contentPane.add(label);

		JLabel label_1 = new JLabel("在线好友：");
		label_1.setBounds(611, 27, 91, 18);
		contentPane.add(label_1);

		inputtextArea = new JTextArea();
		inputtextArea.setBounds(45, 394, 524, 107);
		contentPane.add(inputtextArea);

		JButton clearbutton = new JButton("清除");
		clearbutton.setBounds(636, 405, 113, 27);
		contentPane.add(clearbutton);

		JButton sendbutton = new JButton("发送");
		sendbutton.setBounds(636, 462, 113, 27);
		contentPane.add(sendbutton);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(611, 72, 175, 282);
		contentPane.add(scrollPane);

		friendtable = new JTable();
		scrollPane.setViewportView(friendtable);

		Socket s = WindowClient.s;
		try {
			bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
			bw.write(WindowClient.name + "=" + WindowClient.sex);
			bw.newLine();
			bw.flush();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(contentPane, "用户信息发送失败！");
		}

		// 开启客户端接收进程
		ClientReciveThread crt = new ClientReciveThread(s);
		Thread rt = new Thread(crt);
		rt.start();

		// 发送按钮动作
		sendbutton.addActionListener(new ActionListener() {

			private BufferedWriter bw = WindowClientChatRoom.bw;

			@Override
			public void actionPerformed(ActionEvent e) {

				try {
					String str = inputtextArea.getText().trim();
					bw.write(WindowClient.name + "说：" + str);
					bw.newLine();
					bw.flush();
				} catch (IOException e1) {
					JOptionPane.showMessageDialog(null, "客户端发送数据失败！");
				}
				inputtextArea.setText("");
			}
		});

		// 清除按钮动作
		clearbutton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				inputtextArea.setText("");				
			}
		});
	}
}
