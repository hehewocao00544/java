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

		// 创建指定目录的文件对象
		File file1 = new File(path);
		// 获取该目录下的所有文件对象
		File[] file = file1.listFiles();
		
		try {
		for (int i = 0; i < file.length; i++) {

			// 如果不是，就进行判断
			if (file[i].isFile()) {
				
				if (file[i].getName().lastIndexOf('.' + type) != -1) {
					System.out.println("路径：" + file[i].getAbsolutePath() + "   " +"文件名："+ file[i].getName());
				}
			} 
			// 如果是文件夹，就获取下一级的目录的所有文件对象
			else {
				String path2 = path + '\\' + file[i].getName();
				searchFile(path2);
			}
		}
		}catch(Exception e){
			System.out.println("不能查询存在特殊文件的路径！此处存在特殊类型的文件！");
		}
	}
}
