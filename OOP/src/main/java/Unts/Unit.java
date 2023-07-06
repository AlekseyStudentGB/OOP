package Unts;


import java.util.ArrayList;

public abstract class Unit implements GameInterface {
    protected String name;

    protected int hp;

    protected float speed;// очередность хода

    protected int power; // множитель атаки

    protected int point;/// очки действий
    protected  int position;

    protected Coordinates coordinates;
    protected Unit(String name, int x, int y){
        this.name = name;
        coordinates = new Coordinates(x,y);
    }

    public int move(){
        return 1;
    }
    public int attack(){
        return 1;
    }

    public double[] getMinPosition(ArrayList<Unit> list){
        double min = 1000;
        double index =0;
        for (int i = 0; i < list.size(); i++) {
            double temp = Math.sqrt(
                    (Math.pow(list.get(i).coordinates.x,2)-Math.pow(this.coordinates.x,2))+
                    (Math.pow(list.get(i).coordinates.y,2)-Math.pow(this.coordinates.y,2))
            );

            if (temp<min){
                index = i;
                min = temp;
            }
        }
        return new double[]{index, min} ;
    }



}
