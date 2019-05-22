package cn.hehewocao_User;

import java.net.Socket;
import java.util.ArrayList;
import java.util.ListIterator;

public class UserThread implements Runnable{

	private static ArrayList<Socket> arraySocket;
	
	public UserThread(ArrayList<Socket> arraySocket) {
		this.arraySocket = arraySocket;
	}
	
	@Override
	public void run() {
		
		countUser();
	}

	public static void countUser() {
		
		System.out.println("共有" + arraySocket.size()  + "个用户连接！");
		ListIterator<Socket> it = arraySocket.listIterator();
		while(it.hasNext()) {
			Socket socket = it.next();
			System.out.println(socket.getInetAddress().getHostAddress());
		}
		
	}
}
