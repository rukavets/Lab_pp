package com.arena;
import com.droid.Droid;
import com.droid.Helper;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class TeamArena{
    public static List<Droid> team1;
    public static List<Droid> team2;
    private static Droid attacker;
    private static Droid defender;
    private static int currentRound = 0;
    public TeamArena(List<Droid> team1, List<Droid> team2) {
        TeamArena.team1 = team1;
        TeamArena.team2 = team2;
    }
    public String teamFight() throws InterruptedException, IOException {
        String filename="C:\\Users\\PC\\Desktop\\project3\\battleTeam.txt";
        FileWriter fileWrite=new FileWriter(filename);
        do {
            for(int i=0;i< team1.size();i++) {
                Droid current = initFighters(i);
                if(!current.isAlive()||!attacker.isAlive()){
                    team1.remove(i);
                    team2.remove(i);
                    i--;
                }else {
                    prepareRound(fileWrite);
                    int actualDamage = current.getDemageFrom(attacker);
                    printRoundInfo(actualDamage,fileWrite);
                    TimeUnit.SECONDS.sleep(1);
                }
            }
        } while (isAliveDroids(team1) && isAliveDroids(team2));
        fileWrite.close();
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
    public boolean isAliveDroids(List<Droid> team){
        for (Droid droid : team) {
            if (droid.isAlive()) {
                return true;
            }
        }
        return false;
    }
    private void printRoundInfo(int actualDamage, FileWriter file) throws IOException {
        file.write("\n"+ defender.getName() + " get hit with " + defender.getDamage() + " damage");
        file.write("\nDefender health - " + actualDamage);
        file.write("\nAttacker health - " + attacker.getHealth());
        System.out.println(defender.getName() + " get hit with " + defender.getDamage() + " damage");
        System.out.println("Defender health - " + actualDamage);
        System.out.println("Attacker health - " + attacker.getHealth());
    }
    public static void prepareRound(FileWriter file) throws IOException {
        currentRound++;
        System.out.println("-------------------------------------");
        System.out.println("Round " + currentRound);
        file.write("\n-------------------------------------\n");
        file.write("\nRound " + currentRound);
    }
    public String toString1(){
        return "Team1";
    }
    public String toString2(){
        return "Team2";
    }
}
