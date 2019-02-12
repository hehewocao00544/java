package pojo;

public class pojo {

    
    public static void main(String[] args) {
        
        //
        Student stu1 = new Student();
        stu1.setXuehao("04182023");
        stu1.setName("李睿");
        stu1.setAge(20);
        System.out.println(stu1.getXuehao() + " " + stu1.getName() + " " + stu1.getAge());
        //
        Student stu2 = new Student("04182020","黄圻",19);
        System.out.println(stu2.getXuehao() + " " + stu2.getName() + " " + stu2.getAge());
    }

}
