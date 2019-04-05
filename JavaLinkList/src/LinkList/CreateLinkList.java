package LinkList;

import javax.swing.JOptionPane;

public class CreateLinkList {
    public Node createLinkList(Node head) {
        Node p = new Node();
        JOptionPane pane = new JOptionPane();
        String str = pane.showInputDialog(null, "请输入链表长度：", "input",pane.QUESTION_MESSAGE);
        int len = Integer.parseInt(str);
        for (int i = 0; i < len; i++) {
            Node s = new Node();
            String st = pane.showInputDialog(null, "请输入数据：", "input",pane.QUESTION_MESSAGE);
            s.setData(Integer.parseInt(st));
            if(i==0) {
                head.next = s;
                s.next = null;
                p = s;
            }
            else {
                p.next = s;
                s.next = null;
                p = s;
            }
        }
        return head;
    }
}
