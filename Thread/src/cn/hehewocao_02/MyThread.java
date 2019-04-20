package cn.hehewocao_02;

public class MyThread extends Thread {

	static int sum = 0;

	private Object obj = new Object();

	public void run() {

		while(true) {
			
			synchronized(obj) {
				if (sum < 100) {
					System.out.println(getName() + "正在售卖第" + (++sum) + "张票!");
				}else {
					System.out.println(getName() + "票已售空！");
					break;
				}
				
			}
		}

	}

	public MyThread() {

	}

	public MyThread(String name) {
		super(name);
	}
}
