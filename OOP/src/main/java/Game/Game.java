package Game;

import Unts.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;

public class Game {
    public static ArrayList<Unit> armada = new ArrayList<>();
    public static ArrayList<Unit> federation = new ArrayList<>();
    public static ArrayList<Unit> round = new ArrayList<>();//создаем сценарий на раунд
    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            int r1 = new Random().nextInt(6);
            switch (r1){
                case 0 -> armada.add(new Mag(getName(),1,i+1));
                case 1 -> armada.add(new Hil(getName(), 1, i+1));
                case 2 -> armada.add(new Rouge(getName(), 1, i+1));
                case 3 -> armada.add(new Sniper(getName(), 1, i+1));
                case 4 -> armada.add(new Crossbowman(getName(), 1, i+1));
                case 5 -> armada.add(new Peasant(getName(), 1, i+1));
            }
        }
        for (int i = 0; i < 10; i++) {
            int r1 = new Random().nextInt(6);
            switch (r1){
                case 0 -> federation.add(new Mag(getName(),10,i+1));
                case 1 -> federation.add(new Hil(getName(), 10, i+1));
                case 2 -> federation.add(new Rouge(getName(), 10, i+1));
                case 3 -> federation.add(new Sniper(getName(), 10, i+1));
                case 4 -> federation.add(new Crossbowman(getName(), 10, i+1));
                case 5 -> federation.add(new Peasant(getName(), 10, i+1));
            }
        }
        round.addAll(armada);
        round.addAll(federation);
        round.sort(new Comparator<Unit>() {
            @Override
            public int compare(Unit o1, Unit o2) {
                return o2.getSpeed() -o1.getSpeed();
            }
        });

        Scanner tab = new Scanner(System.in);
        while (true) {
            View.view();
            tab.nextLine();
            for (Unit unit : round) {
                if (federation.contains(unit)) {
                    unit.step(armada, federation);
                    System.out.println(unit.getClass().getSimpleName());
                } else {
                    unit.step(federation, armada);
                }

            }


        }
    }
    ///////////////////////////////////////////////////////
    private static String getName(){
        return String.valueOf(Name.values()[new Random().nextInt(Name.values().length)]);
    }



}