package com.arena;
import com.droid.Droid;

import java.io.*;
import java.util.Random;
import java.util.concurrent.TimeUnit;
public class DroidArena {
    private static  Droid droid1;
    private static  Droid droid2;
    private static Droid attacker;
    private static Droid defender;
    private static int currentRound = 0;
    public DroidArena(Droid droid1, Droid droid2){
        DroidArena.droid1 = droid1;
        DroidArena.droid2 = droid2;
    }

    public Droid fightOne() throws InterruptedException, IOException {
        String filename="C:\\Users\\PC\\Desktop\\project3\\battle1v1.txt";
        FileWriter fileWrite=new FileWriter(filename);
        do {
            prepareRound(fileWrite);
            Droid current=initFighters();
            int actualDamage = current.getDemageFrom(attacker);
            printRoundInfo(actualDamage,fileWrite);
            TimeUnit.SECONDS.sleep(1);
        } while (defender.isAlive());
        fileWrite.close();
        return attacker;
    }

    public static void prepareRound(FileWriter file) throws IOException {
        initFighters();
        currentRound++;
        System.out.println("-------------------------------------");
        file.write("\n-------------------------------------\n");
        System.out.println("Round " + currentRound);
        file.write("\nRound " + currentRound);
    }
    private static Droid initFighters() {
        Random random = new Random();
        if (random.nextBoolean()) {
            attacker = droid1;
            return defender = droid2;
        } else {
            attacker = droid2;
            return defender = droid1;
        }
    }
    private void printRoundInfo(int actualDamage, FileWriter file) throws IOException {
        file.write("\n"+ defender.getName() + " get hit with " + defender.getDamage() + " damage");
        file.write("\nDefender health - " + actualDamage);
        file.write("\nAttacker health - " + attacker.getHealth());
        System.out.println(defender.getName() + " get hit with " + defender.getDamage() + " damage");
        System.out.println("Defender health - " + actualDamage);
        System.out.println("Attacker health - " + attacker.getHealth());
    }
}
