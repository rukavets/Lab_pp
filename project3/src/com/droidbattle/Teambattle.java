package com.droidbattle;
import com.arena.DroidArena;
import com.arena.TeamArena;
import com.droid.Droid;
import com.droid.Helper;
import com.droid.Killer;
import java.util.ArrayList;

public class Teambattle{
    public static final String CYAN_BOLD_BRIGHT = "\033[1;96m";
    public static final String ANSI_RESET = "\u001B[0m";
    public void standartBattle() throws InterruptedException {
        ArrayList<Droid> team1=createTeem();
        ArrayList<Droid> team2=createTeem();
        TeamArena arena= new TeamArena(team1,team2);
        printStandartTeam();
        String winner= arena.teamFight();
        System.out.println("--------------");
        System.out.println(CYAN_BOLD_BRIGHT+" The winner is " + winner+ANSI_RESET);
    }
    public ArrayList<Droid> createTeem(){
        Droid droid1=new Droid("droid1");
        Droid droid2= new Droid("droid2");
        Killer killer= new Killer("Killer");
        Helper helper= new Helper("Helper");
        ArrayList<Droid>team1=new ArrayList<>();
        team1.add(droid1);
        team1.add(droid2);
        team1.add(killer);
        team1.add(helper);
        return team1;
    }
    public void printStandartTeam(){
        System.out.println("\nStandart team");
        System.out.println("1. Standart droid\n2. Standart droid\n3. Killer\n4.Helper");
    }
}

