package cn.hehewocao_Windows;

import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import cn.hehewocao_Server.ServerAcceptThread;
import java.awt.Color;
import javax.swing.JScrollPane;

public class WindowServer extends JFrame {

	private JPanel contentPane;
	public static JTable connectTable;
	final int port = 8868;
	private ServerSocket ss;
	private Thread at;
	
	public static DefaultTableModel model;
	public static JTextArea infortextArea;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WindowServer frame = new WindowServer();
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
	public WindowServer() {
		setTitle("聊天室服务器");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		int width = Toolkit.getDefaultToolkit().getScreenSize().width;
		int height = Toolkit.getDefaultToolkit().getScreenSize().height;

		setBounds((width - 900) / 2, (height - 600) / 2, 900, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		infortextArea = new JTextArea();
		infortextArea.setBounds(32, 102, 406, 390);
		contentPane.add(infortextArea);

		JLabel label = new JLabel("聊天信息");
		label.setBounds(195, 78, 72, 18);
		contentPane.add(label);

		JLabel label_1 = new JLabel("连接信息");
		label_1.setBounds(610, 78, 72, 18);
		contentPane.add(label_1);

		JButton startbutton = new JButton("启动服务器");
		startbutton.setBounds(161, 522, 119, 27);
		contentPane.add(startbutton);

		JButton closebutton = new JButton("关闭服务器");
		closebutton.setBounds(576, 522, 119, 27);
		contentPane.add(closebutton);

		JLabel stateinfolabel = new JLabel("服务器未开启！");
		stateinfolabel.setForeground(Color.RED);
		stateinfolabel.setBounds(257, 30, 425, 18);
		contentPane.add(stateinfolabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(472, 102, 394, 390);
		
		model = new DefaultTableModel();
		JTable table = new JTable(model);
		scrollPane.setViewportView(table);
		contentPane.add(scrollPane);
		// 开启服务器按钮动作
		startbutton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				try {
					//ServerSocket ss = new ServerSocket(port);
					ss = new ServerSocket(port);
					InetAddress addr = InetAddress.getLocalHost();
					String hostip = addr.getHostAddress().toString(); // 获取本机IP
					stateinfolabel.setText("服务器已开启！服务器IP：" + hostip + "  端口号：" + ss.getLocalPort());
					JOptionPane.showMessageDialog(null, "服务器已开启！服务器IP：" + hostip + "  端口号：" + ss.getLocalPort());
					// 开启监听客户端连接
					ServerAcceptThread sat = new ServerAcceptThread(ss);
					//Thread at = new Thread(sat);
					at = new Thread(sat);
					at.start();
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "服务器已开启！");
				}
			}

		});
		
		//关闭服务器按钮动作！
		closebutton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				/*stateinfolabel.setText("服务器已关闭！");
				try {
					ss.close();
				} catch (IOException e1) {
					
					JOptionPane.showMessageDialog(null, "服务器关闭失败！");
				}*/
				System.exit(0);
			}
		});
	}
}
