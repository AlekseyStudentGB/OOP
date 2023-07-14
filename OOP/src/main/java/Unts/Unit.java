package Unts;


import java.util.ArrayList;

public abstract class Unit implements GameInterface {
    protected String name;
    protected int hp;
    protected int max_hp;
    protected int speed;// очередность хода
    protected int dmg;

    protected Coordinates coordinates;
    protected Unit(String name, int x, int y){
        this.name = name;
        this.hp = 20;
        this.max_hp = 20;
        this.speed = 1;
        this.dmg =1;

        coordinates = new Coordinates(x,y);
    }

    public int move(){
        return 1;
    }


    public Unit getMinPosition(ArrayList<Unit> list){
        double min = 1000;
        int index =0;
        for (int i = 0; i < list.size(); i++) {
            double temp = Math.sqrt(
                    (Math.pow((list.get(i).coordinates.x - this.coordinates.x),2)+
                    Math.pow((list.get(i).coordinates.y- this.coordinates.y),2)));
            System.out.println(list.get(i).getInfo() + temp);
            if (temp<min){
                index = i;
                min = temp;

            }
        }

        return list.get(index) ;
    }


    public int getHp() {
        return hp;
    }
    public int getDmg() {
        return dmg;
    }
    public void getDamage(int dmg) {
        if (this.hp - dmg < 0 ) {
            this.hp = 0;
        }
        if(this.hp - dmg > this.max_hp) {
            this.hp = this.max_hp;
        }
        this.hp -= dmg;
    }

    public int getSpeed(){
        return this.speed;
    }

}
