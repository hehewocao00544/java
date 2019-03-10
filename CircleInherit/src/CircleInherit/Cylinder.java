package CircleInherit;

public class Cylinder extends CircleParentClass {
    private double length;
    double cylinderArea;
    
    public Cylinder() {
        super();
    }
    
    public void setLength(double length) {
     
        this.length = length;
        this.cylinderArea =  3.14*getRadius()*getRadius()*length;
    }
    
    public double getLength() {
        return this.length;
    }
    
    public double findCylinderArea() {
        return this.cylinderArea;
    }
}
