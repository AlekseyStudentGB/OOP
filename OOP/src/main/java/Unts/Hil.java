package Unts;

import java.util.ArrayList;

public class Hil extends Unit {
    public int mana;

    public Hil (String name, int x, int y){
        super(name, x, y);
        this.hp *= 1.5;
        this.max_hp *= 1.5;
        this.speed *= 3;
        this.dmg *= 8;

    }

    @Override
    public void step(ArrayList<Unit> list,ArrayList<Unit> team) {

    }

    @Override
    public String getInfo() {
        return "Хилка"+ name;
    }
}
