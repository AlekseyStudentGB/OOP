package Unts;

public class Hil extends Unit {
    public int mana;

    public Hil (String name){
        super(name);

    }

    @Override
    public void step() {

    }

    @Override
    public String getInfo() {
        return "Хилка"+ name;
    }
}
