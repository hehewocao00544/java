package cn.hehewocao_02;

public class MyThread extends Thread {

	static int sum = 0;

	private Object obj = new Object();

	public void run() {

		while(true) {
			
			synchronized(obj) {
				if (sum < 100) {
					System.out.println(getName() + "����������" + (++sum) + "��Ʊ!");
				}else {
					System.out.println(getName() + "Ʊ���ۿգ�");
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
