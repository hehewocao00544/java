package cn.hehewocao_02;

public class MyThread extends Thread {

	static int sum = 0;

	public void run() {

		while (sum < 100) {
			
				System.out.println(getName() + "����������" + (++sum) + "��Ʊ");
			
		}
		if(sum == 100){
			System.out.println(getName() + "Ʊ���ۿգ�");
		}
	}

	public MyThread() {

	}

	public MyThread(String name) {
		super(name);
	}
}
