package Unts;

public class Peasant extends Unit {


    public Peasant(String name, int x, int y) {
        super(name, x, y);
    }

    @Override
    public void step() {

    }

    @Override
    public String getInfo() {
        return "Работяга"+ name;
    }
}

