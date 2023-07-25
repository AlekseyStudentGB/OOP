package Unts;

import java.util.ArrayList;

public class Rouge extends Unit {

    public int dopPoint;
    public Rouge (String name, int x, int y) {
        super(name, x, y);
        this.hp *= 30;

        this.max_hp *= 30;
        this.speed *= 6;
        this.dmg *= 18;
    }

    @Override
    public void step(ArrayList<Unit> list,ArrayList<Unit> team) {
        if(this.hp > 0) {
            target = getMinPosition(list);
            if (target == null){
                condition ="stand";
            }else {
                if (min < 2) {
                    target.getDamage(dmg);
                    condition = "бил вражину";
                    System.out.println(getInfo() + " бьет " + target.getInfo()+" и наносит "+dmg);
                    if (target.hp <= 0) {
                        target.condition = "dead";
                    }
                } else {
                    if (target.coordinates.x != coordinates.x) {
                        if (radarX(team, target)) {
                            if (coordinates.x - target.coordinates.x < 0) {
                                coordinates.x += 1;
                                System.out.println(getInfo()+ " идет на юг");

                            } else {
                                coordinates.x -= 1;
                                System.out.println(getInfo()+ " идет на север");
                            }
                            condition = "go";
                        } else condition = "Stead";


                    } else {
                        if (coordinates.y != target.coordinates.y) {
                            if (coordinates.y < target.coordinates.y) {
                                if (radarY(team, target)) {
                                    coordinates.y += 1;
                                    System.out.println(getInfo()+ " идет на восток");
                                    condition = "go";

                                }
                            } else {
                                if (radarY(team, target)) {
                                    coordinates.y -= 1;
                                    System.out.println(getInfo()+ " идет на запад");
                                    condition = "go";
                                }
                            }

                        }
                    }
                }
            }
            }
            target = null;

        }




    @Override
    public String getInfo() {
        return "Бандит"+ name+" [ hp: "+ this.hp + "] " + condition;
    }
    public boolean radarX(ArrayList<Unit>team, Unit target){
        for (Unit unit:team){
            if (coordinates.x - target.coordinates.x < 0){
                if (unit.coordinates.x ==coordinates.x+1 && unit.coordinates.y== coordinates.y)return false;

            }else {if (unit.coordinates.x ==coordinates.x-1 && unit.coordinates.y== coordinates.y)return false;}
        }
        return true;
    }
    public boolean radarY(ArrayList<Unit>team, Unit target){
        for (Unit unit:team){
            if (coordinates.y - target.coordinates.y < 0){
                if (unit.coordinates.y ==coordinates.y+1 && unit.coordinates.x== coordinates.x)return false;

            }else {if (unit.coordinates.y ==coordinates.y-1 && unit.coordinates.x== coordinates.x)return false;}
        }
        return true;
    }
}
