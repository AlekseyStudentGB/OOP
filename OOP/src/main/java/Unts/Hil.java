package Unts;

public class Hil extends Unit {
    public int mana;

    public Hil (String name, int x, int y){
        super(name, x, y);

    }

    @Override
    public void step() {

    }

    @Override
    public String getInfo() {
        return "Хилка"+ name;
    }
}
