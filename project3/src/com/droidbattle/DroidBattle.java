package com.droidbattle;
import com.arena.DroidArena;
import com.droid.Droid;
import com.droid.Helper;
import com.droid.Killer;

import java.io.*;

public class DroidBattle {
    public static final String CYAN_BOLD_BRIGHT = "\033[1;96m";
    public static final String ANSI_RESET = "\u001B[0m";
    public void autobattle() throws InterruptedException, IOException {
        Droid droid1=new Droid("droid1");
        Droid droid2= new Droid("droid2");
        DroidArena arena= new DroidArena(droid1,droid2);
        Droid winner = arena.fightOne();
        System.out.println("--------------");
        System.out.println(CYAN_BOLD_BRIGHT+" The winner is " + winner.getName()+ANSI_RESET);
        PrintWriter printrecord=new PrintWriter(new BufferedWriter(new FileWriter("battle1v1.txt",true )));
        printrecord.println("\n--------------");
        printrecord.println("The winner is " + winner.getName());
        printrecord.close();
    }
    public void manualbattle(int selector1, int selector2) throws InterruptedException, IOException {
        Droid droid1=createDroid(selector1);
        Droid droid2=createDroid(selector2);
        DroidArena arena= new DroidArena(droid1,droid2);
        Droid winner= arena.fightOne();
        System.out.println("--------------");
        System.out.println(CYAN_BOLD_BRIGHT+" The winner is " + winner.getName()+ANSI_RESET);
        PrintWriter printrecord=new PrintWriter(new BufferedWriter(new FileWriter("battle1v1.txt",true )));
        printrecord.println("\n--------------");
        printrecord.println("The winner is " + winner.getName());
        printrecord.close();
    }
    public Droid createDroid(int selector){
        switch (selector){
            case(1):
                return new Droid("Droid");
            case(2):
                return new Killer("Killer");
            case(3):
                return new Helper("Helper");
        }
       return null;
    }

}
