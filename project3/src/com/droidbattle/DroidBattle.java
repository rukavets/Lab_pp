package com.droidbattle;
import com.arena.DroidArena;
import com.droid.Droid;
import com.droid.Helper;
import com.droid.Killer;

public class DroidBattle {
    public static final String CYAN_BOLD_BRIGHT = "\033[1;96m";
    public static final String ANSI_RESET = "\u001B[0m";
    public void autobattle() throws InterruptedException {
        Droid droid1=new Droid("droid1");
        Droid droid2= new Droid("droid2");
        DroidArena arena= new DroidArena(droid1,droid2);
        Droid winner= arena.fightOne();
        System.out.println("--------------");
        System.out.println(CYAN_BOLD_BRIGHT+" The winner is " + winner.getName()+ANSI_RESET);
    }
    public void manualbattle(int selector1, int selector2) throws InterruptedException{
        Droid droid1=createDroid(selector1);
        Droid droid2=createDroid(selector2);
        DroidArena arena= new DroidArena(droid1,droid2);
        Droid winner= arena.fightOne();
        System.out.println("--------------");
        System.out.println(CYAN_BOLD_BRIGHT+" The winner is " + winner.getName()+ANSI_RESET);
    }
    public Droid createDroid(int selector){

        switch (selector){
            case(1):
                Droid droid1=new Droid("Droid");
                return droid1;
            case(2):
                Killer droid2=new Killer("Killer");
                return droid2;
            case(3):
                Helper droid3=new Helper("Helper");
                return droid3;
        }
       return null;
    }

}
