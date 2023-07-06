package Unts;

public class Rouge extends Unit {

    public int dopPoint;
    public Rouge (String name) {
        super(name);
    }

    @Override
    public void step() {

    }

    @Override
    public String getInfo() {
        return "Бандит"+ name;
    }
}
