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
						// TODO �Զ����ɵ� catch ��
						System.out.println("��ʱʧ�ܣ�");
					}
					System.out.println(Thread.currentThread().getName() + "����������" + (++sum) + "��Ʊ!");
				}else {
					System.out.println(Thread.currentThread().getName() + "Ʊ���ۿգ�");
					break;
				}
			}
		}
	}
}
