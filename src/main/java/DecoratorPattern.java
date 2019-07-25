// https://www.java67.com/2013/07/decorator-design-pattern-in-java-real-life-example-tutorial.html
import java.math.BigDecimal;


abstract class Sandwich {
    protected String description = "Sandwich";

    public String getDescription(){
        return description;
    }

    public abstract BigDecimal price();
}

class WhiteBreadSandWich extends Sandwich {

    public WhiteBreadSandWich(String desc){
        description = desc;
    }

    @Override
    public BigDecimal price() {
        return new BigDecimal("3.0");
    }

}

abstract class SandWichDecorator extends Sandwich {

    @Override
    public abstract BigDecimal price();

}

class CheeseDecorator extends SandWichDecorator{
    private Sandwich currentSandwich;

    public CheeseDecorator(Sandwich sw){
        currentSandwich = sw;
    }

    @Override
    public String getDescription(){
        return currentSandwich.getDescription() + ", Cheese";
    }
    @Override
    public BigDecimal price() {
        return currentSandwich.price().add(new BigDecimal("0.50"));
    }

}


interface Car {

    public void assemble();
}

class BasicCar implements Car {

    @Override
    public void assemble() {
        System.out.print("Basic Car.");
    }

}

class CarDecorator implements Car {

    protected Car car;

    public CarDecorator(Car c){
        this.car=c;
    }

    @Override
    public void assemble() {
        this.car.assemble();
    }

}

class SportsCar extends CarDecorator {

    public SportsCar(Car c) {
        super(c);
    }

    @Override
    public void assemble(){
        super.assemble();
        System.out.print(" Adding features of Sports Car.");
    }
}

class LuxuryCar extends CarDecorator {

    public LuxuryCar(Car c) {
        super(c);
    }

    @Override
    public void assemble(){
        super.assemble();
        System.out.print(" Adding features of Luxury Car.");
    }
}



public class DecoratorPattern {

    public static void main(String[] args) {
        Sandwich mySandwich = new WhiteBreadSandWich("White bread Sandwich");
        System.out.printf("Price of %s is $%.2f %n", mySandwich.getDescription(),
                mySandwich.price());

        //adding extra cheese using Decorator Pattter
        mySandwich = new CheeseDecorator(mySandwich);
        System.out.printf("Price of %s is $%.2f %n", mySandwich.getDescription(),
                mySandwich.price());



        Car sportsCar = new SportsCar(new BasicCar());
        sportsCar.assemble();
        System.out.println("\n*****");

        Car sportsLuxuryCar = new SportsCar(new LuxuryCar(new BasicCar()));
        sportsLuxuryCar.assemble();


    }
}
