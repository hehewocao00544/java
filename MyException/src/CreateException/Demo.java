package CreateException;

import java.util.Scanner;

public class Demo {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int sorce = sc.nextInt();

		Sorce s = new Sorce();

		try {
			s.check(sorce);
		} catch (SorceException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		
		System.out.println("hello,java!");
	}
}
