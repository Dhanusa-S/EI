package patterns;

// Component
interface Coffee {
    String getDescription();
    double getCost();
}

// Concrete Component
class BasicCoffee implements Coffee {
    public String getDescription() { return "Basic Coffee"; }
    public double getCost() { return 50.0; }
}

// Decorator
abstract class CoffeeDecorator implements Coffee {
    protected Coffee coffee;
    public CoffeeDecorator(Coffee coffee) { this.coffee = coffee; }
    public String getDescription() { return coffee.getDescription(); }
    public double getCost() { return coffee.getCost(); }
}

// Concrete Decorators
class MilkDecorator extends CoffeeDecorator {
    public MilkDecorator(Coffee coffee) { super(coffee); }
    public String getDescription() { return super.getDescription() + ", Milk"; }
    public double getCost() { return super.getCost() + 10; }
}

class SugarDecorator extends CoffeeDecorator {
    public SugarDecorator(Coffee coffee) { super(coffee); }
    public String getDescription() { return super.getDescription() + ", Sugar"; }
    public double getCost() { return super.getCost() + 5; }
}

// Client
public class DecoratorDemo {
    public static void main(String[] args) {
        Coffee coffee = new BasicCoffee();
        coffee = new MilkDecorator(coffee);
        coffee = new SugarDecorator(coffee);

        System.out.println("Order: " + coffee.getDescription());
        System.out.println("Cost: ₹" + coffee.getCost());
    }
}
