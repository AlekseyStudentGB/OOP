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
        mana = 20;

    }

    @Override
    public void step(ArrayList<Unit> list,ArrayList<Unit> team) {
        if(this.hp > 0 && this.mana > 0){
            minTargetHil(team);
            System.out.println("mag"+ target);
            if(this.target == null){
                condition = "Stand";
            }
            else {
                this.target.getDamage(this.dmg);
                mana -= 2;
                System.out.println(getInfo()+" лечит "+ target.name+ " на "+ dmg);
                this.condition = "Helling";
                this.target= null;
            }
        }

    }

    @Override
    public String getInfo() {
        return "Хилка" + name +" [ hp: "+ this.hp + " | " + "mana: "+ mana + "] " + condition;
    }
    public void minTargetHil(ArrayList<Unit>team){
        int minHP= 100;
        for (Unit unit:team) {
            if (unit.hp > 0 & unit.hp < unit.max_hp) {
                if(unit.hp/(unit.max_hp/100)<minHP ){
                    this.target = unit;
                }
            }
        }
    }
}
