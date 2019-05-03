package cn.hehewocao.tool;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import cn.hehewocao.pojo.Admin;



public class AdminTools {

	public static ArrayList<Admin> fileReader(String filename) {

		ArrayList<Admin> array = new ArrayList<Admin>();

		try {
			BufferedReader br = new BufferedReader(new FileReader(filename));
			String info = null;
			while ((info = br.readLine()) != null) {
				String[] s = info.split("=");
				
				Admin admin = new Admin(s[0], s[1]);
				array.add(admin);
			}
			br.close();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "ÎÄ¼þ¶ÁÈ¡Ê§°Ü£¡");
		}
		return array;
	}
}
