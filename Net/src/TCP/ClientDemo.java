package TCP;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

import javax.swing.JOptionPane;

public class ClientDemo {
	
	public static void main(String[] args) throws IOException, IOException {
		
		//����Socket���󣬹涨Ҫ���ӵķ�������IP��ַ���˿�
		Socket s = new Socket(InetAddress.getByName("DESKTOP-ADGKT4E"),8848);
		
		//�������ݣ�ͨ���������������
		
		JOptionPane pane = new JOptionPane();
		String str = pane.showInputDialog(null,"�������ݣ�","input",pane.QUESTION_MESSAGE);
		byte[] byt = str.getBytes();
		
		OutputStream os = s.getOutputStream();
		os.write(byt);
		
		//�ر���
		s.close();
	}
}
