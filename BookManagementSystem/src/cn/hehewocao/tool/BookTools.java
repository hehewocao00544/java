package cn.hehewocao.tool;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.ListIterator;

import javax.swing.JOptionPane;

import cn.hehewocao.pojo.Book;

public class BookTools {

	public static boolean fileWrite(String filename, ArrayList<Book> array) {

		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(filename));

			for (Book s : array) {

				bw.write(s.getId());
				bw.write("=");
				bw.write(s.getBookname());
				bw.write("=");
				bw.write(s.getWriter());
				bw.write("=");
				bw.write(s.getType());
				bw.write("=");
				bw.write(s.getPress());
				bw.write("=");
				bw.write(s.getDate());
				bw.write("=");
				bw.write(String.valueOf(s.getPrice()));
				bw.write("=");
				bw.write(String.valueOf(s.getNumber()));
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

			bw.write(s.getId());
			bw.write("=");
			bw.write(s.getBookname());
			bw.write("=");
			bw.write(s.getWriter());
			bw.write("=");
			bw.write(s.getType());
			bw.write("=");
			bw.write(s.getPress());
			bw.write("=");
			bw.write(s.getDate());
			bw.write("=");
			bw.write(String.valueOf(s.getPrice()));
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

	public static ArrayList<Book> fileReader(String filename) {

		ArrayList<Book> array = new ArrayList<Book>();

		try {
			BufferedReader br = new BufferedReader(new FileReader(filename));
			String info = null;
			while ((info = br.readLine()) != null) {
				String[] s = info.split("=");

				Book book = new Book(s[0], s[1], s[2], s[3], s[4], s[5], Float.parseFloat(s[6]),
						Integer.parseInt(s[7]));

				array.add(book);
			}
			br.close();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "文件读取失败！");
		}
		return array;
	}

	public static boolean duplicatechecking(String id) {

		ArrayList<Book> array = BookTools.fileReader("bookinformation.txt");

		for (Book book : array) {

			if (book.getId().equals(id)) {
				return true;
			}
		}

		return false;
	}

	public static Book checkBookId(String id) {

		ArrayList<Book> array = BookTools.fileReader("bookinformation.txt");

		for (Book book : array) {

			if (book.getId().equals(id)) {
				return book;
			}
		}

		return null;
	}

	public static ArrayList<Book> checkBookName(String bookname) {
		int flag = 0;
		ArrayList<Book> array = BookTools.fileReader("bookinformation.txt");

		ArrayList<Book> newArray = new ArrayList<Book>();

		for (Book book : array) {

			if (book.getBookname().equals(bookname)) {
				flag = 1;
				newArray.add(book);
			}
		}

		if (flag == 1) {
			return newArray;
		} else {
			return null;
		}
	}

	public static ArrayList<Book> checkBookWriter(String writer) {
		int flag = 0;
		ArrayList<Book> array = BookTools.fileReader("bookinformation.txt");

		ArrayList<Book> newArray = new ArrayList<Book>();

		for (Book book : array) {

			if (book.getWriter().equals(writer)) {
				flag = 1;
				newArray.add(book);
			}
		}

		if (flag == 1) {
			return newArray;
		} else {
			return null;
		}

	}

	public static ArrayList<Book> checkBookNameFuzzy(String bookname) {
		int flag = 0;
		ArrayList<Book> array = BookTools.fileReader("bookinformation.txt");
		ArrayList<Book> newArray = new ArrayList<Book>();

		for (Book book : array) {

			if (Fuzzy.levenshtein(book.getBookname(), bookname) >= 0.5) {
				flag = 1;
				newArray.add(book);
			}
		}
		if (flag == 1) {
			return newArray;
		} else {
			return null;
		}
	}

	public static ArrayList<Book> checkBookWriterFuzzy(String writer) {

		int flag = 0;
		ArrayList<Book> array = BookTools.fileReader("bookinformation.txt");
		ArrayList<Book> newArray = new ArrayList<Book>();

		for (Book book : array) {

			if (Fuzzy.levenshtein(book.getWriter(), writer) >= 0.5) {
				flag = 1;
				newArray.add(book);
			}
		}
		if (flag == 1) {
			return newArray;
		} else {
			return null;
		}
	}
	
	public static boolean delBookId(String id) {
		
		int flag = 0;
		ArrayList<Book> array = BookTools.fileReader("bookinformation.txt");
		
		ListIterator<Book> it = array.listIterator();
		
		while(it.hasNext()) {
			
			if(it.next().getId().equals(id)) {
				flag = 1;
				it.remove();
			}
		}
		
		if(flag == 1) {
			
			BookTools.fileWrite("bookinformation.txt", array);
		}
	
		return true;
	}
}
