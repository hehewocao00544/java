package InterfaceLambda;

import java.util.Scanner;

public class use {

    public static void main(String[] args) {
       
       method( (int a,int b) -> {return a + b;});
    }

    public static void method(Calculator cal) {
        int a, b;
        Scanner sc = new Scanner(System.in);
        System.out.println("输入第一个数：");
        a = sc.nextInt();
        System.out.println("输入第二个数：");
        b = sc.nextInt();
        int num = cal.sum(a, b);
        System.out.println("结果：" + num);
    }
}
