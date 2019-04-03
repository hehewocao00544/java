package InterfaceDemo;

//讲英语接口
interface Speak{
    public abstract void speak();
}
//定义人类
abstract class Person{
    private String name;
    private int age;
    
    public Person() {
        
    }
    
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getName() {
        return this.name;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
    
    public int getAge() {
        return this.age;
    }
    
    public void sleep() {
        System.out.println("睡觉");
    }
    
    public abstract void eat();
}
//定义抽象运动员类
abstract class Player extends Person {
    public Player() {
    }
    
    public Player(String name,int age) {
        super(name,age);
    }
    
    public abstract void learn();
}
//定义抽象教练类
abstract class Coach extends Person {
    public Coach() {
        
    }
    
    public Coach(String name, int age) {
        super(name,age);
    }
    
    public abstract void teach();
}
//定义乒乓球运动员实现讲英语的接口
class PingPangPlayer extends Player implements Speak{
    
    public PingPangPlayer() {
        
    }
    
    public PingPangPlayer(String name, int age) {
        super(name,age);
    }
    
    public void learn() {
        System.out.println("乒乓运动员学习接球和发球！");
    }
    
    public void eat() {
        System.out.println("乒乓运动员喝牛奶！");
    }
    
    public void speak() {
        System.out.println("乒乓运动员讲英语！");
    }
}
//定义乒乓球教练类实现讲英语接口
class PingPangCoach extends Coach implements Speak {
    public PingPangCoach() {
        
    }
    
    public PingPangCoach(String name, int age) {
        super(name,age);
    }
    
    public void teach() {
        System.out.println("乒乓球教练教接球和发球！");
    }
    
    public void eat() {
        System.out.println("乒乓球教练吃快餐！");
    }
    
    public void speak() {
        System.out.println("乒乓球教练讲英语！");
    }
}


public class Demo {
    public static void main(String[] args) {
        
        //通过具体类测试
        //乒乓球运动员
        PingPangPlayer ppp = new PingPangPlayer("张继科",28);
        System.out.println(ppp.getName() + '\t' + ppp.getAge());
        ppp.eat();
        ppp.learn();
        ppp.speak();
        System.out.println("-------------------");
        //乒乓球教练
        PingPangCoach ppc = new PingPangCoach("张国荣",41);
        System.out.println(ppc.getName() + '\t' + ppc.getAge());
        ppc.eat();
        ppc.teach();
        ppc.speak();
    }
}
