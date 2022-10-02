package com.arena;
import com.droid.Droid;
import com.droid.Helper;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class TeamArena{
    public static ArrayList<Droid> team1;
    public static ArrayList<Droid> team2;
    private static Droid attacker;
    private static Droid defender;
    private static int currentRound = 0;
    public TeamArena(ArrayList<Droid> team1, ArrayList<Droid> team2) {
        this.team1 = team1;
        this.team2 = team2;
    }
    public String teamFight()throws InterruptedException{
        do {
            for(int i=0;i< team1.size();i++) {
                Droid current = initFighters(i);
                if(!current.isAlive()){
                    team1.remove(i);
                    team2.remove(i);
                    i--;
                }else {
                    prepareRound();
                    int actualDamage = current.getDemageFrom(attacker);
                    printRoundInfo(actualDamage);
                    TimeUnit.SECONDS.sleep(1);
                }
            }
        } while (isAliveDroids(team1) && isAliveDroids(team2));
        if(isAliveDroids(team1))return toString1();else return toString2();
    }
    private static Droid initFighters(int index) {
        Random random = new Random();
        if (random.nextBoolean()) {
            attacker = team1.get(index);
            return defender = team2.get(index);
        } else {
            attacker = team2.get(index);
            return defender = team1.get(index);
        }
    }
    public boolean isAliveDroids(ArrayList<Droid> team){
        for(int i=0;i< team.size();i++){
            if(team.get(i).isAlive()){
                return true;
            }
        }
        return false;
    }
    private void printRoundInfo(int actualDamage) {
        System.out.println(defender.getName() + " get hit with " + defender.getDamage() + " damage");
        System.out.println("Defender health - " + actualDamage);
        System.out.println("Attacker health - " + attacker.getHealth());
    }
    public static void prepareRound() {
        currentRound++;
        System.out.println("-------------------------------------");
        System.out.println("Round " + currentRound);
    }
    public String toString1(){
        return "Team1";
    }
    public String toString2(){
        return "Team2";
    }
}
