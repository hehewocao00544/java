package filewriter;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.BufferedReader;

public class BufferedFileWriterAndBufferedFileReader {

    
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        Student stu1 = new Student("Jack",20);
        Student stu2 = new Student("Jane",18);
        
        ArrayList<Student> list = new ArrayList();
        
        list.add(stu1);
        list.add(stu2);
        
        FileWriter fw = new FileWriter("NewStudents.txt");
        BufferedWriter bw = new BufferedWriter(fw);
        
        for(int i = 0; i < list.size(); i++ ) {
            bw.write("姓名：");
            bw.write(list.get(i).getName());
            bw.write(" ");
            bw.write("年龄：");
            Integer num = new Integer(list.get(i).getAge());
            String str = num.toString();
            bw.write(str);
            bw.write(" ");
            bw.newLine();
        }
        
        bw.close();
        
        FileReader fr = new FileReader("NewStudents.txt");
        BufferedReader br = new BufferedReader(fr);
        String str;
        while((str = br.readLine()) != null){
            System.out.println(str);
        }
        br.close();
    }

}
