package Unts;

public class Peasant extends Unit {


    public Peasant(String name) {
        super(name);
    }

    @Override
    public void step() {

    }

    @Override
    public String getInfo() {
        return "Работяга"+ name;
    }
}

