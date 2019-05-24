package cn.hehewocao_Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JOptionPane;

import cn.hehewocao_Windows.WindowClientChatRoom;

public class ClientReciveThread implements Runnable {

	private Socket socket;

	public ClientReciveThread(Socket socket) {
		this.socket = socket;
	}

	public void run() {
		try {
			ServerSocket ss = new ServerSocket(5555);
			while (true) {
				Socket s = ss.accept();
				BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
				String message = null;
				String allMessage = null;
				while ((message = br.readLine()) != null) {
					System.out.println(message);
					
					/*WindowClientChatRoom.infotextArea.append(message);
					WindowClientChatRoom.infotextArea.append("\n");*/
					if(allMessage == null) {
						allMessage = message + "\n";
					}else {
						allMessage = allMessage + message + "\n";
					}
					WindowClientChatRoom.infotextArea.setText(allMessage);
				}
			}
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "该程序不支持多开鸭~");
			System.exit(0);
		}
	}

}
