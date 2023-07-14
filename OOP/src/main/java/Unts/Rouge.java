package Unts;

import java.util.ArrayList;

public class Rouge extends Unit {

    public int dopPoint;
    public Rouge (String name, int x, int y) {
        super(name, x, y);
        this.hp *= 2.5;
        this.max_hp *= 2.5;
        this.speed *= 2;
        this.dmg *= 18;
    }

    @Override
    public void step(ArrayList<Unit> list,ArrayList<Unit> team) {
        if(this.hp > 0) {

        }


    }

    @Override
    public String getInfo() {
        return "Бандит"+ name;
    }
}
