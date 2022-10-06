package com.droid;
import java.util.Random;
public class Helper extends Droid{
    private final int giveHealth;
    public Helper(String name) {
        super(name);
        this.giveHealth = 5;
    }
    public int getGiveHealth(){
        return giveHealth;
    }

}
