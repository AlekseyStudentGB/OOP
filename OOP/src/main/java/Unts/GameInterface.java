package Unts;

import java.util.ArrayList;

public interface GameInterface {
    void step(ArrayList<Unit> list,ArrayList<Unit> team);

     String getInfo();
}