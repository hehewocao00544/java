package cn.hehewocao_02;

public class MyThreadDemo {

	public static void main(String[] args) {
		
		
		MyThread my1 = new MyThread("һ�Ŵ���");
		MyThread my2 = new MyThread("���Ŵ���");
		MyThread my3 = new MyThread("���Ŵ���");
		
		my1.start();
		my2.start();
		my3.start();
		
	}
}
