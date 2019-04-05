package LinkList;

public class LinkListDemo {

    public static void main(String[] args) {
        
        Node head = new Node();
        Node p = new Node();
        CreateLinkList cll = new CreateLinkList();
        head = cll.createLinkList(head);
        p = head;
        while(p.next!=null) {
            System.out.print(p.next.getData() + "   ");
            p = p.next;
        }
    }
}
