package IO_login_register;

import java.util.Scanner;

public class Menu {
	
	public void menu() {
		
		System.out.println("------------登录------------");
		System.out.println("|                          |");
		System.out.println("|         1. 注册                     | ");
		System.out.println("|                          |");
		System.out.println("|         2. 登录                     | ");
		System.out.println("|                          |");
		System.out.println("|         3. 退出                     | ");
		System.out.println("|                          |");
		System.out.println("-------输入数字选择功能------");
		
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
		System.out.println("请输入用户名：");
		String username = sc.nextLine();
		System.out.println("请输入用户密码：");
		String password = sc.nextLine();
		if(udi.isLogin(username, password)) {
			System.out.println("登陆成功！");
			menu();
		}else {
			System.out.println("登陆失败！重新登录！");
			menu();
		}
	}

	private void menu1() {
		
		UserDaoImpl udi = new UserDaoImpl();
		if(udi.register()) {
			System.out.println("注册成功！");
			menu();
		}else {
			System.out.println("注册失败！");
			menu();
		}
		
	}
}
