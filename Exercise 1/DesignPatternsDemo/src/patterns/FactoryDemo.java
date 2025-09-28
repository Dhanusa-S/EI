package patterns;

// Product
interface Shape {
    void draw();
}

// Concrete Products
class Circle implements Shape {
    public void draw() {
        System.out.println("Drawing a Circle");
    }
}

class Square implements Shape {
    public void draw() {
        System.out.println("Drawing a Square");
    }
}

// Creator
class ShapeFactory {
    public static Shape getShape(String type) {
        if (type.equalsIgnoreCase("circle")) return new Circle();
        else if (type.equalsIgnoreCase("square")) return new Square();
        else return null;
    }
}

// Client
public class FactoryDemo {
    public static void main(String[] args) {
        Shape s1 = ShapeFactory.getShape("circle");
        s1.draw();

        Shape s2 = ShapeFactory.getShape("square");
        s2.draw();
    }
}
