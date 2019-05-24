package cn.hehewocao_Client;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;

public class ClientStart {

	public static String userName;

	public static void main(String[] args) {
		start();
	}

	public static void start() {
		String ServerIP = JOptionPane.showInputDialog("请输入服务器IP地址：");
		int ServerPort = Integer.parseInt(JOptionPane.showInputDialog("请输入服务器端口号："));
		String name = JOptionPane.showInputDialog("请输入你的昵称：");
		userName = name;
		Socket s = null;
		try {
			s = new Socket(ServerIP, ServerPort);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "连接服务器失败！");
		}
		if(s != null) {
			ClientSendThread cst = new ClientSendThread(s);
			Thread ct = new Thread(cst);
			ct.start();
			ClientReciveThread crt = new ClientReciveThread(s);
			Thread rt = new Thread(crt);
			rt.start();
		}
	}
}
