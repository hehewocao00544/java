package LinkList;

public class Node {
    
    private int data;
    
    Node next = null;
    
    public Node(){
        
    }
    
    public Node(int data) {
        this.data = data;
    }
    
    public void setData(int data) {
        this.data = data;
    }
    
    public int getData() {
        return this.data;
    }
}
