package cn.hehewocao_02;

public class MyRunnable implements Runnable{

	private int sum = 0;
	
	public MyRunnable() {
		
	}
	
	public void run() {
		
		while(sum < 100) {
			System.out.println(Thread.currentThread().getName() + "����������" + (++sum) + "��Ʊ!");
		}
		System.out.println(Thread.currentThread().getName() + "���ۿգ�");
	}
}
