package CircleArea;

class Circle {
    private double r;
    double area;

    public void setCircle(double r) {
        this.r = r;
        this.area = 3.14 * r * r;
    }

    public double getCircle() {
        return r;
    }
}

public class CircleAreaDemo {
    public static void main(String[] args) {
        Circle[] CircleArray = CircleArrayCreate();// 注意：类数组的每一个元素都是一个对象，需要分配内存后才能使用！
        PrintCircleArrayR(CircleArray);
        PrintCircleArrayArea(CircleArray);
    }

    // 创建一个Circle对象数组
    public static Circle[] CircleArrayCreate() {

        Circle[] CircleArray = new Circle[10];

        for (int i = 0; i < CircleArray.length; i++) {
            CircleArray[i] = new Circle();
            CircleArray[i].setCircle(Math.random()*100);
        }
        return CircleArray;
    }

    // 计算Circle对象数组中，所有面积之和
    public static double CircleArraySum(Circle[] CircleArray) {
        double sum = 0;
        for (int i = 0; i < CircleArray.length; i++) {
            sum += CircleArray[i].area;
        }
        return sum;
    }

    // 输出每一个圆对象的面积,和所有圆面积之和：
    public static void PrintCircleArrayArea(Circle[] CircleArray) {
        System.out.println("圆面积分别是：");
        for (int i = 0; i < CircleArray.length; i++) {
            System.out.println(CircleArray[i].area);
        }
        System.out.println("所有圆面积之和是：");
        double sum = CircleArraySum(CircleArray);
        System.out.println(sum);
    }
    
    public static void PrintCircleArrayR(Circle[] CircleArray) {
        System.out.println("圆半径分别是：");
        for (int i = 0; i < CircleArray.length; i++) {
            System.out.println(CircleArray[i].getCircle());
        }
    }
}
