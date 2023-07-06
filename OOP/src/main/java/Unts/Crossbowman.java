package Unts;

public class Crossbowman extends Unit {


    public Crossbowman(String name) {
        super(name);
    }

    @Override
    public void step() {

    }

    @Override
    public String getInfo() {
        return "Мазила"+ name;
    }
}
