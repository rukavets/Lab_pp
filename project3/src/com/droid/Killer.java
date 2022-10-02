package com.droid;
import java.util.Random;
public class Killer extends Droid{
    private final int shield;
    public Killer(String name) {
        super(name);
        this.shield=5;
    }
    public int getShield(){return shield;}

    public int getAttack(Droid droid2){
        int actual_damage=droid2.getDamage();
        int actual_health=this.getHealth();
        Random random = new Random();
        actual_health-=actual_damage;
        if(random.nextBoolean()){
            actual_health+=shield;
        }
       return actual_health;
    }

}
