package Search;

import java.io.File;

public class Search {

	private String path;
	private String type;

	public Search() {

	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Search(String path, String type) {
		this.path = path;
		this.type = type;
	}

	public void searchFile(String path) {

		// ����ָ��Ŀ¼���ļ�����
		File file1 = new File(path);
		// ��ȡ��Ŀ¼�µ������ļ�����
		File[] file = file1.listFiles();
		
		try {
		for (int i = 0; i < file.length; i++) {

			// ������ǣ��ͽ����ж�
			if (file[i].isFile()) {
				
				if (file[i].getName().lastIndexOf('.' + type) != -1) {
					System.out.println("·����" + file[i].getAbsolutePath() + "   " +"�ļ�����"+ file[i].getName());
				}
			} 
			// ������ļ��У��ͻ�ȡ��һ����Ŀ¼�������ļ�����
			else {
				String path2 = path + '\\' + file[i].getName();
				searchFile(path2);
			}
		}
		}catch(Exception e){
			System.out.println("���ܲ�ѯ���������ļ���·�����˴������������͵��ļ���");
		}
	}
}
