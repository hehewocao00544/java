package cn.hehewocao_Server;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JOptionPane;

public class ServerStart {

	public static void main(String[] args) throws IOException {

		final int port = 8868;
		ServerSocket ss = new ServerSocket(port);
		InetAddress addr = InetAddress.getLocalHost();
		String hostip = addr.getHostAddress().toString(); // 获取本机IP
		JOptionPane.showMessageDialog(null, "服务器已开启！服务器IP：" + hostip + "  端口号：" + ss.getLocalPort());
		//开始监听客户端连接
		while(true) {
			Socket s = ss.accept();
			String IP = s.getInetAddress().getHostAddress();
			System.out.println("IP:" + IP + "  已连接服务器！");
			ServerThread st = new ServerThread(s);
			Thread thread = new Thread(st);
			thread.start();
		}
	}
}
