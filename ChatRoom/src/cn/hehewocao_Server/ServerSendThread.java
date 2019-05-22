package cn.hehewocao_Server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;

import javax.swing.JOptionPane;

public class ServerSendThread implements Runnable{

	private Socket socket;
	
	public ServerSendThread(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		
		String IP = socket.getInetAddress().getHostAddress();
		int port = 5555;
		try {
		Socket s = new Socket(IP,port);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
		BufferedReader br = new BufferedReader(new FileReader("MessageRecord.txt"));
		String message = null;
		while((message = br.readLine())!= null) {
			String[] str = message.split("=");
			String newMessage = str[0] + "  " +str[1] + "  " + str[2];
			bw.write(newMessage);
			bw.newLine();
			bw.flush();
		}
		br.close();
		
		}catch(IOException e) {
			JOptionPane.showMessageDialog(null, "服务器发送数据失败！");
		}
	}

}
