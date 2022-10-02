package com.droid;
import java.util.Random;
public class Droid {
    private String name;
    private int health;
    private int damage;

    public Droid(String name) {
        this.name = name;
        this.health = 30;
        this.damage = 5;
    }

    public String getName() {return name;}
    public int getDamage() {return damage;}
    public int getHealth() {return health;}
    public void setHealth(int health){this.health=health;}

    public int getDemageFrom(Droid droid2){
        Random random=new Random();
        int actual_damage= droid2.getDamage();
        if(droid2 instanceof Killer){
            if(random.nextBoolean()){
                health =0;
            }
        }else {
            this.health -= actual_damage;
            this.health = health;
            if (health < 0) {
                health = 0;
            }
        }
        return health;
    }
    public String toString(){return name + health;}
    public boolean isAlive() {
        if(this.health>0) {
            return this.health>0;
        }
        return false;
    }
}
