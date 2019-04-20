package cn.hehewocao_02;

public class MyThreadDemo {

	public static void main(String[] args) {
		
		
		MyThread my1 = new MyThread("一号窗口");
		MyThread my2 = new MyThread("二号窗口");
		MyThread my3 = new MyThread("三号窗口");
		
		my1.start();
		my2.start();
		my3.start();
		
	}
}
