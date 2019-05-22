package cn.hehewocao_Client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

import javax.swing.JOptionPane;

public class ClientSendThread implements Runnable {

	private Socket socket;

	public ClientSendThread(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {

		Socket s = socket;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
			String str = null;
			while ((str = br.readLine()) != null) {	
				
				if(str.equals("OVER")) {
					break;
				}
				bw.write( ClientStart.userName + "说：" + str);
				bw.newLine();
				bw.flush();
			}
			br.close();
			
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "客户端发送数据失败！");
		}
	}

}
