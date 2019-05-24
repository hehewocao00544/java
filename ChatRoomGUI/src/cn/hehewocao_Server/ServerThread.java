package cn.hehewocao_Server;

import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;

public class ServerThread implements Runnable {

	private static Socket socket;
	private String username;
	public ServerThread(Socket socket) {
		this.socket = socket;
		
	}

	@Override
	public void run() {

		try {
			start();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}

	}

	public static void start() throws IOException {
		Socket s = socket;
		ServerReciveThread srt = new ServerReciveThread(s);
		Thread rt = new Thread(srt);
		rt.start();
		
	}
}
