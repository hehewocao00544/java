package Net;

import java.io.IOException;
import java.net.*;

public class SendDemo {
	
	public static void main(String[] args) throws SocketException, IOException {
		
		//创建 Socket对象
		DatagramSocket ds = new DatagramSocket();
		
		//创建数据，并打包
		
		byte[] by = "Hello! I am comming!".getBytes();
		int len = by.length;
		int port = 10086;//端口
		InetAddress ip = InetAddress.getByName("DESKTOP-ADGKT4E");
		
		DatagramPacket dp = new DatagramPacket(by,len,ip,port);
		
		//发送
		ds.send(dp);
		
		//关闭流
		ds.close();
	}
}
