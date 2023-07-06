package Unts;

public class Mag extends Unit {
    private int mana;
    public Mag (String name, int x, int y){
        super(name, x, y);
    }

    public int control(){
        return 1;
    }

    @Override
    public void step() {

    }

    @Override
    public String getInfo() {
        return "Волшебник"+ name;
    }
}