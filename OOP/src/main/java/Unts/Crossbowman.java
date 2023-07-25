package Unts;

import java.util.ArrayList;

public class Crossbowman extends Unit {
    private int strela;

    public Crossbowman(String name, int x, int y) {
        super(name, x, y);
        this.hp *= 1.75;
        this.max_hp *= 1.5;
        this.speed = 5;
        this.dmg *= 12;
        this.strela = 5;
    }

    @Override
    public void step(ArrayList<Unit> list,ArrayList<Unit> team) {
        if(this.hp > 0 && strela > 0 ) {
            this.target = getMinPosition(list);
            if(this.target!=null && target.hp > 0) {
                target.getDamage(dmg);
                if(target.hp<1){target.condition = "dead";}
                this.condition = "shot";

                System.out.println(getInfo() + target.getInfo() + " получает урон " + dmg + " оcт здоровья " + target.hp);
                this.strela -= 1;

                if (findPeasant(team)) {
                    System.out.println(getInfo() + "после атаки зовет крестьян");
                    this.strela += 1;
                }else System.out.println(getInfo()+ "крестьянина не нашел");

            }else condition =  "Stand";
        }

    }

    @Override
    public String getInfo() {
        return "Мазила"+ name +" [ hp: "+ this.hp + " | " + "пулек: "+ strela + "] " + condition +" ";
    }

    public boolean findPeasant(ArrayList<Unit> team){
        for (Unit unit: team) {

            if (unit.getClass().getSimpleName().equals("Peasant")
                    & unit.hp > 0
                    & unit.condition =="Stand"){
                unit.condition = "Running";
                return true;
            }

        }
       return false;
    }
}
