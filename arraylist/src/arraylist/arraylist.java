package arraylist;

import java.util.ArrayList;

public class arraylist {

    public static void main(String[] args) {

        ArrayList<Student> list = new ArrayList();
        Student stu1 = new Student("04182023", "李睿", 20);
        Student stu2 = new Student("04182020", "黄圻", 19);
        Student stu3 = new Student("04182019", "齐赞", 18);

        list.add(stu1);
        list.add(stu2);
        list.add(stu3);

        for (int i = 0; i < list.size(); i++) {
            Student stu = list.get(i);
            System.out.println("学号：" + stu.getXuehao() + " 姓名：" + stu.getName() + " 年龄：" + stu.getAge());
        }
    }
}
