package CatAndDogDemo;
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
