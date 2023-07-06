package Unts;

public class Crossbowman extends Unit {


    public Crossbowman(String name, int x, int y) {
        super(name, x, y);
    }

    @Override
    public void step() {

    }

    @Override
    public String getInfo() {
        return "Мазила"+ name;
    }
}
