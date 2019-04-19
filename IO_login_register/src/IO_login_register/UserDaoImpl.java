package IO_login_register;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class UserDaoImpl implements UserDao {

	

	public UserDaoImpl() {

	}

	public boolean isLogin(String username, String password) {

		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("users.txt"));

			String str = null;
			try {
				while ((str = br.readLine()) != null) {
					String[] us = str.split("=");
					if (us[0].equals(username) && us[1].equals(password)) {
						return true;
					}
				}
			} catch (IOException e) {
				System.out.println("��ȡʧ�ܣ�");
			} finally {
				if (br != null) {
					try {
						br.close();
					} catch (IOException e) {
						System.out.println("�ļ��ر�ʧ�ܣ�");
					}
				}
			}

		} catch (FileNotFoundException e) {
			System.out.println("�ļ���ȡʧ��!");
		}
		
		return false;
	}

	public boolean register() {

		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new FileWriter("users.txt",true));
			Scanner sc = new Scanner(System.in);
			System.out.println("�������û�����");
			String username = sc.nextLine();
			System.out.println("�������û����룺");
			String password = sc.nextLine();
			bw.write(username + "=" + password);
			bw.newLine();
			bw.flush();
		} catch (IOException e) {
			System.out.println("�����ļ�ʧ�ܣ�");
			return false;
		} finally {
			if (bw != null) {
				try {
					bw.close();
				} catch (IOException e) {
					System.out.println("�ļ��ر�ʧ�ܣ�");
				}
			}
		}
		return true;

	}

}
