package Unts;

public class Sniper extends Unit {


    public Sniper(String name, int x, int y) {
        super(name, x, y);
    }

    @Override
    public void step() {

    }

    @Override
    public String getInfo() {
        return "Стрелок"+ name;
    }
}
