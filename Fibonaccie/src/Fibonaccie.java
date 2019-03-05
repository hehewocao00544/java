/*import java.util.Scanner;

public class Fibonaccie {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("输入第n项：");
        int num = sc.nextInt();
        System.out.println(fib(num));
    }
    public static int fib(int i){
        if(i==1||i==2){
            return 1;
        }
        else if(i>2){
            return fib(i-1)+fib(i-2);
        }
        else{
            return -1;
        }
    }
}
*/
import javax.swing.JOptionPane;
public class Fibonaccie {
    
    public static void main(String[] args) {
        
        
        String str = JOptionPane.showInputDialog(null,"Enter an input","Input Dialog　Demo",JOptionPane.QUESTION_MESSAGE);
        int num = Integer.parseInt(str);
        System.out.println(fib(num));
    }
    public static int fib(int i){
        if(i==1||i==2){
            return 1;
        }
        else if(i>2){
            return fib(i-1)+fib(i-2);
        }
        else{
            return -1;
        }
    }
}
