package cn.hehewocao.tool;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import cn.hehewocao.pojo.Book;

public class BookTools {

	
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
}
