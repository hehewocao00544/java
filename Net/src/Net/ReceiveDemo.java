package Net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;


public class ReceiveDemo {

	public static void main(String[] args) throws IOException {
		
		//����Socket����,���췽��д��˿�
		DatagramSocket ds = new DatagramSocket(10086);
		//�������ݰ�
		byte[] by = new byte[1024];
		int len = by.length;
		DatagramPacket dp = new DatagramPacket(by,len);
		
		//�������ݰ�
		ds.receive(dp);
		
		//�������ݰ�
		
		byte[] by2 = new byte[1024];
		
		by2 = dp.getData();
		int len2 = dp.getLength();

		String str = new String(by2,0,len2);
		
		System.out.println(str);
		//�ر���
		ds.close();
	}
}
