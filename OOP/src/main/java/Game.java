
import Unts.*;

import java.util.ArrayList;
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
            System.out.println(armada.get(i).getInfo());


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
            System.out.println(armada.get(i).getInfo());


        }
        printMinPosition(armada.get(0), federation);
    }
    private static String getName(){
        return String.valueOf(Name.values()[new Random().nextInt(Name.values().length)]);
    }

    private static void printMinPosition (Unit unit, ArrayList<Unit> units){
        int ind = (int) unit.getMinPosition(units)[0];
        double size = unit.getMinPosition(units)[1];
        System.out.println("Ближайшим противником к персонажу "+ unit.getInfo()+" является "+units.get(ind).getInfo()+
                ", их дистанция = " + size);




    }
}