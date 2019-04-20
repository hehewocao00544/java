package cn.hehewocao_02;

public class MyThread extends Thread {

	static int sum = 0;

	public void run() {

		while (sum < 100) {
			
				System.out.println(getName() + "正在售卖第" + (++sum) + "张票");
			
		}
		if(sum == 100){
			System.out.println(getName() + "票已售空！");
		}
	}

	public MyThread() {

	}

	public MyThread(String name) {
		super(name);
	}
}
