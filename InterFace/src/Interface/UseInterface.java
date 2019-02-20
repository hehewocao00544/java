package Interface;
import java.util.Scanner;

public class UseInterface {

    public static void main(String[] args) {
     
       Calculator cal = new calculatorimp();
       
       int a ,b;
       Scanner sc = new Scanner(System.in);
       System.out.println("输入第一个数：");
       a = sc.nextInt();
       System.out.println("输入第二个数：");
       b = sc.nextInt();
       
       int sum = cal.calSum(a, b);
       System.out.println("结果：" + sum);
        
    }

}
