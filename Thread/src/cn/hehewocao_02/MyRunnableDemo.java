package cn.hehewocao_02;

public class MyRunnableDemo {

	public static void main(String[] args) {
		
		MyRunnable my = new MyRunnable();
		
		Thread t1 = new Thread(my,"һ�Ŵ���");
		Thread t2 = new Thread(my,"���Ŵ���");
		Thread t3 = new Thread(my,"���Ŵ���");
		
		t1.start();
		t2.start();
		t3.start();

	}
}
