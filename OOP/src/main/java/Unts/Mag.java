package Unts;

import java.util.ArrayList;

public class Mag extends Unit {
    private int mana;
    public Mag (String name, int x, int y){
        super(name, x, y);
        this.hp *= 1.5;
        this.max_hp *= 1.5;
        this.speed *= 3;
        this.dmg *= 8;
    }

    public int control(){
        return 1;
    }

    @Override
    public void step(ArrayList<Unit> list,ArrayList<Unit> team) {

    }

    @Override
    public String getInfo() {
        return "Волшебник"+ name;
    }
}