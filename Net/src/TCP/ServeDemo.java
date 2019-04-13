package TCP;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JOptionPane;

public class ServeDemo {

	public static void main(String[] args) throws IOException {

		// 创建ServerSocket对象，指定端口
		ServerSocket ss = new ServerSocket(8848);

		// 服务器监听器，监听客户端连接,返回Socket对象
		while (true) {
			Socket s = ss.accept();

			// 创建输入流对象，读取数据内容
			InputStream is = s.getInputStream();

			byte[] byt = new byte[1024];

			int len = is.read(byt);

			// 显示内容
			String str = new String(byt, 0, len);

			JOptionPane pane = new JOptionPane();
			pane.showMessageDialog(null, "收到的数据：" + str, "接收", pane.INFORMATION_MESSAGE);

			// 关闭流
			s.close();
		}
	}
}
