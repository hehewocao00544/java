package Search;

import javax.swing.JOptionPane;

public class Demo {

	public static void main(String[] args) {
		
		JOptionPane pane = new JOptionPane();
		String path = pane.showInputDialog(null,"请输入查询路径：","Input",pane.QUESTION_MESSAGE);
		String type = pane.showInputDialog(null,"请输入查询文件的后缀名（小写）：","Input",pane.QUESTION_MESSAGE);
		Search s = new Search(path,type);
		s.searchFile(path);
	}
}
