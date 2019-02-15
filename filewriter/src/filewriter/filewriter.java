/*
package filewriter;


import java.io.FileWriter;
import java.io.IOException;

public class filewriter {

    public static void main(String[] args) throws IOException {

        FileWriter fw = new FileWriter("hello.txt");
        
        fw.write("hello,world!");
        
        fw.close();

    }

}
*/

package filewriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class filewriter {
    
    public static void main(String[] args) throws IOException {

        ArrayList<Student> list = new ArrayList();
        Student stu1 = new Student("李睿",20);
        Student stu2 = new Student("黄圻",19);
        
        list.add(stu1);
        list.add(stu2);
        
        for(int i = 0; i < list.size(); i++ ) {
            System.out.println("姓名：" + list.get(i).getName() + " 年龄：" + list.get(i).getAge());
        }
        
        FileWriter fw = new FileWriter("Students.txt");
        
        for(int i = 0; i < list.size(); i++ ) {
        fw.write("姓名：");
        fw.write(list.get(i).getName());
        fw.write(" 年龄：");
        fw.write(list.get(i).getAge());
        fw.write("\n");
        }       
        
        fw.close();
    }
}

