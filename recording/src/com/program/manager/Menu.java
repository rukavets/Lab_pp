package com.program.manager;

import com.program.command.*;
import com.program.command.redoAble.*;
import com.program.entity.Disk;

import java.util.*;

public class Menu {

    private Menu(){}

    private static Disk disk = new Disk();
    private static boolean IsRunning = true;

    public static void run(){
        while (IsRunning){
            printMenu();
            perform(getInput());
        }
    }

    private static void printMenu(){
        System.out.println("\n┌----------------------------------------┐");
        System.out.println("| 1)Вивести всі композиції               |");
        System.out.println("| 2)Додати композиції                    |");
        System.out.println("| 3)Підрахувати тривалість компзиції     |");
        System.out.println("| 4)Відсортувати по стилях               |");
        System.out.println("| 5)Пошук по діапазону                   |");
        System.out.println("| 6)Видалення компохицій                 |");
        System.out.println("| 7)Скасувати вибір                      |");
        System.out.println("| 8)Зберегти плейлист                    |");
        System.out.println("|                                        |");
        System.out.println("| 0)Вихід                                |");
        System.out.println("└----------------------------------------┘");
        System.out.print(">");
    }

    public static int getInput(){
        int input;
        Scanner scanner = new Scanner(System.in);
        boolean check = false;

        do{
            if(check){
                System.out.println("\tПомилка!\nНеправильний ввід....");
                System.out.print(">");
            }
            input = scanner.nextInt();
            check = true;
        }while (input>8 || input<0);

        return input;
    }

    public static void perform(int input){
        Command command = null;
        switch (input){
            case(0):
                command = new ExitCommand(disk);
                break;
            case (1):
                command = new PrintCommand(disk);
                break;
            case(2):
                int input1;
                System.out.print("\n\tЯк саме додати?\n 1)Через файл\n 2)Клавіатурою\n>");
                Scanner scanner = new Scanner(System.in);
                boolean check = false;

                do{
                    if(check){
                        System.out.print("\tПомилка! \nНеправильний ввід\n>");
                    }
                    input1 = scanner.nextInt();
                    check = true;
                }while (input1>2 || input1<1);

                if(input1==1){
                    command= new FileReaderCommand(disk);
                }else{
                    command = new KeyboardReaderCommand(disk);
                }
                break;
            case(3):
                command = new CountDurationCommand(disk);
                break;
            case (4):
                command = new SortCommand(disk);
                break;
            case(5):
                command = new FindInRangeCommand(disk);
                break;
            case (6):
                command = new DeleteCommand(disk);
                break;
            case (7):
                command = new UndoCommand(disk);
                break;
            case (8):
                command = new SaveCommand(disk);
                break;
            default:
                System.out.println("Idk how u could possibly do this....\n\tThat`s error.");}
        if(input == 2 || input == 4 || input==6){
            UndoManager.add(command);}
        if(command != null) {
            command.execute();
        }
    }

    public static boolean getIsRunning() {
        return IsRunning;}

    public static void setIsRunning(boolean isRunning) {
        IsRunning = isRunning;
    }

    public static Disk getDisk() {
        return disk;}

    public static void setDisk(Disk disk) {
        Menu.disk = disk;}
}

