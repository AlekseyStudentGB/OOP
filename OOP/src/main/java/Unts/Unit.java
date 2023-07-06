package Unts;


public abstract class Unit implements GameInterface {
    protected String name;

    protected int hp;

    protected float speed;// очередность хода

    protected int power; // множитель атаки

    protected int point;/// очки действий
    protected  int position;

    protected Unit(String name){
        this.name = name;

    }

    public int move(){
        return 1;
    }
    public int attack(){
        return 1;
    }

}
