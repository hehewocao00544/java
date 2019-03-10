package CircleInherit;
import javax.swing.JOptionPane;

public class InvokeDemo {
    public static void main(String[] args) {
        Cylinder cir = new Cylinder();
        JOptionPane pane = new JOptionPane();
        String str = pane.showInputDialog(null,"Enter a Double number for radius : ","Input window",pane.QUESTION_MESSAGE);
        double radius = Double.parseDouble(str);
        cir.setRadius(radius);
        String str1 = pane.showInputDialog(null,"Enter a Double number for length : ","Input window",pane.QUESTION_MESSAGE);
        double length = Double.parseDouble(str1);
        cir.setLength(length);       
        pane.showMessageDialog(null, "圆柱体底面积为：" + cir.findCircleArea() + '\n' + "圆柱体的体积为：" + cir.findCylinderArea(),"Resulat window",pane.INFORMATION_MESSAGE);  
    }
}
