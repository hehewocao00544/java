package cn.hehewocao_User;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;



public class UserTools {

	public static ArrayList<User> fileReader(String filename) {

		ArrayList<User> array = new ArrayList<User>();

		try {
			BufferedReader br = new BufferedReader(new FileReader(filename));
			String info = null;
			while ((info = br.readLine()) != null) {
				String[] s = info.split("=");
				User user = new User(s[1], s[2]);
				array.add(user);
			}
			br.close();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "用户文件读取失败！");
			return null;
		}
		return array;
	}
}
