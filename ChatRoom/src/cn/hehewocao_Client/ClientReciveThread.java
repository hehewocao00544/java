package cn.hehewocao_Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import javax.swing.JOptionPane;

public class ClientReciveThread implements Runnable {

	private Socket socket;

	public ClientReciveThread(Socket socket) {
		this.socket = socket;
	}

	public void run() {

		Socket s = socket;
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			String message = null;
			while ((message = br.readLine()) != null) {
				System.out.println(message);
			}
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "客户端接受数据失败！");
		}
	}

}
