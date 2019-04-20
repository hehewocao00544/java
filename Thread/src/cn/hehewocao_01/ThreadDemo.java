package cn.hehewocao_01;

public class ThreadDemo extends Thread {

	public static void main(String[] args) {
		
		ThreadDemo t1 = new ThreadDemo();
		ThreadDemo t2 = new ThreadDemo();
		
		t1.start();
		t2.start();
	}
	
	public void run() {
		
		for(int i = 0; i < 100; i++) {
			System.out.println(getName() + "---" +i);
		}
	}
}
