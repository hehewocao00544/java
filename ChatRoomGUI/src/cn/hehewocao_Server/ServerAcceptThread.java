package cn.hehewocao_Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import cn.hehewocao_User.User;
import cn.hehewocao_User.UserThread;

public class ServerAcceptThread implements Runnable {

	private ServerSocket ss;
	public static ArrayList<Socket> arraySocket = new ArrayList<Socket>();
	public static ArrayList<String> arrayUser = new ArrayList<String>();
	public static int i = 1;
	
	public ServerAcceptThread(ServerSocket ss) {
		this.ss = ss;
	}

	@Override
	public void run() {

		while (true) {
			try {
				Socket s = ss.accept();
				arraySocket.add(s);
				String IP = s.getInetAddress().getHostAddress();
				System.out.println("IP:" + IP + "  已连接服务器！");
				ServerThread st = new ServerThread(s);
				Thread thread = new Thread(st);
				thread.start();
				
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, "服务器接收连接出现异常！");
			}

		}
	}
}
