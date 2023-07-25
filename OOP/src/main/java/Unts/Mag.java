package Unts;

import java.util.ArrayList;

public class Mag extends Unit {
    private int mana;
    public Mag (String name, int x, int y){
        super(name, x, y);
        this.hp *= 1.5;
        this.max_hp *= 1.5;
        this.speed *= 3;
        this.dmg *= -8;
        this.mana = 10;
    }

    public int control(){
        return 1;
    }

    @Override
    public void step(ArrayList<Unit> list,ArrayList<Unit> team) {
        if(this.hp > 0 & this.mana > 0){
            minTargetHil(team);
            System.out.println("mag"+ target);
            if(this.target == null){
                this.target = getMinPosition(list);
                this.target.getDamage(this.dmg* -1);
                if(target.hp<1){target.condition = "dead";}
                mana -= 1;
                System.out.println("dhasda"+ target);
                System.out.println(getInfo()+" бьет "+ target.name+ " и наносит "+ dmg);
                condition = "shot";
            }
            else {
                this.target.getDamage(this.dmg);
                mana -= 2;
                System.out.println(getInfo()+" лечит "+ target.name+ " на "+ dmg);
                this.condition = "Helling";
            }
        }
        else {
            this.condition = "Stand";
        }
        this.target= null;
    }

    @Override
    public String getInfo() {
        return "Волшебник"+ name+" [ hp: "+ this.hp + " | " + "mana: "+ mana + "] " + condition;
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