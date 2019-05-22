package cn.hehewocao_ServerTools;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.ListIterator;

import javax.swing.JOptionPane;

public class ServerTools {

	public static void ServerSend(Socket socket) {

		String IP = socket.getInetAddress().getHostAddress();
		int port = 5555;

		try {
			Socket s = new Socket(IP, 5555);
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
			BufferedReader br = new BufferedReader(new FileReader("MessageRecord.txt"));
			String message = null;
			while ((message = br.readLine()) != null) {
				String[] str = message.split("=");
				String newMessage = str[0] + "  " + str[1] + "  " + str[2];
				bw.write(newMessage);
				bw.newLine();
				bw.flush();
			}
			br.close();
			bw.close();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "服务器发送数据失败！");
		}
	}

	public static void ServerSend(ArrayList<Socket> arraySocket) {

		try {
			ListIterator<Socket> it = arraySocket.listIterator();
			while (it.hasNext()) {
				Socket socket = it.next();
				Socket s = new Socket(socket.getInetAddress().getHostAddress(), 5555);
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
				BufferedReader br = new BufferedReader(new FileReader("MessageRecord.txt"));
				String message = null;
				while ((message = br.readLine()) != null) {
					String[] str = message.split("=");
					String newMessage = str[0] + "  " + str[1] + "  " + str[2];
					bw.write(newMessage);
					bw.newLine();
					bw.flush();
				}
				br.close();
				bw.close();
			}
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "服务器发送数据失败！");
		}

	}

}
