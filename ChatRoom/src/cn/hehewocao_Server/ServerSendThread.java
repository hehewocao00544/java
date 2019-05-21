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
		
		Socket s = socket;
		try {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
		BufferedReader br = new BufferedReader(new FileReader("MessageRecord.txt"));
		String message = null;
		while((message = br.readLine())!= null) {
			
		}
		
		}catch(IOException e) {
			JOptionPane.showMessageDialog(null, "服务器发送数据失败！");
		}
	}

}
