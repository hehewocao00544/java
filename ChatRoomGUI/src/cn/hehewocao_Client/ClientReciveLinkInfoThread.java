package cn.hehewocao_Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

import javax.swing.JOptionPane;

import cn.hehewocao_Windows.WindowClientChatRoom;

public class ClientReciveLinkInfoThread implements Runnable {

	@Override
	public void run() {
		WindowClientChatRoom.model.setRowCount(0);
		try {
			ServerSocket ss = new ServerSocket(1111);
			while (true) {
				Socket s = ss.accept();
				BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));	
				String LinkInfo = null;
				Vector<Vector> row = new Vector<Vector>();
				Vector<String> columnNames = new Vector<String>();
				columnNames.add("连接编号");
				columnNames.add("昵称");
				columnNames.add("性别");
				while((LinkInfo = br.readLine()) != null) {
					Vector<String> rowData = new Vector<String>();
					String[] info = LinkInfo.split("=");
					rowData.add(info[0]);
					rowData.add(info[2]);
					rowData.add(info[3]);
					row.add(rowData);
					WindowClientChatRoom.model.setDataVector(row, columnNames);
				}
				
			}
		} catch (IOException e) {

		}
	}
}
