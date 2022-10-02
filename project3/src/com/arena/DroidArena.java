package com.arena;
import com.droid.Droid;
import java.util.Random;
import java.util.concurrent.TimeUnit;
public class DroidArena {
    private static  Droid droid1;
    private static  Droid droid2;
    private static Droid attacker;
    private static Droid defender;
    private static int currentRound = 0;
    public DroidArena(Droid droid1, Droid droid2){
        this.droid1 = droid1;
        this.droid2 = droid2;
    }

    public Droid fightOne() throws InterruptedException {
        do {
            prepareRound();
            Droid current=initFighters();
            int actualDamage = current.getDemageFrom(attacker);
            printRoundInfo(actualDamage);

            TimeUnit.SECONDS.sleep(1);
        } while (defender.isAlive());
        return attacker;
    }

    public static void prepareRound() {
        initFighters();
        currentRound++;
        System.out.println("-------------------------------------");
        System.out.println("Round " + currentRound);
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
    private void printRoundInfo(int actualDamage) {
        System.out.println(defender.getName() + " get hit with " + defender.getDamage() + " damage");
        System.out.println("Defender health - " + actualDamage);
        System.out.println("Attacker health - " + attacker.getHealth());
    }
}
