package Search;

import javax.swing.JOptionPane;

public class Demo {

	public static void main(String[] args) {
		
		JOptionPane pane = new JOptionPane();
		String path = pane.showInputDialog(null,"�������ѯ·����","Input",pane.QUESTION_MESSAGE);
		String type = pane.showInputDialog(null,"�������ѯ�ļ��ĺ�׺����Сд����","Input",pane.QUESTION_MESSAGE);
		Search s = new Search(path,type);
		s.searchFile(path);
	}
}
