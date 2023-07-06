package Unts;

public class Rouge extends Unit {

    public int dopPoint;
    public Rouge (String name, int x, int y) {
        super(name, x, y);
    }

    @Override
    public void step() {

    }

    @Override
    public String getInfo() {
        return "Бандит"+ name;
    }
}
