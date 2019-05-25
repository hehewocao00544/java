package cn.hehewocao_User;

import java.net.Socket;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Vector;

import cn.hehewocao_Server.ServerAcceptThread;
import cn.hehewocao_ServerTools.ServerTools;
import cn.hehewocao_Windows.WindowServer;

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
		
		WindowServer.model.setRowCount(0);
		Vector<Vector> row = new Vector<Vector>();
		Vector<String> columnNames = new Vector<String>();
		columnNames.add("连接编号");
		columnNames.add("连接IP");
		columnNames.add("昵称");
		columnNames.add("性别");	
		System.out.println("共有" + arraySocket.size()  + "个用户连接！");
		ListIterator<Socket> it = arraySocket.listIterator();
		int i = 0;
		while(it.hasNext()) {
			Socket socket = it.next();	
			Vector<String> rowData = new Vector<String>();		
			String[] userinfo = ServerAcceptThread.arrayUser.get(i).split("=");
			rowData.add(userinfo[0]);
			rowData.add(socket.getInetAddress().getHostAddress());
			rowData.add(userinfo[1]);
			rowData.add(userinfo[2]);
			row.add(rowData);						
			WindowServer.model.setDataVector(row, columnNames);
			i++;
		}
	
		ServerTools.ServerSendLink(arraySocket);
	}
}
