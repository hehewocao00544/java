package Net;

import java.io.IOException;
import java.net.*;

public class SendDemo {
	
	public static void main(String[] args) throws SocketException, IOException {
		
		//���� Socket����
		DatagramSocket ds = new DatagramSocket();
		
		//�������ݣ������
		
		byte[] by = "Hello! I am comming!".getBytes();
		int len = by.length;
		int port = 10086;//�˿�
		InetAddress ip = InetAddress.getByName("DESKTOP-ADGKT4E");
		
		DatagramPacket dp = new DatagramPacket(by,len,ip,port);
		
		//����
		ds.send(dp);
		
		//�ر���
		ds.close();
	}
}
