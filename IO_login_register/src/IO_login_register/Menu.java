package IO_login_register;

import java.util.Scanner;

public class Menu {
	
	public void menu() {
		
		System.out.println("------------��¼------------");
		System.out.println("|                          |");
		System.out.println("|         1. ע��                     | ");
		System.out.println("|                          |");
		System.out.println("|         2. ��¼                     | ");
		System.out.println("|                          |");
		System.out.println("|         3. �˳�                     | ");
		System.out.println("|                          |");
		System.out.println("-------��������ѡ����------");
		
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		
		switch(num) {
		
		case 1:menu1();break;
		case 2:menu2();break;
		case 3:System.exit(0);break;
		default:menu();break;
		}
	}

	private void menu2() {
		
		UserDaoImpl udi = new UserDaoImpl();
		Scanner sc = new Scanner(System.in);
		System.out.println("�������û�����");
		String username = sc.nextLine();
		System.out.println("�������û����룺");
		String password = sc.nextLine();
		if(udi.isLogin(username, password)) {
			System.out.println("��½�ɹ���");
			menu();
		}else {
			System.out.println("��½ʧ�ܣ����µ�¼��");
			menu();
		}
	}

	private void menu1() {
		
		UserDaoImpl udi = new UserDaoImpl();
		if(udi.register()) {
			System.out.println("ע��ɹ���");
			menu();
		}else {
			System.out.println("ע��ʧ�ܣ�");
			menu();
		}
		
	}
}
