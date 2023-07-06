package Unts;

public class Sniper extends Unit {


    public Sniper(String name) {
        super(name);
    }

    @Override
    public void step() {

    }

    @Override
    public String getInfo() {
        return "Стрелок"+ name;
    }
}
