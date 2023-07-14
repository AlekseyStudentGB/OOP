
import Unts.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class Game {
    public static void main(String[] args) {
        ArrayList<Unit> armada = new ArrayList<>();
        ArrayList<Unit> federation = new ArrayList<>();
        System.out.println("""               
Команда армады :
""");
        for (int i = 0; i < 10; i++) {
            int r1 = new Random().nextInt(6);
            switch (r1){
                case 0 -> armada.add(new Mag(getName(),0,i));
                case 1 -> armada.add(new Hil(getName(), 0, i));
                case 2 -> armada.add(new Rouge(getName(), 0, i));
                case 3 -> armada.add(new Sniper(getName(), 0, i));
                case 4 -> armada.add(new Crossbowman(getName(), 0, i));
                case 5 -> armada.add(new Peasant(getName(), 0, i));
            }
        }
        for (Unit unit: armada) {
            System.out.println(unit.getInfo());
        }
        System.out.println("""
               
Команда федерации :
""");
        for (int i = 0; i < 10; i++) {
            int r1 = new Random().nextInt(6);
            switch (r1){
                case 0 -> federation.add(new Mag(getName(),10,i));
                case 1 -> federation.add(new Hil(getName(), 10, i));
                case 2 -> federation.add(new Rouge(getName(), 10, i));
                case 3 -> federation.add(new Sniper(getName(), 10, i));
                case 4 -> federation.add(new Crossbowman(getName(), 10, i));
                case 5 -> federation.add(new Peasant(getName(), 10, i));
            }

        }

        for (Unit unit: federation) {
            System.out.println(unit.getInfo());
        }
        System.out.println(federation.get(0).getClass().getSimpleName());
        System.out.println(federation.get(0).getInfo());

        ArrayList<Unit> round = new ArrayList<>();//создаем сценарий на раунд

        for (int i = 0; i < federation.size(); i++) {
            if (federation.get(i).getHp() > 0) {
                round.add(federation.get(i));
            }
            if (armada.get(i).getHp()> 0){
                round.add(armada.get(i));
            }
        }
        round.sort(new Comparator<Unit>() {
            @Override
            public int compare(Unit o1, Unit o2) {
                return o1.getSpeed() -o2.getSpeed();
            }
        });

        for (Unit unit : round){
            if (federation.contains(unit)) {
                unit.step(armada,federation);
            }
            else {
                unit.step(federation,armada);
            }
        }

    }
    ///////////////////////////////////////////////////////
    private static String getName(){
        return String.valueOf(Name.values()[new Random().nextInt(Name.values().length)]);
    }



}