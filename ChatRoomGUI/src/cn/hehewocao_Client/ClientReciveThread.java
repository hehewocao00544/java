package cn.hehewocao_Client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JOptionPane;

import cn.hehewocao_Windows.WindowClient;
import cn.hehewocao_Windows.WindowClientChatRoom;

public class ClientReciveThread implements Runnable {

	private Socket socket;

	public ClientReciveThread(Socket socket) {
		this.socket = socket;
	}

	public void run() {
		try {
			
			//接收服务器的消息记录
			ServerSocket ss = new ServerSocket(5555);
			while (true) {
				Socket s = ss.accept();
				BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
				String message = null;
				String allMessage = null;
				while ((message = br.readLine()) != null) {
					System.out.println(message);
					if(allMessage == null) {
						allMessage = message + "\n";
					}else {
						allMessage = allMessage + message + "\n";
					}
					WindowClientChatRoom.infotextArea.setText(allMessage);
					//设置光标在末尾
					WindowClientChatRoom.infotextArea.setCaretPosition(WindowClientChatRoom.infotextArea.getText().length());
				}
			}
			
		} catch (IOException e) {
			try {
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
				bw.write(WindowClient.name + "=Socket is closed!");
				bw.flush();
				socket.close();
			} catch (IOException e1) {
				JOptionPane.showMessageDialog(null, "服务器已关闭！");
			}
			JOptionPane.showMessageDialog(null, "该程序不支持多开鸭~");
			System.exit(0);
		}
	}

}
