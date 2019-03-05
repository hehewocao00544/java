package OO;
//面向过程与面向对象
class In {
    
    public void open() {
        System.out.println("打开冰箱");
    }
    
    public void in() {
        System.out.println("把大象放进冰箱");
    }
    
    public void close() {
        System.out.println("关闭冰箱门");
    }
}

public class InDemo {
    
    public static void main(String[] args) {
        //创建对象，调用方法！
        In men = new In();
        men.open();
        men.in();
        men.close();
    }
}
