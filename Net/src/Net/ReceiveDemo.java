package Net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;


public class ReceiveDemo {

	public static void main(String[] args) throws IOException {
		
		//创建Socket对象,构造方法写入端口
		DatagramSocket ds = new DatagramSocket(10086);
		//创建数据包
		byte[] by = new byte[1024];
		int len = by.length;
		DatagramPacket dp = new DatagramPacket(by,len);
		
		//接收数据包
		ds.receive(dp);
		
		//解析数据包
		
		byte[] by2 = new byte[1024];
		
		by2 = dp.getData();
		int len2 = dp.getLength();

		String str = new String(by2,0,len2);
		
		System.out.println(str);
		//关闭流
		ds.close();
	}
}
