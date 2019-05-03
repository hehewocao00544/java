package cn.hehewocao.tool;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import cn.hehewocao.pojo.Book;
import cn.hehewocao.pojo.User;

public class StudentTools {

	public static ArrayList<User> fileReader(String filename) {

		ArrayList<User> array = new ArrayList<User>();

		try {
			BufferedReader br = new BufferedReader(new FileReader(filename));
			String info = null;
			while ((info = br.readLine()) != null) {
				String[] s = info.split("=");
				
				User user = new User(s[0], s[1]);
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
			bw.newLine();
			bw.close();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "文件写入失败！");
			return false;
		}
		return true;

	}

	//为了避免集合中泛型擦除问题，User类型数据用List集合保存
	public static boolean fileWrite(String filename, List<User> list) {

		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(filename));

			for (User user : list) {

				bw.write(user.getUsername());
				bw.write("=");
				bw.write(user.getPassword());
				bw.newLine();

			}
			bw.close();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "文件写入失败！");
			return false;
		}
		return true;
	}

	public static boolean fileWrite(String filename, Book s) {

		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(filename, true));
			bw.write(s.getBookname());
			bw.write("=");
			bw.write(s.getWriter());
			bw.write("=");
			bw.write(s.getId());
			bw.write("=");
			bw.write(s.getPress());
			bw.write("=");
			bw.write(s.getDate());
			bw.write("=");
			bw.write(String.valueOf(s.getPrice()));
			bw.write("=");
			bw.write(s.getType());
			bw.write("=");
			bw.write(String.valueOf(s.getNumber()));
			bw.newLine();
			bw.close();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "文件写入失败！");
			return false;
		}
		return true;
	}

	public static boolean fileWrite(String filename, ArrayList<Book> array) {

		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(filename));
			
			for(Book book : array) {
			
			bw.write(book.getBookname());
			bw.write("=");
			bw.write(book.getWriter());
			bw.write("=");
			bw.write(book.getId());
			bw.write("=");
			bw.write(book.getPress());
			bw.write("=");
			bw.write(book.getDate());
			bw.write("=");
			bw.write(String.valueOf(book.getPrice()));
			bw.write("=");
			bw.write(book.getType());
			bw.write("=");
			bw.write(String.valueOf(book.getNumber()));
			bw.newLine();
			}
			bw.close();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "文件写入失败！");
			return false;
		}
		return true;
	}

}
