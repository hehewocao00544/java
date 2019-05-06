package cn.hehewocao.tool;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

import cn.hehewocao.pojo.User;

public class UserTools {

	public static ArrayList<User> fileReader(String filename) {

		ArrayList<User> array = new ArrayList<User>();

		try {
			BufferedReader br = new BufferedReader(new FileReader(filename));
			String info = null;
			while ((info = br.readLine()) != null) {
				String[] s = info.split("=");

				User user = new User(s[0], s[1], s[2]);
				array.add(user);
			}
			br.close();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "文件读取失败！");
		}
		return array;
	}

	public static boolean fileWrite(String filename, User user) {

		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(filename, true));
			bw.write(user.getUsername());
			bw.write("=");
			bw.write(user.getPassword());
			bw.write("=");
			bw.write(user.getPhone());
			bw.newLine();
			bw.close();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "文件写入失败！");
			return false;
		}
		return true;

	}

	public static boolean fileWrite(String filename, ArrayList<User> array) {

		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(filename));

			for (User user : array) {

				bw.write(user.getUsername());
				bw.write("=");
				bw.write(user.getPassword());
				bw.write("=");
				bw.write(user.getPhone());
				bw.newLine();

			}
			bw.close();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "文件写入失败！");
			return false;
		}
		return true;
	}

	public static User checkUsername(String name) {

		ArrayList<User> array = UserTools.fileReader("Users.txt");

		for (User user : array) {

			if (user.getUsername().equals(name)) {

				return user;
			}
		}

		return null;
	}

	public static User checkPhone(String phone) {

		ArrayList<User> array = UserTools.fileReader("Users.txt");

		for (User user : array) {

			if (user.getPhone().equals(phone)) {

				return user;
			}
		}

		return null;
	}
	
	public static ArrayList<User> checkUsernameFuzzy(String username){
		
		ArrayList<User> array = UserTools.fileReader("Users.txt");
		ArrayList<User> newArray = new ArrayList<User>();
		for (User user : array) {
			
			//相似度在0.5以上
			if (Fuzzy.levenshtein(user.getUsername(), username) >= 0.5) {
				newArray.add(user);
			}
		}
		
		return newArray;
	}
	
	public static boolean delAccount(User user) {
		
		
		
		
		
		return true;
	}
}
