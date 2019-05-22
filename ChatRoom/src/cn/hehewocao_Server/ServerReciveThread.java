package cn.hehewocao_Server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

import cn.hehewocao_ServerTools.ServerTools;

public class ServerReciveThread implements Runnable {

	private Socket socket;

	public ServerReciveThread(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {

		Socket s = socket;
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));	
			String str = null;
			while ((str = br.readLine())!=null) {
				String IP = s.getInetAddress().getHostAddress();
				str = IP + "=" + str;
				writerFile(str);
				System.out.println("收到客户端数据：" + str);
				ServerTools.ServerSend(ServerStart.arraySocket);
			}
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "接收数据失败！");
		}
	}

	public boolean writerFile(String str) {

		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter("MessageRecord.txt", true));
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
			String s = df.format(new Date()) + "=" + str;
			bw.write(s);
			bw.newLine();
			bw.flush();
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

}
