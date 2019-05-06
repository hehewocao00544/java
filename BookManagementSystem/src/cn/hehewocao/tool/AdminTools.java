package cn.hehewocao.tool;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import cn.hehewocao.pojo.Admin;



public class AdminTools {

	public static Admin fileReader(String filename) {
		
			try {
				BufferedReader br = new BufferedReader(new FileReader(filename));
				String info = null;
				while ((info = br.readLine()) != null) {
					String[] s = info.split("=");
					return  new Admin(s[0], s[1]);
				}
				br.close();
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, "文件读取失败！");
			}
			return null;
	}
	
	public static boolean fileWriter(String filename,Admin admin) {
		
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(filename));
			bw.write(admin.getUsername());
			bw.write("=");
			bw.write(admin.getPassword());
			bw.close();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "文件写入失败！");
		}
		
		
		return true;
	}
}
