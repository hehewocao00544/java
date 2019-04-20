package cn.hehewocao_02;

public class MyRunnable implements Runnable {

	private int sum = 0;
	private Object obj = new Object();

	public MyRunnable() {

	}

	public void run() {

		while (true) {
			synchronized (obj) {
				if (sum < 100) {
					try {
						Thread.sleep(200);
					} catch (InterruptedException e) {
						// TODO 自动生成的 catch 块
						System.out.println("延时失败！");
					}
					System.out.println(Thread.currentThread().getName() + "正在售卖第" + (++sum) + "张票!");
				}else {
					System.out.println(Thread.currentThread().getName() + "票已售空！");
					break;
				}
			}
		}
	}
}
