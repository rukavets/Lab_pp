package com.droid;
import java.util.Random;
public class Helper extends Droid{
    public int giveHealth;
    public Helper(String name) {
        super(name);
        this.giveHealth=5;
    }
    public int getGiveHealth(){return giveHealth;}

    public int getAttackFrom(Droid droid2){
        Random random = new Random();
        int actual_health=this.getHealth();
        if(droid2 instanceof Killer){
            if(random.nextBoolean()){
                actual_health=0;
            }
        }
        actual_health-= droid2.getDamage();
        return actual_health;
    }
}
