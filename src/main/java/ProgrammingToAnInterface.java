interface displayModule
{
    public void display();
}

class Monitor implements displayModule
{
    public void display()
    {
        System.out.println("Display through Monitor");
    }
}

class Projector implements displayModule
{
    public void display()
    {
        System.out.println("Display through projector");
    }
}


class Computer {
    private displayModule dm;// programming through interface as variable part

    public void setDisplayModule(displayModule dm) {
        this.dm = dm;
    }

    public void display() {
        dm.display();
    }

}

public class ProgrammingToAnInterface {

    public static void main(String[] args) {
        Computer cm =new Computer();
        displayModule dm = new Monitor();
        displayModule dm1 = new Projector();
        cm. setDisplayModule(dm);
        cm. display();
        cm. setDisplayModule(dm1);
        cm. display();

    }
}
