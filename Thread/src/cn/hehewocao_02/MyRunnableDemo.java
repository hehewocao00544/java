package cn.hehewocao_02;

public class MyRunnableDemo {

	public static void main(String[] args) {
		
		MyRunnable my = new MyRunnable();
		
		Thread t1 = new Thread(my,"一号窗口");
		Thread t2 = new Thread(my,"二号窗口");
		Thread t3 = new Thread(my,"三号窗口");
		
		t1.start();
		t2.start();
		t3.start();

	}
}
