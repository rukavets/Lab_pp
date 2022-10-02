package com.droidbattle;
import java.util.Scanner;
public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static int choise;
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String YELLOW_BOLD_BRIGHT = "\033[1;93m";
    public static final String CYAN_BOLD_BRIGHT = "\033[1;96m";
    public static void main(String[] args) throws InterruptedException {
        choise=menu();
        switch (choise){
            case(1):
                chooseDroids();
                choise=menu();
            case(2):
                System.out.println(YELLOW_BOLD_BRIGHT +"    START A 1v1 BATTLE"+ANSI_RESET);
                new DroidBattle().autobattle();
                break;
            case(3):
                System.out.println(YELLOW_BOLD_BRIGHT+"     START A 1v1 BATTLE"+ANSI_RESET);
                System.out.println("Choose droids ");
                System.out.println("1. Standart droid\n2. Killer\n3.Helper");
                int selector1 = scanner.nextInt();
                int selector2 = scanner.nextInt();
                new DroidBattle().manualbattle(selector1,selector2);
                break;
            case(4):
                System.out.println(YELLOW_BOLD_BRIGHT+"     START A TEAM BATTLE"+ANSI_RESET);
                new Teambattle().standartBattle();
                break;
            case(5):
                break;
        }

    }
    public static int menu() {
        System.out.println();
        System.out.println("Input what you want to do: ");
        System.out.println("1 - Print list of available droids");
        System.out.println("2 - Start a 1v1 fight(automated team setup)");
        System.out.println("3 - Start a 1v1 fight(manual team setup)");
        System.out.println("4 - Start a teamfight");
        System.out.println("5 - Exit the program");
        return scanner.nextInt();
    }
    public static void chooseDroids(){
        System.out.println(CYAN_BOLD_BRIGHT+ "   List of droids: "+ANSI_RESET);
        System.out.println("1. Standart droid\n2. Killer\n3. Helper");
        int selector1 = scanner.nextInt();
        int selector2 = scanner.nextInt();
    }
}
