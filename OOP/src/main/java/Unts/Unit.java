package Unts;


import java.util.ArrayList;

public abstract class Unit implements GameInterface {
    protected String name;
    protected double hp;
    protected double max_hp;
    protected int speed;// очередность хода
    protected int dmg;
    protected String condition;
    protected Unit target;
    protected double min;
    protected Coordinates coordinates;
    protected Unit(String name, int x, int y){
        this.name = name;
        this.hp = 20;
        this.max_hp = 20;
        this.speed = 1;
        this.dmg =1;
        this.condition = "Stand";
        this.target = null;


        coordinates = new Coordinates(x,y);
    }

    public int move(){
        return 1;
    }


    public Unit getMinPosition(ArrayList<Unit> list){
        min = 1000;
        int index =0;
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).hp>0) {
                double temp = Math.sqrt(
                        (Math.pow((list.get(i).coordinates.x - this.coordinates.x), 2) +
                                Math.pow((list.get(i).coordinates.y - this.coordinates.y), 2)));
                //System.out.println(list.get(i).getInfo() + temp);
                if (temp < min) {
                    index = i;
                    min = temp;

                }
            }
        }
        if (list.get(index).hp == 0) return null;
        return list.get(index) ;
    }

    public int [] getCoordinates() {
        return new int[]{coordinates.x,coordinates.y};
    }

    public double getHp() {
        return hp;
    }
    public int getDmg() {
        return dmg;
    }
    public void getDamage(int dmg) {
        hp -= dmg;
        if (hp < 0 ) {
            hp = 0;
        }
        if(this.hp > max_hp) {
            hp = max_hp;
        }

    }
    public int getSpeed(){
        return this.speed;
    }
    public String getCondition() {
        return condition;
    }
    public Unit getTarget() {
        return target;
    }
    public String toString(){
        return getClass().getSimpleName();
    }

}
