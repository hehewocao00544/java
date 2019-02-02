/*
1.导包：
import java.util.Scanner;

2.创建：
格式：数据类型 变量名 = new 数据类型();
代码：Scanner sc = new Scanner(System.in);

3.使用：
从键盘输入一个int整数
int num = sc.nextInt();

 */
/*import java.util.Scanner;
public class scanner {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        System.out.println(num);
    }
}*/

//从键盘输入一个字符串；
import java.util.Scanner;
public class scanner{
    public static void main(String[] args){
        Scanner str = new Scanner(System.in);
        String a = str.next();
        System.out.println("结果：" + a);
    }
}
