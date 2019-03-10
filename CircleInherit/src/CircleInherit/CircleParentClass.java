package CircleInherit;

public class CircleParentClass {

    private double radius;
    double circleArea;

    public CircleParentClass() {

    }

    public void setRadius(double radius) {
        this.radius = radius;
        circleArea = 3.14*radius*radius;
    }

    public double getRadius() {
        return this.radius;
    }
    
    public double findCircleArea() {
        return circleArea;
    }
}
