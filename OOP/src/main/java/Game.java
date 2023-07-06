
import Unts.*;

import java.util.ArrayList;
import java.util.Random;

public class Game {
    public static void main(String[] args) {
        Mag valera = new Mag("Valera");
        ArrayList<Unit> armada = new ArrayList<>();
        ArrayList<Unit> federation = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            int r = new Random().nextInt(6);

            switch (r){
                case 0 -> armada.add(new Mag(getName()));
                case 1 -> armada.add(new Hil(getName()));
                case 2 -> armada.add(new Rouge(getName()));
                case 3 -> armada.add(new Sniper(getName()));
                case 4 -> armada.add(new Crossbowman(getName()));
                case 5 -> armada.add(new Peasant(getName()));
            }
            System.out.println(armada.get(i).getInfo());

        }



    }
    private static String getName(){
        return String.valueOf(Name.values()[new Random().nextInt(Name.values().length)]);
    }
}