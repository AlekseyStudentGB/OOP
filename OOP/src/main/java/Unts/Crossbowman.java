package Unts;

import java.util.ArrayList;

public class Crossbowman extends Unit {
    private int strela;

    public Crossbowman(String name, int x, int y) {
        super(name, x, y);
        this.hp *= 1.75;
        this.max_hp *= 1.5;
        this.speed *= 2;
        this.dmg *= 12;
        this.strela = 5;
    }

    @Override
    public void step(ArrayList<Unit> list,ArrayList<Unit> team) {
        if(this.hp > 0 & strela > 0 ) {
            Unit target = getMinPosition(list);
            target.getDamage(dmg);
            System.out.println(target.getInfo()+" получает урон "+ dmg + " оcт здоровья " + target.hp);
            this.strela -= 1;
            if (findPeasant(team)){
                System.out.println(getInfo() + "после атаки зовет крестьян");
            };

        }

    }

    @Override
    public String getInfo() {
        return "Мазила"+ name +" имеет " + strela + " пулек ";
    }

    public boolean findPeasant(ArrayList<Unit> team){
        for (int i = 0; i < team.size() ; i++) {

            if (team.get(i).getClass().getSimpleName() == "Peasant" & team.get(i).hp > 0){};
            return true;
        }
        return false;
    }
}
