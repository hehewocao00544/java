package cn.hehewocao_ServerTools;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Vector;

import javax.swing.JOptionPane;

import cn.hehewocao_Server.ServerAcceptThread;
import cn.hehewocao_User.UserThread;
import cn.hehewocao_Windows.WindowServer;

public class ServerTools {

	public static void ServerSendMessage(ArrayList<Socket> arraySocket) {

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

					String newMessage = null;
					try {
						newMessage = str[0] + "  " + str[2];
					} catch (Exception e) {
						ServerAcceptThread.arraySocket.remove(s);
						UserThread ut1 = new UserThread(ServerAcceptThread.arraySocket);
						Thread t1 = new Thread(ut1);
						t1.start();
						return;
					}
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

	// 服务器发送连接信息
	public static void ServerSendLink(ArrayList<Socket> arraySocket) {

		try {
			ListIterator<Socket> it = arraySocket.listIterator();
			while (it.hasNext()) {
				Socket socket = it.next();
				Socket s = new Socket(socket.getInetAddress().getHostAddress(), 1111);
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));

				// 获取table内的数据
				ArrayList<String> array = new ArrayList<String>();

				for (int i = 0; i < WindowServer.table.getRowCount(); i++) {
					String info = null;
					for (int j = 0; j < 4; j++) {
						if (info == null) {
							info = (String) WindowServer.table.getValueAt(i, j);
						} else {
							info = info + "=" + (String) WindowServer.table.getValueAt(i, j);
						}
					}
					array.add(info);
				}
				// 发送数据
				ListIterator<String> Lit = array.listIterator();
				while (Lit.hasNext()) {
					bw.write(Lit.next());
					bw.newLine();
					bw.flush();
				}
				
			}

		} catch (IOException e) {
			// JOptionPane.showMessageDialog(null, "服务器发送连接数据失败！");
			e.printStackTrace();
		}

	}

}
