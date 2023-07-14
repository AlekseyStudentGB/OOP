package Unts;

import java.util.ArrayList;

public class Peasant extends Unit {


    public Peasant(String name, int x, int y) {
        super(name, x, y);

        this.speed *= 4;
        this.dmg *= 0;
    }

    @Override
    public void step(ArrayList<Unit> list,ArrayList<Unit> team) {
        if(this.hp > 0) {

        }
    }

    @Override
    public String getInfo() {
        return "Работяга"+ name;
    }
}

