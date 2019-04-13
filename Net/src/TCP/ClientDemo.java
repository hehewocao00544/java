package TCP;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

import javax.swing.JOptionPane;

public class ClientDemo {
	
	public static void main(String[] args) throws IOException, IOException {
		
		//创建Socket对象，规定要连接的服务器的IP地址及端口
		Socket s = new Socket(InetAddress.getByName("DESKTOP-ADGKT4E"),8848);
		
		//创建数据，通过输出流传输数据
		
		JOptionPane pane = new JOptionPane();
		String str = pane.showInputDialog(null,"输入数据：","input",pane.QUESTION_MESSAGE);
		byte[] byt = str.getBytes();
		
		OutputStream os = s.getOutputStream();
		os.write(byt);
		
		//关闭流
		s.close();
	}
}
