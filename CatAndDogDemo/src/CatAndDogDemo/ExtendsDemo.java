package CatAndDogDemo;

//猫狗案例：体现继承
/*
import javax.swing.JOptionPane;

class Animal{
    private String name;
    private int age;
    
    public Animal() {
        
    }
    
    public Animal(String name,int age) {
        this.name = name;
        this.age = age;
    }
    
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getName()
    {
        return this.name;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
    
    public int getAge() {
        return this.age;
    }
}

class Cat extends Animal{
    public Cat() {
        
    }
    
    public Cat(String name,int age) {
        super(name,age);
    }
    
    public void Play() {
        JOptionPane pane = new JOptionPane();
        pane.showMessageDialog(null,"猫玩毛线","Information",pane.INFORMATION_MESSAGE);
    }
}

class Dog extends Animal{
    
    public Dog() {
        
    }
    
    public Dog(String name,int age) {
        super(name,age);
    }
    
    public void LookDoor() {
        JOptionPane pane = new JOptionPane();
        pane.showMessageDialog(null,"狗看门","Information",pane.INFORMATION_MESSAGE);
    }
}

public class ExtendsDemo {
    public static void main(String[] args) {
        Cat c = new Cat("Tom",3);
        System.out.println(c.getName() + "\t" + c.getAge() + "\t");
        c.Play();
        Dog d = new Dog("Pike",5);
        System.out.println(d.getName() + "\t" + d.getAge() + "\t");
        d.LookDoor();
    }
}
*/

import javax.swing.JOptionPane;
//猫狗案例：继承、多态，抽象方法
//抽象的动物类
abstract class Animal{  
    private String name;
    private int age;
    
    public Animal() {
        
    }
    
    public Animal(String name,int age) {
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
    
    public abstract void eat();
    
    public void sleep() {
       JOptionPane pane = new JOptionPane();
       pane.showMessageDialog(null, "睡觉=.=","output",pane.INFORMATION_MESSAGE);
    }
}

class Cat extends Animal {
    public Cat() {
        
    }
    
    public Cat(String name,int age) {
        super(name,age);
    }
    
    public void eat() {
        JOptionPane pane = new JOptionPane();
        pane.showMessageDialog(null,"猫吃鱼","input",pane.INFORMATION_MESSAGE);
    }
    
    public void playGame() {
        JOptionPane pane = new JOptionPane();
        pane.showMessageDialog(null,"猫玩毛线","input",pane.INFORMATION_MESSAGE);
    }
}

class Dog extends Animal {
    public Dog() {
        
    }
    
    public Dog(String name,int age) {
        super(name,age);
    }
    
    public void eat() {
       JOptionPane pane = new JOptionPane();
       pane.showMessageDialog(null, "狗啃骨头","input",pane.INFORMATION_MESSAGE);
    }
}

public class ExtendsDemo {
    public static void main(String[] args) {
        //多态测试：(为了能通用编程)
        Animal an = new Cat("Tom",3);
        System.out.println(an.getName()+'\t'+an.getAge());
        an.eat();
        an.sleep();
        System.out.println("-----------");
        Cat c = (Cat)an;
        c.playGame();
        System.out.println("-----------");
        Animal an2 = new Dog("Pick",5);
        System.out.println(an2.getName()+'\t'+an2.getAge());
        an2.eat();
        an2.sleep();
    }
}







