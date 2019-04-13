package TCP;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JOptionPane;

public class ServeDemo {

	public static void main(String[] args) throws IOException {

		// ����ServerSocket����ָ���˿�
		ServerSocket ss = new ServerSocket(8848);

		// �������������������ͻ�������,����Socket����
		while (true) {
			Socket s = ss.accept();

			// �������������󣬶�ȡ��������
			InputStream is = s.getInputStream();

			byte[] byt = new byte[1024];

			int len = is.read(byt);

			// ��ʾ����
			String str = new String(byt, 0, len);

			JOptionPane pane = new JOptionPane();
			pane.showMessageDialog(null, "�յ������ݣ�" + str, "����", pane.INFORMATION_MESSAGE);

			// �ر���
			s.close();
		}
	}
}
