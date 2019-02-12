package pojo;

public class Student {

    private String xuehao;
    private String name;
    private int age;
    
    public Student(){
    }
    
    public Student(String xuehao,String name,int age){
        this.xuehao = xuehao;
        this.name = name;
        this.age = age;
    }
    
    public void setXuehao(String xuehao){
        this.xuehao = xuehao;
    }
    
    public String getXuehao(){
        return this.xuehao;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public String getName(){
        return this.name;
    }
    
    public void setAge(int age){
        this.age = age;
    }
    
    public int getAge(){
        return this.age;
    }
}
