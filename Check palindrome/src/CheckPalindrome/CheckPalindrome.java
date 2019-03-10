package CheckPalindrome;
import javax.swing.JOptionPane;

public class CheckPalindrome {
    public static void main(String[] args) {
        
        String str = input();
        Check(str);
    }
    
    public static String input() {
        
        JOptionPane pane = new JOptionPane();
        String str = pane.showInputDialog(null,"please input a string data : ","Input Demo",pane.QUESTION_MESSAGE);
        return str;
    }
    
    public static void Check(String str) {
        int len = str.length();
        int sum = 0; // 计数器
        for(int i = 0; i < len/2; i++) {
            if(str.charAt(i) == str.charAt(len - 1 - i)) {
                sum++;
            }
        }
        if(sum == len/2) {
            JOptionPane pane = new JOptionPane();
            pane.showMessageDialog(null,"这是一个回文字符串！","Output",pane.INFORMATION_MESSAGE);
        }else {
            JOptionPane pane = new JOptionPane();
            pane.showMessageDialog(null,"这不是一个回文字符串！","Output",pane.INFORMATION_MESSAGE);
        }
    }
}
